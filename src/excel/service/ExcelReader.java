package excel.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import metier.MyFileName;
import metier.MyList;

public class ExcelReader {
	private static List<String> headerColumn = new ArrayList<String>();
	private static List<String> otherline = new ArrayList<String>();
	private static List<List<String>> linesValue = new ArrayList<List<String>>();
	
public static MyList parseFile(MyFileName mfname) throws IOException {
		
		headerColumn = new ArrayList<String>();
		otherline = new ArrayList<String>();
		linesValue = new ArrayList<List<String>>();
		
		FileInputStream excelFile = new FileInputStream(new File("uploads/" + mfname.getFileName()));
		Workbook workbook = new XSSFWorkbook(excelFile);
 
		Sheet sheet = workbook.getSheetAt(0);
		Iterator<Row> rows = sheet.iterator();
		
		int i = 0;
		while (rows.hasNext()) {
			Row currentRow = rows.next();
			Iterator<Cell> cellsInRow = currentRow.iterator();
			
			while (cellsInRow.hasNext()) {
 
				Cell currentCell = cellsInRow.next();
				
				String titre = "";
 
				if (currentCell.getCellTypeEnum() == CellType.STRING) {
					//System.out.print(currentCell.getStringCellValue() + " | ");
					titre += currentCell.getStringCellValue() ;
				} else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
					//System.out.print(currentCell.getNumericCellValue() + "(numeric)");
					titre += currentCell.getNumericCellValue();
				}
				
				if(i == 0) {
					headerColumn.add(titre);
				}
				else {
					otherline.add(titre);
				}
			}
			
			if(i != 0) {
				linesValue.add(otherline);
				otherline = new ArrayList<String>();
			}
			i++;
			//System.out.println();
		}
		
		//System.out.println(headerColumn.toString());
		//System.out.println(linesValue.toString());
		
		
		workbook.close();
		excelFile.close();
		
		return new MyList(mfname.getFileName(), headerColumn, linesValue);
	}
	
}
