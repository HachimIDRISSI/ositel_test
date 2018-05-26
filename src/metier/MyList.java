package metier;

import java.util.List;

public class MyList {
	
	private String fileName;
	private List<String> headerColumn;
	private List<List<String>> linesValue;
	
	public MyList(String fileName, List<String> headerColumn, List<List<String>> linesValue) {
		this.fileName = fileName;
		this.headerColumn = headerColumn;
		this.linesValue = linesValue;
	}
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public List<String> getHeaderColumn() {
		return headerColumn;
	}
	public void setHeaderColumn(List<String> headerColumn) {
		this.headerColumn = headerColumn;
	}
	public List<List<String>> getLinesValue() {
		return linesValue;
	}
	public void setLinesValue(List<List<String>> linesValue) {
		this.linesValue = linesValue;
	}

}
