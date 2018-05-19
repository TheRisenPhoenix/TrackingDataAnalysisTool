package inputOutput;

public class Main_Test {
	
	private Fenster frame = null;
	
	private Main_Test(){
		
		frame = new Fenster();
		frame.validate();
		frame.setVisible(true);
		
	}

	public static void main(String[] args) {
		new Main_Test();

	}

}
