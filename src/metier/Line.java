package metier;

import java.util.List;

public class Line {
	private List<List<String>> linesValue;
	
	public Line(List<List<String>> linesValue) {
		this.linesValue = linesValue;
	}

	public List<List<String>> getLinesValue() {
		return linesValue;
	}

	public void setLinesValue(List<List<String>> linesValue) {
		this.linesValue = linesValue;
	}
	
}
