package inputOutput;

import java.util.Vector;

public abstract class Interface {

	Vector tool = new Vector();

	public Interface() {

	}
//this method gets the file data
	private Vector update() {
		
		read();

		return tool;

	}

	private void read() {

	}

}
