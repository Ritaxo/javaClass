package for_ch_17_exercises;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class AddorSubtract extends JFrame {
	/**
	 * user clicks this to add red to content pane's background
	 */
	private JButton reduceRedB, redB;

	/**
	 * user clicks this to add green to content pane's background
	 */
	private JButton	reduceGreenB, greenB;

	/**
	 * user clicks this to add blue to content pane's background
	 */
	private JButton	reduceBlueB, blueB;

	/**
	 * user clicks this to reset all color components to 0
	 */
	private JButton resetB; 

	/**
	 * will display the RGB components of the background
	 * color of the content pane
	 */
	private JTextField showRGBTF;//will display the RGB components of the color of the CP

	/**
	 * This variable holds a reference to the content pane so that 
	 * getContentPane() needs to be called only once.
	 */
	private Container myCP; //to hold a reference to the content pane of the JFrame

	/**
	 * This is the constructor of this application.
	 */
	public  AddorSubtract () {

		super("Increase Color Components");
		setSize(650, 500);
		setLocation(100,100);
		myCP = getContentPane();
		myCP.setLayout(null);//there is no layout manager
		myCP.setBackground(Color.BLACK);// red, green, and blue components are each 0

		redB = makeButton(30,75,120,50, "Increase Red",Color.RED, (ActionEvent e) -> handleColor(Color.RED, true));
		greenB = makeButton(180,75,120,50, "Increase Green",Color.GREEN, (ActionEvent e) -> handleColor(Color.GREEN, true));
		blueB = makeButton(330,75,120,50, "Increase Blue",Color.BLUE, (ActionEvent e) -> handleColor(Color.BLUE, true));

		reduceRedB = makeButton(30,190,120,50, "Reduce Red",Color.RED, (ActionEvent e) -> handleColor(Color.RED, false));
		reduceGreenB = makeButton(180,190,120,50, "Reduce Green",Color.GREEN, (ActionEvent e) -> handleColor(Color.GREEN, false));
		reduceBlueB = makeButton(330,190,120,50, "Reduce Blue",Color.BLUE, (ActionEvent e) -> handleColor(Color.BLUE, false));
		resetB = makeButton(500,75,120,50, "Reset",Color.BLACK, (ActionEvent e) -> reset());

		showRGBTF = new JTextField("R is 0, G is 0, and B is 0.");
		showRGBTF.setSize(200,30);
		showRGBTF.setLocation(225,150);
		showRGBTF.setEditable(false);
		myCP.add(showRGBTF);

		//This statement makes sure the window is visible on the screen
		setVisible(true);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}//windowClosing
		}); //end of definition of WindowAdapter and semicolon to end the line 

	} //  AddOrSubtractColor constructor 

	/**
	 * does all the work to construct a JButton using parameters
	 * @param theX horizontal component of upper left corner of the JButton
	 * @param theY vertical component of the upper left corner of the JButton
	 * @param theWidth horizontal dimension of the JButton
	 * @param theHeight vertical dimension of the JButton
	 * @param theText label that appears on the JButton
	 * @param theForeground color of the text that appears on the JButton
	 * @param theHandler the ActionListener of the JButton
	 * @return the constructed JButton
	 */
	private JButton makeButton(int theX, int theY, int theWidth, int theHeight,
			String theText, Color theForeground, ActionListener theHandler){
		JButton toReturn = new JButton(theText);
		toReturn.setSize(theWidth, theHeight);
		toReturn.setLocation(theX, theY);
		toReturn.setForeground(theForeground);
		myCP.add(toReturn);
		toReturn.addActionListener(theHandler);
		return toReturn;
	}//makeButton

	/**
	 * either increases the color component by 20 or sets the color component
	 * to maximum value and disables the corresponding JButton since further increases
	 * are not possible
	 * @param theComponent the red, green, or blue component
	 * @param theButton JButton corresponding to increase requests for this color component
	 * @return new value for the color component
	 */
	private int handleIncrease(int theComponent, JButton theButton){
		if (theComponent + 20 > 255 ) {
			theComponent = 255;
			theButton.setEnabled(false);
		} else {
			theComponent = theComponent + 20;
		}//else
		return theComponent;
	}//handleIncrease

	/**
	 * gets the current red, green, and blue components, 
	 * handles the increase of the appropriate component,
	 * constructs the new Color object from the three color
	 * components, sets the background of the content pane to that 
	 * Color, and displays the color components in a text field
	 * @param c the color being increased
	 */
	private int handleDecrease(int theComponent, JButton theButton){
		if (theComponent - 20 < 0 ) {
			theComponent = 0;
			theButton.setEnabled(false);
		} else {
			theComponent = theComponent - 20;
		}//else
		return theComponent;
	}//handleDecreases

	private void handleColor(Color c,boolean isItIncrease){
		Color currentBackgroundColor = myCP.getBackground();
		int redComponent = currentBackgroundColor.getRed();
		int greenComponent = currentBackgroundColor.getGreen();
		int blueComponent = currentBackgroundColor.getBlue();
		if(c.equals(Color.RED)){
			if(isItIncrease) {
				redComponent = handleIncrease(redComponent, redB);
				reduceRedB.setEnabled(true);
			} else {
				redComponent = handleDecrease(redComponent, reduceRedB);
				redB.setEnabled(true);
			}
		} else if (c.equals(Color.GREEN)){
			if(isItIncrease) {
				greenComponent = handleIncrease(greenComponent, greenB);
				reduceGreenB.setEnabled(true);
			} else {
				greenComponent = handleDecrease(greenComponent, reduceGreenB);
				greenB.setEnabled(true);
			}
		} else if (c.equals(Color.BLUE))  {
			if(isItIncrease) {
				blueComponent = handleIncrease(blueComponent, blueB);
				reduceBlueB.setEnabled(true);
			} else {
				blueComponent = handleDecrease(blueComponent, reduceBlueB);
				blueB.setEnabled(true);
			}
		}//last else
		Color adjustedColor = new Color 
				(redComponent, greenComponent, blueComponent);
		myCP.setBackground(adjustedColor);
		showRGBTF.setText ("R is " + redComponent + ", G is " + greenComponent 
				+ ", B is " + blueComponent + "."); 
	}//handleOneColor

	

//	private void handleOneColor(Color c){
//		Color currentBackgroundColor = myCP.getBackground();
//		int redComponent = currentBackgroundColor.getRed();
//		int greenComponent = currentBackgroundColor.getGreen();
//		int blueComponent = currentBackgroundColor.getBlue();
//		if(c.equals(Color.RED)){
//			redComponent = handleIncrease(redComponent, redB);
//		} else if (c.equals(Color.GREEN)){
//			greenComponent = handleIncrease(greenComponent, greenB);
//		} else {
//			blueComponent = handleIncrease(blueComponent, blueB);
//		}//last else
//		Color adjustedColor = new Color 
//				(redComponent, greenComponent, blueComponent);
//		myCP.setBackground(adjustedColor);
//		showRGBTF.setText ("R is " + redComponent + ", G is " + greenComponent 
//				+ ", B is " + blueComponent + "."); 
//	}//handleOneColor

	/**
	 * resets the background color of the content pane to black,
	 * displays the color components of black in the text field,
	 * and enables the three color increase buttons
	 */
	private void reset(){
		myCP.setBackground(Color.BLACK);
		showRGBTF.setText ("R is 0, G is 0, B is 0.");
		redB.setEnabled(true);
		greenB.setEnabled(true);
		blueB.setEnabled(true);
		reduceGreenB.setEnabled(true);
		reduceBlueB.setEnabled(true);
		reduceRedB.setEnabled(true);
	}//reset
	
	
	/**
	 * ActionListener for the red increase JButton
	 */
	//	public class RedBHandler implements ActionListener {
	//		/**
	//		 * action to be performed when the red increase button is clicked
	//		 */
	//		public void actionPerformed (ActionEvent e) {
	//			handleOneColor(Color.RED);	
	//		} //actionPerformed
	//	} // RedBHandler

	/**	 
	 * ActionListener for the green increase JButton
	 */
	//	public class GreenBHandler implements ActionListener {
	//		/**
	//		 * action to be performed when the green increase button is clicked.
	//		 */
	//		public void actionPerformed (ActionEvent e) {
	//			handleOneColor(Color.GREEN);	
	//		} //actionPerformed
	//	} // GreenBHandler

	/**
	 * ActionListener for the blue increase JButton
	 *
	 */
	//	public class BlueBHandler implements ActionListener {
	//		/**
	//		 * action to be performed when the blue increase button is clicked
	//		 */
	//		public void actionPerformed (ActionEvent e) {
	//			handleOneColor(Color.BLUE);	
	//		} //actionPerformed
	//	} // BlueBHandler

	/**
	 * ActionListener for the reset JButton
	 */
	//	public class ResetBHandler implements ActionListener {
	//		/**
	//		 * action to be performed when the reset button is clicked
	//		 */
	//		public void actionPerformed (ActionEvent e) {
	//			reset();
	//		} //actionPerformed
	//	} // ResetBHandler

	/**
	 * The main method is where execution begins.
	 * @param args parameter is not used since we are not
	 * working at the command line
	 */
	public static void main (String args[]) {
		AddorSubtract myAppF = new AddorSubtract ();
	} //main

}// AddOrSubtractColor