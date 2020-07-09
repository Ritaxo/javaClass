package for_assignment_04;

public class Birthinfo{
	
	/**
	 * A Name objects that consists of three Strings, corresponding 
	 * to each part of a person's name. 
	 */
	private Name myName;
	
	/**
	 * A BirthDate objects that consists of three ints corresponding 
	 * to each part of a person's BirthDate. 
	 */
	private BirthDate myBirthDate;
	
	/**
	 *  Constructs a new Birthinfo object assigning parameters to all three parts of the name and BirthDate.
	 * @param theFirst a string that contains the first name 
	 * @param theMiddle a string that contains the middle name
	 * @param theFamily a string that contains the family name.
	 * @param theDay an int that contains the day
	 * @param theMonth an int that contains the month
	 * @param theYear an int that contains the year
	 */
	public Birthinfo( String theFirst, String theMiddle, String theFamily,int theDay, int theMonth, int theYear ) {
		myName = new Name(theFirst, theMiddle, theFamily);
		myBirthDate =  new BirthDate(theDay, theMonth, theYear);
	}//6 parameter constructor
	
	/**
	 *  Constructs a new Birthinfo object assigning parameters to all three parts of the name and two parts of BirthDate.
	 * @param theFirst a string that contains the first name 
	 * @param theMiddle a string that contains the middle name
	 * @param theFamily a string that contains the family name.
	 * @param theDay an int that contains the day
	 * @param theMonth an int that contains the month
	 */
	public Birthinfo( String theFirst, String theMiddle, String theFamily,int theDay, int theMonth) {
		myName = new Name(theFirst, theMiddle, theFamily);
		myBirthDate =  new BirthDate(theDay, theMonth);
	}//5 parameter constructor
	
	/**
	 * Constructs a new Birthinfo object assigning parameters to all two parts of the name and three parts of BirthDate.
	 * @param theFirst a string that contains the first name 
	 * @param theFamily a string that contains the family name.
	 * @param theDay an int that contains the day
	 * @param theMonth an int that contains the month
	 * @param theYear an int that contains the year
	 */
	public Birthinfo( String theFirst, String theFamily,int theDay, int theMonth, int theYear ) {
		myName = new Name(theFirst, theFamily);
		myBirthDate =  new BirthDate(theDay, theMonth, theYear);
	}//5 parameter constructor
	
	/**
	 * Constructs a new Birthinfo object assigning parameters to all three parts of the name .
	* @param theFirst a string that contains the first name 
	 * @param theMiddle a string that contains the middle name
	 * @param theFamily a string that contains the family name.
	 */
	public Birthinfo( String theFirst, String theMiddle, String theFamily) {
		myName = new Name(theFirst, theMiddle, theFamily);
	}//3 parameter constructor
	
	/**
	 *returns the invoking Birthinfo object's three parts of the name. 
	 * @return myFirst - A string that contains the three parts of the name
	 */
	public Name getName() {
		return myName;
	}//getName
	
	/**
	 * returns the invoking Birthinfo object's three parts of the BirthDate. 
	 * @return myFirst - A int that contains the three parts of the BirthDate
	 */
	public BirthDate getBirthDate() {
		return myBirthDate;
	}//getBirthDate
	
	/**
	 * Modifies the name of the invoking Birthinfo object.  
	 * @param myName - the string that contains the new name. 
	 */
	public void setName(Name theName) {
		myName = theName;
	}//setName
	
	/**
	 * Modifies the theBirthDate of the invoking Birthinfo object.  
	 * @param theBirthDate - the int that contains the new theBirthDate. 
	 */
	public void setBirthDate(BirthDate theBirthDate) {
		myBirthDate = theBirthDate;
	}//setBirthDate
	
	/**
	 * Overrides the toString() method of the Object class
	 * returns a string in the format of the name(family, first, middle) and the BirthDate(month, day, year). 
	 * @return a String in the format of the last name, first name and middle name and month, day and year. 
	 */
	public String toString() {
		return myName.toString() + myBirthDate.toString(); 
	}
	
	/**
	 * Overrides the equals() method of the Object class
	 * Compares the first, middle and last name 
	 * of the invoking Birthinfo and parameter Birthinfo. 
	 * Returns true of each pair of the string is the same. 
	 */
	public boolean equals(Object theOther ) {
		Birthinfo theBirthinfo = (Birthinfo)theOther;
		return myName.equals(theBirthinfo.myName);
	}
	
	/**
	 * Compares invoking Name to the parameter Name using the 
	 * compareTo() method of the string class.
	 * The family names are first compared.
	 * If the family names are not equal,
	 * then the comparison is complete and the value is returned
	 * by the comapreTo() method of the string class. 
	 * If the family names are equal then the comparison is between the first names.
	 * These are compared using the compareTo() method of the string class.
	 * If the first names are not equal then the comparison is complete and the value 
	 * returned using the compareTo() method of the string class. If the first names 
	 * are equal then the middle names are compared using the compareTo() method of 
	 * the string class and the value returned by the compareTo() method of the string 
	 * class is returned. 
	 * @param theName - theName object to which the invoking object is being compared. 
	 * @return - returns a positive value if the invoking Name's family name is alphabetically
	 * after the parameter's family name or the invoking name and the parameter Name
	 * have the same family name and the first name of the invoking Name is after the first name
	 * of the parameter name or the family and first names of the invoking name and the 
	 * parameter name are the same and the middle name of the invoking name is after the middle 
	 * of the parameter Name.  
	 * returns are negative value if the invoking Name's
	 * family name is alphabetically before the parameter's family name or the invoking name 
	 * and the parameter Name have the same family name 
	 * and the first name of the invoking Name is before the first name
	 * of the parameter name or the family and first names of the invoking name and the 
	 * parameter name are the same and the middle name of the invoking name is before the middle 
	 * of the parameter Name.  
	 * returns 0 if all the three parts of the invoking and parameter 
	 * Name are the same  
	 */
	
	public int compareTo(Birthinfo theBirthinfo) {
		return myName.compareTo(theBirthinfo.myName);
	}
	
	
	 public boolean beforeAlpha(Birthinfo theBirthinfo) {
		return compareTo(theBirthinfo) < 0;
	 }
	 
	 public boolean berforeChron(Birthinfo theBirthinfo) {
		 if ((myName.before(theBirthinfo.myName) && myBirthDate.equals(theBirthinfo.myBirthDate))
			 || myBirthDate.before(theBirthinfo.myBirthDate));
		 return true;
	 }
	  
			
}
