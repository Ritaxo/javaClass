package for_assignment_06;

import java.awt.*; // for original GUI stuff
import java.awt.event.*; // for event handling
import javax.swing.*; //for swing GUI stuff

/**
 * This is the JFrame class which makes the GUI pop up. This code give 
 * the buttons their size and color and action listeners which in return make the buttons work.
 * The JFrame class also contains code for the displaying the right content in the Text Area, outputTA  
 * @author Dhaliwal
 *
 */
public class Databasebirthandname extends JFrame{


	String errorMsg;

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

	private BirthInfoList myBIList;

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

		deleteB = UtilityMethods.makeButton(510,235,100,30, "Delete", Color.BLACK, myCP, new confirmBHandler());

		saveB = UtilityMethods.makeButton(620,95,100,30, "Save", Color.BLACK, myCP, new saveBHandler());

		loadB = UtilityMethods.makeButton(620,135,100,30, "Load", Color.BLACK, myCP, new loadBHandler());

		cancelB = UtilityMethods.makeButton(620,185,100,30, "Cancel", Color.BLACK, myCP, new cancelBHandler());

		confirmB = UtilityMethods.makeButton(620,235,100,30, "Confirm", Color.BLACK, myCP, new deleteBHandler());

		
		displayTA = new JTextArea(); 
		displayTA.setBackground(Color.WHITE);
		displaySP = 
				new JScrollPane(displayTA,
						JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
						JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		displaySP.setLocation(10,150);
		displaySP.setSize(500,500);
		myCP.add(displaySP); 
		myBIList = new BirthInfoList();
		setVisible(true);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}//windowClosing
		}); //end of definition of WindowAdapter and semicolon to end the line

	}

/**
 * This methods checks the name & family text fields to see if they have the information. If no information 
 * is found in the necessary text field than an error message is displayed.  
 * @param theTF - the text field to get the info from 
 * @param theL - the label of the text field 
 * @param theError - the error to to display be displayed.In most cases its the Name of the text field.  
 * @return - returns either the string containing the informations from the text field or the error messgae.  
 */
	private String getStringFromTF (JTextField theTF, JLabel theL, String theError) {
		String toReturn = theTF.getText();
//		String firstName = firstTF.getText();
		if(toReturn.equals("")) {
			errorMsg += "You must enter a " + theError +"\n";
			theL.setForeground(Color.RED);
		} //if
		return toReturn;
	}//getStringFromTF

	/**
	 * This methods checks the Year text fields to see if it has the correct information. If no information 
	 * is found in the necessary text field than an error message is displayed.
	 * @param theTF - name of the text field 
	 * @return - the int stored or an error message. 
	 */
	private int getIntFromYear(JTextField theTF) {
		int year = 0;
		String yearString = yearTF.getText();
		if(!yearString.equals("")) {
			try {
				year = Integer.parseInt(yearString);
			}//try
			catch(NumberFormatException nFE) {
				errorMsg += ("Year cannot be parsed.");
				return 0;
			}//catch
			return year;
		}//if user entered a string for year
		return 0;
	}

	/**
	 * This method checks the month & Day combo boxes to see if it has the correct information. If no information 
	 * is found in the necessary combo boxes than an error message is displayed.
	 * @param theCB - name of the combo box
	 * @param theL - the label on the combo box 
	 * @param theWords - the error to be displayed when no / not the right information is given 
	 * @return - String stored in the combo box or the error message. 
	 */
	private int getIntFromCB(JComboBox theCB, JLabel theL, String theWords) {
		int toReturn = theCB.getSelectedIndex();
		if(toReturn == 0) {
			errorMsg += "You must choose a " +theWords + "\n.";
			theL.setForeground(Color.RED);
		}//if
		return toReturn;
	}//get Int From CB
	
//	private void makeThemInvisible() {
//		deleteB.setVisible(false);
//		addB.setVisible(false);
//		searchB.setVisible(false);
//		clearB.setVisible(false);
//		saveB.setVisible(false);
//		loadB.setVisible(false);
//		chronB.setVisible(false);
//		alphaB.setVisible(false);
//		cancelB.setVisible(false);
//	}

//	private void makeThemVisible() {
//		deleteB.setVisible(true);
//		addB.setVisible(true);
//		searchB.setVisible(true);
//		clearB.setVisible(true);
//		saveB.setVisible(true);
//		loadB.setVisible(true);
//		chronB.setVisible(true);
//		alphaB.setVisible(true);
//		cancelB.setVisible(true);
//	}
	
	/**
	 * This method shows the current max days in the combo box.  
	 * @param oldMax - is an int which refers to the current number of days according to the month from previous slection.  
	 * @param newMax - refers to the actual max of the current selected month.   
	 */
	private void adjustDayCB(int oldMax , int newMax) {
		if(oldMax < newMax) {
			for (int addItem = oldMax + 1; addItem <= newMax; addItem++) {
				dayCB.addItem(addItem +"");
			}//for to add Days
		}else {
			for (int deleteItem = oldMax; deleteItem >newMax; deleteItem--) {
				dayCB.removeItem(deleteItem +"");	
			}//for remove Items
		}//else
	}//adjustDayCB

/**
 * 
 * @author Dhaliwal
 *
 */
	public class addBHandler implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			errorMsg = "";
			String firstName = getStringFromTF(firstTF, firstL, "First Name"); 
			String middleName =  middleTF.getText();
			String lastName = getStringFromTF(lastTF, lastL, "Family Name");
			int month = getIntFromCB(monthCB, monthL, "Month");
			int Day = getIntFromCB(dayCB, dayL, "Day");
			int year = getIntFromYear(yearTF);
			if(errorMsg.equals("")) {
				BirthInfo toAdd = new BirthInfo (firstName, middleName, lastName, month, Day, year );
				if(myBIList.add(toAdd)) {
					displayTA.append(  toAdd + " added\n");
				}else {
					displayTA.append(  toAdd + " failed to add\n");
				}//else
			} else {
				displayTA.append(errorMsg +"\n");
			}
		}
	}//addBHandler 

	public class searchBHandler implements ActionListener {
		public void actionPerformed (ActionEvent e) {
//			String firstName = getStringFromTF(firstTF, firstL, "First Name"); 
//			String middleName =  middleTF.getText();
//			String lastName = getStringFromTF(lastTF, lastL, "Family Name");
		} 
	} 

	public class clearBHandler implements ActionListener {
		public void actionPerformed (ActionEvent e) {
//			lastTF.setText("");
//			middleTF.setText("");
//			firstTF.setText("");
//			monthCB.setSelectedIndex(0);
//			dayCB.setSelectedIndex(0);
//			yearTF.setText("");	
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
	
	public class deleteBHandler implements ActionListener {
		public void actionPerformed (ActionEvent e) {
//			String firstName = getStringFromTF(firstTF, firstL, "First Name"); 
//			String middleName =  middleTF.getText();
//			String lastName = getStringFromTF(lastTF, lastL, "Family Name");
//			BirthInfo findME = new BirthInfo (firstName, middleName, lastName);
//			myBIList.delete(findME);
//			firstTF.setEditable(true);
//			lastTF.setEditable(true);
//			middleTF.setEditable(true);
		} 
	}

	public class confirmBHandler implements ActionListener {
		public void actionPerformed (ActionEvent e) {
//			errorMsg = "";
//			String firstName = getStringFromTF(firstTF, firstL, "First Name"); 
//			String middleName =  middleTF.getText();
//			String lastName = getStringFromTF(lastTF, lastL, "Family Name");
//			makeThemInvisible();
//			if(errorMsg.equals("")) {
//				BirthInfo findME = new BirthInfo (firstName, middleName, lastName);
//				if(myBIList.search(findME) != null) {
//					confirmB.setVisible(true);
//					cancelB.setVisible(true);
//					firstTF.setEditable(false);
//					lastTF.setEditable(false);
//					middleTF.setEditable(false);
//				}else {
//					displayTA.append(findME + " could not be found in database. Thus failed to be deleted.\n");
//					makeThemVisible();
//				}//else
//			} else {
//				displayTA.append(errorMsg +"\n");
//				makeThemVisible();
//			}
		}
	}


	public static void main (String args[]) {
		Databasebirthandname myAppF = new Databasebirthandname ();
	} //main
}
