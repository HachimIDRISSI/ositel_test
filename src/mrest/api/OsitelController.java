package mrest.api;

import java.io.IOException;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import excel.service.ExcelReader;
import excel.service.UpdateExcel;
import excel.service.UploadExcel;
import metier.CellUpdate;
import metier.MyFileName;
import metier.MyList;

@RestController
public class OsitelController {
	
	@RequestMapping("/api/ositel/addExcelFile")
    public @ResponseBody MyFileName addExcelFile(@RequestBody MyFileName mfilename) throws IOException {
    		return mfilename;
    }
	
	@RequestMapping(value="/api/ositel/{name}/uploadExcelFile", method=RequestMethod.POST)
    public @ResponseBody String uploadFile( 
            @RequestParam("file") MultipartFile file,  @PathVariable String name){
		return UploadExcel.uploadExcelFile(file, name);
    }

    @RequestMapping("/api/ositel/searchExcelFile")
    @ResponseBody
    public MyList readFile(@RequestBody MyFileName mfilename) throws IOException {
    		return ExcelReader.parseFile(mfilename);
    }
    
    	@RequestMapping("/api/ositel/{col}/{row}/updateCellValue")
    @ResponseBody
    public MyList updateCellFile(@RequestBody CellUpdate mcell, @PathVariable int col,  @PathVariable int row) throws IOException {
    		mcell.setCol(col);
    		mcell.setRow(row);
    		return UpdateExcel.updateCell(mcell);
    }
    
}