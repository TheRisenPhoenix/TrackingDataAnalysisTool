package algorithm;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.File;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import inputOutput.CSVFileReader;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JToggleButton;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class Test extends JFrame {

	private JPanel contentPane;
	private DataService dataService = new DataService();
	File f;
	private JTextField textField;
	private JButton openButton = new JButton();
	private FileChooser fp = new FileChooser();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test frame = new Test();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		
		
		});
		
	}
	
	
	/**
	 * Create the frame.
	 */
	public Test() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(270, 73, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblErgebnis = new JLabel("Ergebnis");
		lblErgebnis.setBounds(156, 76, 56, 16);
		contentPane.add(lblErgebnis);
		
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("berechne");
		tglbtnNewToggleButton.setBounds(249, 125, 137, 25);
		contentPane.add(tglbtnNewToggleButton);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{contentPane}));
	}
	

	public void load(int countToGetNext) {
	List<ToolMeasure> toolMeasure= dataService.loadNextData(countToGetNext);
	
	
	fp.setTitle("Search for Data");
	fp.getExtensionFilters().addAll(new ExtensionFilter("Text Datei", "*.csv"));

	String path =" C://Desktop//Messung_Team2//Biopsienadel_Distanz/logfile_biop_M1.csv";
	CSVFileReader.setPath(path);

	

	CSVFileReader.setPath(path);
	
	System.out.println("Jitter:" +toolMeasure.get(0).getAverageMeasurement().getError() + "Accuracy" + dataService.getAccuracy(5, toolMeasure.get(0).getAverageMeasurement(), toolMeasure.get(1).getAverageMeasurement()));

	}
}
