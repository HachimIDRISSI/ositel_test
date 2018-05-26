package excel.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import metier.CellUpdate;
import metier.MyFileName;
import metier.MyList;

public class UpdateExcel {

    public static MyList updateCell(CellUpdate mcell) throws IOException {
        try {
            FileInputStream file = new FileInputStream("uploads/" + mcell.getFilename());

            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Cell cell = null;

            XSSFRow sheetrow = sheet.getRow(mcell.getRow());
            if(sheetrow == null){
                sheetrow = sheet.createRow(mcell.getRow());
            }
            
            //Update the value of cell
            cell = sheetrow.getCell(mcell.getCol());
            if(cell == null){
                cell = sheetrow.createCell(mcell.getCol());
            }
            cell.setCellValue(mcell.getValue());

            file.close();

            FileOutputStream outFile =new FileOutputStream(new File("uploads/" + mcell.getFilename()));
            workbook.write(outFile);
            outFile.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return  ExcelReader.parseFile(new MyFileName(mcell.getFilename()));
    }

}
