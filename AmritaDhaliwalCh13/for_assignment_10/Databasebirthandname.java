package for_assignment_10;

import java.awt.*; // for original GUI stuff
import java.awt.event.*; // for event handling
import java.io.File;

import javax.swing.*; //for swing GUI stuff

/**
 * This is the JFrame class which makes the GUI pop up. This code give 
 * the buttons their size and color and action listeners which in return make the buttons work. 
 * outputs entire contents of the database. 
 * @author Dhaliwal
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

	private JLabel fileL;

	private JTextField middleTF;

	private JTextField fileTF;

	private JLabel middleL;

	private JTextField lastTF;

	private JLabel lastL;

	private JTextField yearTF;
	private JTextField saveTF;

	private JLabel yearL;

	private JLabel dayL;
	private JLabel saveL;

	private JLabel monthL;

	private List <BirthInfo> BirthInfoList;

	private JTextArea displayTA;

	private JScrollPane displaySP;

	private BirthInfo Found;

	private Container myCP;

	/**
	 * refers to a file name being processed by the save or load command
	 */
	private String fileName;

	/**
	 * set to true when awaiting confirm or Cancel during a Save to file operation
	 */
	private boolean processingSave;

	/**
	 * set to true when awaiting OK or Cancel during a new data Enter operation
	 */
	private boolean duplicateRecord;

	/**
	 * set to true when awaiting OK or Cancel during a delete operation
	 */
	private boolean processingDelete;

	private BirthInfo current;

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


		firstL = UtilityMethods.makeLabel( 10,35,50,30, "First:",  myCP);

		middleL = UtilityMethods.makeLabel( 150,35,50,30, "Middle:",  myCP);

		fileL = UtilityMethods.makeLabel( 510,35,50,30, "file:",  myCP);

		fileTF = UtilityMethods.makeTextField( 540,35,200,30, "",  myCP, true);

		lastL = UtilityMethods.makeLabel( 320,35,50,30, " Last:",  myCP);

		yearL = UtilityMethods.makeLabel( 320,75,50,30, " Year:",  myCP);


		chronB = UtilityMethods.makeButton( 510,275,100,30, "Display Chronologically", Color.BLACK, myCP, new chronBHandler());

		alphaB = UtilityMethods.makeButton( 620,275,100,30, "Display Alphabetically", Color.BLACK, myCP, new alphaBHandler());

		addB = UtilityMethods.makeButton( 510,95,100,30, "Add", Color.BLACK, myCP, new addBHandler());

		searchB = UtilityMethods.makeButton(510,135,100,30, "Search", Color.BLACK, myCP, new searchBHandler());

		clearB = UtilityMethods.makeButton( 510,185,100,30, "Clear", Color.BLACK, myCP, new clearBHandler());

		deleteB = UtilityMethods.makeButton(510,235,100,30, "Delete", Color.BLACK, myCP, new deleteBHandler());

		saveB = UtilityMethods.makeButton(620,95,100,30, "Save", Color.BLACK, myCP, new saveBHandler());

		loadB = UtilityMethods.makeButton(620,135,100,30, "Load", Color.BLACK, myCP, new loadBHandler());

		cancelB = UtilityMethods.makeButton(620,185,100,30, "Cancel", Color.BLACK, myCP, new cancelBHandler());

		confirmB = UtilityMethods.makeButton(620,235,100,30, "Confirm", Color.BLACK, myCP, new confirmBHandler());

		/**
		 *  set to false indicates not processing a save yet
		 */
		processingSave = false; 

		/**
		 * not processing a new entry yet this helps indicate when the save is going 
		 * to process a duplicate entry 
		 */
		duplicateRecord = false; 

		/**
		 * not processing a delete yet
		 */
		processingDelete = false; 


		displayTA = new JTextArea(); 
		displayTA.setBackground(Color.WHITE);
		displaySP = 
				new JScrollPane(displayTA,
						JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
						JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		displaySP.setLocation(10,150);
		displaySP.setSize(500,500);
		myCP.add(displaySP); 
		BirthInfoList = new List <BirthInfo> ();
		setVisible(true);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}//windowClosing
		}); //end of definition of WindowAdapter and semicolon to end the line

	}

	/**
	 * This method clears all the textFields and combo boxes when the clear button is pressed.
	 */
	public class clearBHandler implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			lastTF.setText("");
			middleTF.setText("");
			firstTF.setText("");
			monthCB.setSelectedIndex(0);
			dayCB.setSelectedIndex(0);
			yearTF.setText("");	
		} 
	} 
	/**
	 * This method clears all the textFields and combo boxes.
	 */
	private void clearInputFields() {
		lastTF.setText("");
		middleTF.setText("");
		firstTF.setText("");
		monthCB.setSelectedIndex(0);
		dayCB.setSelectedIndex(0);
		yearTF.setText("");	
	}//clearInputFields

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
				errorMsg += ("Year cannot be parsed.\n");
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

	/**
	 * This method is used to enable and disable sets of buttons.
	 * When confirm and cancel are enabled all other are disabled.   
	 * @param tFValue - boolean parameter. It uses that value as the argument to setEnabled on all buttons except OK and Cancel. 
	 */
	private void adjustButtons(boolean tFValue) {
		saveB.setEnabled(tFValue);
		addB.setEnabled(tFValue);
		clearB.setEnabled(tFValue);
		searchB.setEnabled(tFValue);
		deleteB.setEnabled(tFValue);
		loadB.setEnabled(tFValue);
		chronB.setEnabled(tFValue);
		alphaB.setEnabled(tFValue);
		confirmB.setEnabled(!tFValue);
		cancelB.setEnabled(!tFValue);
	}//adjustButtons

	/**
	 * This method resets the GUI to its original status.
	 */
	private void reset() {
		adjustButtons(true);
		clearInputFields();
	}//reset


	//	/**
	//	 * This method makes the all the buttons visible except the 
	//	 * confirmB and cancelB.
	//	 */
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
	 * Puts information about a person and her/his birthday in the database. 
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
				current = new BirthInfo (firstName, middleName, lastName, month, Day, year );
				Found = BirthInfoList.search(current);
				if(Found != null) {//Duplicate 
					adjustButtons(false);
					displayTA.append("\nRecord already exists:\n"+ Found.toString()
					+ "\nPress confirm to replace old record " +
							"or Cancel to cancel new entry.\n");
					processingSave = true;
				}else {
					if(BirthInfoList.add(current)) {
						displayTA.append( current + "added to the DB.\n");
					}else {
						displayTA.setText("\nFailed to add " +
								current + " to the DB.\n");
					}//else
				}//add new records.
				clearInputFields();

			} else {
				displayTA.append(errorMsg +"\n");
			}
		}
	}//addBHandler 

	/**
	 * This method allows the user to enter a person's name (family, first and middle)
	 * to determine if person is in database. 
	 */
	public class searchBHandler implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			String firstName = getStringFromTF(firstTF, firstL, "First Name"); 
			String middleName =  middleTF.getText();
			String lastName = getStringFromTF(lastTF, lastL, "Family Name");
			if(errorMsg.equals("")) {
				BirthInfo findME = new BirthInfo (firstName, middleName, lastName);
				if(BirthInfoList.search(findME) != null) {
					displayTA.append(findME + " is stored in the database.\n");
				}else {
					displayTA.append(findME + " could not be found in database.\n");
				}//else
			} else {
				displayTA.append(errorMsg +"\n");
			}//else
		}
	} 


	public class saveBHandler implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			fileName = fileTF.getText();
			fileTF.setText("");
			String message = "";
			if(fileName.compareTo("") > 0){
				File theFile = new File(fileName);
				if(!theFile.exists()) {
					message = BirthInfoList.saveToFile(fileName);
					displayTA.setText("Data saved to file "+fileName+".\n"
							+ message + "\n");
				} else if (theFile.isDirectory()){
					displayTA.setText("Error: " + fileName + " is a directory.\n");
				} else if (!theFile.canWrite()) {
					displayTA.setText("Cannot write data to "+fileName+".\n");
				} else {
					adjustButtons(false);
					processingSave = true;
					displayTA.setText("\nPress OK to overwrite file "+
							fileName + " or press Cancel to cancel save request\n");
				}//else
			} else {
				displayTA.setText("You must enter a file name in order to save a file");
			}//else

		} 
	}

	public class loadBHandler implements ActionListener {
		public void actionPerformed (ActionEvent e) {	
			fileName = fileTF.getText();
			if(fileName.compareTo("") > 0){
				File theFile = new File(fileName);
				if(!theFile.exists()) {
					displayTA.setText(fileName +
							" does not exist—cannot load data\n");
				}else if(!theFile.canRead()) {
					displayTA.setText("Cannot read from " + fileName+"\n");
				} else {
					String fromLoad = BirthInfoList.loadFromFile(fileName);
					displayTA.setText("Data loaded from "+fileName+"\n"
							+ fromLoad + "\n");
				}//else
				clearInputFields();
			} else {
				displayTA.setText("You must enter a file name " +
						"in order to load a file");
			}//else
		} 
	}
	/**
	 * This method sorts the List chronologically.
	 */
	public class chronBHandler implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			BirthInfoList.Sort();
			displayTA.append(BirthInfoList.toString() + "\n List sorted chronologically");
		} 
	}

	/**
	 * This method sorts the List alphabetically
	 */
	public class alphaBHandler implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			BirthInfoList.Sort();
			displayTA.append(BirthInfoList.toString()+" \n List sorted alphabetically");
		} 
	}

	/**
	 * This method informs the user that the Save, Enter, or Delete request has been cancelled.
	 */
	public class cancelBHandler implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			if(processingSave) {
				displayTA.setText("Save request cancelled. "
						+ fileName + "unchanged.\n");
				processingSave = false;
			}else if (duplicateRecord) {
				displayTA.setText("Information about "+ Found.toString() + " unchanged.\n");
				duplicateRecord = false;
			}else if(processingDelete){
				displayTA.setText("Delete request cancelled. \n");
				processingDelete = false;
			} else {
				System.out.println("Cancel Button being handled at inappropriate time"
						+ e.toString());
			}//else
			reset();	
		} 
	}

	/**
	 * This method confirms a delete request.
	 */
	public class confirmBHandler implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			if(processingSave) {
				String errmsg = BirthInfoList.saveToFile(fileName);
				displayTA.setText(fileName + " over written.\n"
						+ errmsg + "\n");
				processingSave = false;
			} else if (duplicateRecord) {
				if(BirthInfoList.delete(Found)) {
					if(BirthInfoList.add(current)){
						displayTA.setText("\nRecord for " + current.getName()
						+ " changed.\n");
					}else {
						displayTA.setText("\nError in adding new record. " +
								current + " deleted from DB.\n");
					}//else
				} else {
					displayTA.setText("\nError in deleting old record. No change in DB.\n");
				}//inner else
				duplicateRecord = false;
			}else if (processingDelete) {
				if (BirthInfoList.delete(Found)) {
					displayTA.setText("The record for " + Found + " was deleted.");
				} else {
					displayTA.setText("Failure occurred in deleting " + Found + ".\n");
				}
				processingDelete = false;
			}else {
				System.out.println("OK Button being handled at inappropriate time"
						+ e.toString());
			}//else
			reset();
		} 
		}//confirmBHandler

		/**
		 * This method allows the user to remove the information concerning 
		 * a specified person from the database. After this the user is asked 
		 * if to confirm or cancel the request. 
		 */
		public class deleteBHandler implements ActionListener {
			public void actionPerformed (ActionEvent e) {
				errorMsg = "";
				String firstName = getStringFromTF(firstTF, firstL, "First Name"); 
				String middleName =  middleTF.getText();
				String lastName = getStringFromTF(lastTF, lastL, "Family Name");
				if(errorMsg.equals("")) {
					BirthInfo findME = new BirthInfo (firstName, middleName, lastName);
					Found = BirthInfoList.search(findME);
					if(Found != null) {
						adjustButtons(false);
					}else {
						displayTA.append(findME + " could not be found in database. Thus failed to be deleted.\n");
						adjustButtons(true);
					}//else
				} else {
					displayTA.append(errorMsg +"\n");
					adjustButtons(true);
				}//else
			}
		}//deleteBHandler 


		public static void main (String args[]) {
			Databasebirthandname myAppF = new Databasebirthandname ();
		} //main
	}

