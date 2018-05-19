package inputOutput;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import testInputOutput.CSVFileReaderTest;
import inputOutput.CSVFileReader;
import inputOutput.Tool;

public class Fenster extends JFrame implements ActionListener {

	private JButton laden = new JButton("Laden");
	private JTextField feld1 = new JTextField(50);

	public Fenster() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		init();

	}

	public void init() {

		this.setSize(new Dimension(800, 300));

		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(1, 50, 50));

		laden.addActionListener(this);
		feld1.addActionListener(this);

		panel.add(feld1);
		panel.add(laden);

		this.setContentPane(panel);

	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		
		Object src = evt.getSource();
		File f;
		String path;
		
		if(src == laden){
			f= new File(feld1.getText());
			path = f.getAbsolutePath();
			System.out.println(path);
			CSVFileReader.setPath(path);
			try {
				CSVFileReaderTest.updateTest();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}

	}

}
