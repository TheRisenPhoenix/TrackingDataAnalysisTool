package algorithm;

import java.util.ArrayList;
import java.util.List;
import inputOutput.Tool;


public class DataManager {
	List<ToolMeasure> tools;
	int countToGetNext;
	
	//Constructor
	public DataManager (int countToGetNext) {
		this.countToGetNext = countToGetNext;
	}
	
public void getNextData (int countToGetNext) {
		
		for(double i = 0; i< countToGetNext; i++) {
			
		//aus rückgabe von update neue messung erstellen
		Measurement measurement = new Measurement(ArrayList.update());
		
		 for(ToolMeasure tool : tools) {
		        if(tool.getName().equals(measurement.getToolname())){
		            tool.addMeasurement(measurement);
		        }
		        else {
		        	ToolMeasure newTool = new ToolMeasure(measurement.getToolname());
		        	newTool.addMeasurement(measurement);
		        	tools.add(newTool);
		        }
		    }
		}
	}   
	
	   
	


		

		
	}   
	


	


	


