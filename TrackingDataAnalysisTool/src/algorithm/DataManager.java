package algorithm;

import java.util.ArrayList;
import java.util.List;

import inputOutput.CSVFileReader;

import inputOutput.Tool;

public class DataManager  {
	List<ToolMeasure> toolMeasures = new ArrayList<>();
	private boolean count = false;

	public List<ToolMeasure> getToolMeasures() {
		return toolMeasures;
	}
 //Methode update wird aufgerufen, daraus messung erstellt und fügt diese Tool hinzu
	public List<ToolMeasure> getNextData(int countToGetNext) {

		for (double i = 0; i < countToGetNext; i++) {
			// aus rueckgabe von update neue messung erstellen
			List<Tool> tools = inputOutput.CSVFileReader.update();

			for (Tool tool : tools) {
				Measurement measurement = new Measurement(tool);
				addMeasurementToTool(measurement);
			}

		}

		return toolMeasures;
	}
// wird in gND aufgerufen, schauen ob Tool schon vorhanden ist und fügt Messungen hinzu, wenn nicht erstellt neues Tool
	private void addMeasurementToTool(Measurement measurement) {
		for (ToolMeasure toolMeasure : toolMeasures) {
			if (toolMeasure.getName().equals(measurement.getToolname())) {
				toolMeasure.addMeasurement(measurement);
				return;
			}
		}
		
		ToolMeasure newTool = new ToolMeasure(measurement.getToolname());
		newTool.addMeasurement(measurement);
		toolMeasures.add(newTool);
	}

	// Aufruf von Team 3, erste Liste wird nicht benutzt, erst die zweite. Count oben auf False, wenn count true neue Messung, sonst count true
	public void setList(ArrayList<Tool> test) {

		if (count == true) {

			List<Tool> tools = test;
			for (Tool tool : tools) {
				Measurement measurement = new Measurement(tool);
				addMeasurementToTool(measurement);
			}

		} else {
			count=true;
		}
	}
	
	public void setCount(){
		count=false;
	}
}