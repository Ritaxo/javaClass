package for_final_project;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/***/

public class UtilityMethods {
	
	/**
	 * does all the work to construct a JButton using parameters
	 * @param theX horizontal component of upper left corner of the JButton
	 * @param theY vertical component of the upper left corner of the JButton
	 * @param theWidth horizontal dimension of the JButton
	 * @param theHeight vertical dimension of the JButton
	 * @param theText label that appears on the JButton
	 * @param theForeground color of the text that appears on the JButton
	 * @param theHandler the ActionListener of the JButton
	 * @param theContainer who adds this JButton
	 * @return the constructed JButton
	 */
	public static JButton makeButton(int theX, int theY, int theWidth, int theHeight, String theText, 
			Color theForeground, Container theContainer, ActionListener theHandler){
		JButton toReturn = new JButton(theText);
		toReturn.setSize(theWidth, theHeight);
		toReturn.setLocation(theX, theY);
		toReturn.setForeground(theForeground);
		theContainer.add(toReturn);//myCP
		toReturn.addActionListener(theHandler);
		return toReturn;
		
	}//makeButton
	
	/**
	 * does all the work to construct a JButton using parameters
	 * @param theX horizontal component of upper left corner of the JButton
	 * @param theY vertical component of the upper left corner of the JButton
	 * @param theWidth horizontal dimension of the JButton
	 * @param theHeight vertical dimension of the JButton
	 * @param theText label that appears on the JButton
	 * @param theForeground color of the text that appears on the JButton
	 * @param theHandler the ActionListener of the JButton
	 * @param theContainer who adds this JButton
	 * @param enabledOrNot true is initially enabled, false if not
	 * @return the constructed JButton
	 */
	public static JButton makeButton(int theX, int theY, int theWidth, int theHeight, String theText, 
			Color theForeground, Container theContainer, boolean enabledOrNot, ActionListener theHandler){
		JButton toReturn = new JButton(theText);
		toReturn.setSize(theWidth, theHeight);
		toReturn.setLocation(theX, theY);
		toReturn.setForeground(theForeground);
		theContainer.add(toReturn);//myCP
		toReturn.addActionListener(theHandler);
		toReturn.setEnabled(enabledOrNot);
		return toReturn;
		
	}//makeButton
	
	/**
	 * does all the work to construct a JTextField using parameters
	 * @param theX horizontal component of upper left corner of the JTextField
	 * @param theY vertical component of the upper left corner of the JTextField
	 * @param theWidth horizontal dimension of the JTextField
	 * @param theHeight vertical dimension of the JTextField
	 * @param theText text that JTextField is initialized with
	 * @param theContainer who adds this JTextField
	 * @param editableOrNot true if editable, false if not
	 * @return the constructed JTextField
	 */
	public static JTextField makeTextField(int theX, int theY, int theWidth, int theHeight, String theText,
			Container theContainer, boolean editableOrNot) {
		JTextField toReturn = new JTextField(theText);
		toReturn.setSize(theWidth, theHeight);
		toReturn.setLocation(theX, theY);
		theContainer.add(toReturn);
		toReturn.setEditable(editableOrNot);
		return toReturn;
	}//makeTextField
	
	/**
	 * does all the work to construct a JLabel using parameters
	 * @param theX horizontal component of upper left corner of the JLabel
	 * @param theY vertical component of the upper left corner of the JLabel
	 * @param theWidth horizontal dimension of the JLabel
	 * @param theHeight vertical dimension of the JLabel
	 * @param theText label that appears on the JLabel
	 * @param theContainer who adds this JLabel
	 * @return the constructed JLabel
	 */
	public static JLabel makeLabel(int theX, int theY, int theWidth, int theHeight, String theText,
			Container theContainer) {
		JLabel toReturn = new JLabel(theText);
		toReturn.setSize(theWidth, theHeight);
		toReturn.setLocation(theX, theY);
		theContainer.add(toReturn);
		return toReturn;
	}//makeLabel
	
	/**
	 * does all the work to construct a JComboBox using parameters
	 * @param theX horizontal component of upper left corner of the JComboBox
	 * @param theY vertical component of the upper left corner of the JComboBox
	 * @param theWidth horizontal dimension of the JComboBox
	 * @param theHeight vertical dimension of the JComboBox
	 * @param theArray the list of elements in the JComboBox
	 * @param theContainer who adds this JComboBox
	 * @return the constructed JComboBox
	 */
	public static JComboBox makeComboBox(int theX, int theY, int theWidth, int theHeight, 
			String[] theArray, Container theContainer) {
	JComboBox toReturn=new JComboBox(theArray);
	toReturn.setSize(theWidth, theHeight);
	toReturn.setLocation(theX, theY);
	theContainer.add(toReturn);
	return toReturn;
	}//makeComboBox
	
}
