package inputOutput;

import java.io.*;
import java.util.ArrayList;

public class CSVFileReader extends Interface {

	// initialize public variable
	static int line_counter = 0;

	private static void init() {

	}

	private static void read() {
		// initialize variables
		String line = null;
		String[] data = null;
		// create ToolList
		ArrayList<Tool> toollist = new ArrayList<Tool>();
		// create the file read for the CSV data
		BufferedReader csv_file = null;
		try {
			// read CSV data
			csv_file = new BufferedReader(new InputStreamReader(new FileInputStream("Q:\\logfile.csv")));

		} catch (Exception e) {
		}

		try {
			// split the CSV data
			for (int j = 0; j <= line_counter; j++) {
				line = csv_file.readLine();
				data = line.split(";");

			}

			double[] data_new = new double[data.length];

			if (line_counter == 1) {
				for (int a = 0; a < data.length; a++) {
					// casting from string to double
					data_new[a] = Double.parseDouble(data[a]);
				}
				// find the number of the tools out
				int number_of_tools = (data.length) / 9;

				// System.out.println(number_of_tools);

				for (int i = 1, j = 0; i <= number_of_tools; i++, j = j + 9) {
					// Memory area occupied for the tool
					Tool tool = new Tool(data_new[j], data_new[j + 1], data_new[j + 2], data_new[j + 3],
							data_new[j + 4], data_new[j + 5], data_new[j + 6], data_new[j + 7], data_new[j + 8],
							"tool" + i);
					// adding the tool data to the tool list
					toollist.add(tool);
				}
				// print the tool list out
				for (int index = 0; index < toollist.size(); index++) {
					System.out.println(toollist.get(index));
				}
			}
			
			line_counter++;
		} catch (IOException e) {
			// error message output
			System.out.println("Read error " + e);

		}

	}

	public static void main(String[] args) {

		for (int i = 0; i <= 1; i++) {

			read();
			System.out.println("____________________________________");

		}
	}

}
