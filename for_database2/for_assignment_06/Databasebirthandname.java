package for_assignment_06;

import java.awt.*; // for original GUI stuff
import java.awt.event.*; // for event handling
import javax.swing.*; //for swing GUI stuff

public class Databasebirthandname extends JFrame{


	private JButton addB;

	private JButton	searchB;

	private JButton	clearB;

	private JButton deleteB; 

	private JButton	saveB;

	private JButton	loadB;

	private JButton chronB;

	private JButton alphaB;

	private JButton cancelB;

	private JButton confirmB;

	private JComboBox monthCB;

	private JComboBox dayCB;

	private JTextField firstTF;

	private JLabel firstL;

	private JTextField middleTF;

	private JLabel middleL;

	private JTextField lastTF;

	private JLabel lastL;

	private JTextField yearTF;
	private JTextField saveTF;

	private JLabel yearL;

	private JLabel dayL;
	private JLabel saveL;

	private JLabel monthL;

	private JTextArea displayTA;

	private JScrollPane displaySP; 

	private Container myCP;

	public Databasebirthandname() {
		super("Database birth and name");
		setSize(750,730);
		myCP = getContentPane();
		myCP.setLayout(null);
		myCP.setBackground(Color.GRAY);

		firstTF = UtilityMethods.makeTextField( 40,35,100,30, "",  myCP, true);

		middleTF = UtilityMethods.makeTextField(200 ,35,100,30, "",  myCP, true);

		lastTF = UtilityMethods.makeTextField( 370,35,100,30, "",  myCP, true);

		yearTF = UtilityMethods.makeTextField(370,75,100,30, "",  myCP, true);

		monthCB = UtilityMethods.makeComboBox( 50,75,100,30, 
				BirthDate.MONTH_NAMES, myCP);

		monthL = UtilityMethods.makeLabel( 10,75,50,30, "Month:",  myCP); 

		dayCB = UtilityMethods.makeComboBox(200 ,75,100,30, 
				BirthDate.DAYS_IN_MONTHS, myCP);

		dayL = UtilityMethods.makeLabel( 170,75,50,30, "Day:",  myCP);

		saveTF = UtilityMethods.makeTextField( 530,65,100,30, "",  myCP, true);

		firstL = UtilityMethods.makeLabel( 10,35,50,30, "First:",  myCP);

		middleL = UtilityMethods.makeLabel( 150,35,50,30, "Middle:",  myCP);

		lastL = UtilityMethods.makeLabel( 320,35,50,30, " Last:",  myCP);

		yearL = UtilityMethods.makeLabel( 320,75,50,30, " Year:",  myCP);

		saveL = UtilityMethods.makeLabel(490,65,100,30, " Save:",  myCP);

		chronB = UtilityMethods.makeButton( 510,35,100,30, "Display Chronologically", Color.BLACK, myCP, new chronBHandler());

		alphaB = UtilityMethods.makeButton( 620,35,100,30, "Display Alphabetically", Color.BLACK, myCP, new alphaBHandler());

		addB = UtilityMethods.makeButton( 510,95,100,30, "Add", Color.BLACK, myCP, new addBHandler());

		searchB = UtilityMethods.makeButton(510,135,100,30, "Search", Color.BLACK, myCP, new searchBHandler());

		clearB = UtilityMethods.makeButton( 510,185,100,30, "Clear", Color.BLACK, myCP, new clearBHandler());

		deleteB = UtilityMethods.makeButton(510,235,100,30, "Delete", Color.BLACK, myCP, new deleteBHandler());

		saveB = UtilityMethods.makeButton(620,95,100,30, "Save", Color.BLACK, myCP, new saveBHandler());

		loadB = UtilityMethods.makeButton(620,135,100,30, "Load", Color.BLACK, myCP, new loadBHandler());

		cancelB = UtilityMethods.makeButton(620,185,100,30, "Cancel", Color.BLACK, myCP, new cancelBHandler());

		confirmB = UtilityMethods.makeButton(620,235,100,30, "Confirm", Color.BLACK, myCP, new confirmBHandler());

		displayTA = new JTextArea(); 
		displayTA.setBackground(Color.WHITE);
		displaySP = 
				new JScrollPane(displayTA,
						JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
						JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		displaySP.setLocation(10,150);
		displaySP.setSize(500,500);
		myCP.add(displaySP); 

		setVisible(true);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}//windowClosing
		}); //end of definition of WindowAdapter and semicolon to end the line

	}

	public class addBHandler implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			//int monthint = (int) monthCB.getSelectedItem();
			//int dayint = (int) dayCB.getSelectedItem();
			//int monthint = (int) monthCB.getSelectedItem();
			//int dayint = Integer.parseInt(dayCB.getSelectedItem());
			//int yearint = Integer.parseInt(yearTF.getText());
			BirthInfo B1 = new BirthInfo (firstTF.getText(), middleTF.getText(), lastTF.getText()); 
			displayTA.append(  B1+ " \n");
		} 
	} 

	public class searchBHandler implements ActionListener {
		public void actionPerformed (ActionEvent e) {	
		} 
	} 

	public class clearBHandler implements ActionListener {
		public void actionPerformed (ActionEvent e) {	
		} 
	} 

	public class deleteBHandler implements ActionListener {
		public void actionPerformed (ActionEvent e) {	
		} 
	}

	public class saveBHandler implements ActionListener {
		public void actionPerformed (ActionEvent e) {	
		} 
	}

	public class loadBHandler implements ActionListener {
		public void actionPerformed (ActionEvent e) {	
		} 
	}

	public class chronBHandler implements ActionListener {
		public void actionPerformed (ActionEvent e) {	
		} 
	}

	public class alphaBHandler implements ActionListener {
		public void actionPerformed (ActionEvent e) {	
		} 
	}


	public class cancelBHandler implements ActionListener {
		public void actionPerformed (ActionEvent e) {	
		} 
	}

	public class confirmBHandler implements ActionListener {
		public void actionPerformed (ActionEvent e) {	
		} 
	}


	public static void main (String args[]) {
		Databasebirthandname myAppF = new Databasebirthandname ();
	} //main
}
