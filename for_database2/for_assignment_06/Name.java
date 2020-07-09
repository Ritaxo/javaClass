package for_assignment_06;/** * A Name objects that consists of three Strings, corresponding  * to each part of a person's name.  */public class Name implements Comparable<Name>{	/**	 * A string that contains the first name	 */		private String myFirst;//reference to a person's given name	/**	 * A string that contains the middle name 	 */	private String myMiddle;//reference to a person's middle name	/**	 * A string that contains the family name. 	 */	private String myFamily;//reference to a person's family name	/**	 * Constructs a new Name object assigning parameters to all three parts of the name. 	 * @param theFirst a string that contains the first name	 * @param theMiddle a string that contains the middle name 	 * @param theFamily a string that contains the family name.	 */	public Name(String theFirst, String theMiddle, String theFamily) {		myFirst = theFirst;		myMiddle = theMiddle;		myFamily = theFamily;	}//3 parameter constructor		/**	 *  Constructs a new Name object assigning parameters to two parts of the name. 	 * @param theFirst a string that contains the first name.	 * @param theFamily a string that contains the family name.	 */	public Name(String theFirst, String theFamily) {		myFirst = theFirst;		myMiddle = "";		myFamily = theFamily;	}//2 parameter constructor/** * returns the invoking name's first name.  * @return myFirst - A string that contains the first name */	public String getFirst() {		return myFirst;	}//getFirst		/**	 *returns the invoking name's middle name.  	 * @return myMiddle-A string that contains the middle name	 */	public String getMiddle() {		return myMiddle;	}//getMiddle		/**	 * returns the invoking family's middle name.	 * @return myFamily - A string that contains the middle name 	 */	public String getFamily() {		return myFamily;	}//getFamily	/**	 * Modifies the first name of the invoking name object.  	 * @param theFirst - the string that contains the new first name. 	 */	public void setFirst(String theFirst) {		myFirst = theFirst;	}//setFirst		/**	 *Modifies the middle name of the invoking name object.  	 * @param theMiddle -the string that contains the new middle name. 	 */	public void setMiddle(String theMiddle) {		myMiddle = theMiddle;	}//setMiddle		/**	 * Modifies the family name of the invoking name object.	 * @param theFamily-the string that contains the new family name. 	 */	public void setFamily(String theFamily) {		myFamily = theFamily;	}//setFamily	/**	 * Overrides the equal() method of Object class.	 * Compares the first, middle and last name 	 * of the invoking Name and parameter Name. 	 * Returns true of each pair of the string is the same. 	 * @param theOther - the object to which the invoking name is being compared.	 * @return the result of invoking the equals() method of the string class. 	 * on the first, middle and the family parts of the invoking Name and parameter.	 */	public boolean equals(Object theOther) {		Name theName = (Name)theOther;		return myFamily.equals(theName.myFamily) 				&& myFirst.equals(theName.myFirst)				&& myMiddle.equals(theName.myMiddle);	}// equals		/**	 * Compares invoking Name to the parameter Name using the 	 * compareTo() method of the string class.	 * The family names are first compared.	 * If the family names are not equal,	 * then the comparison is complete and the value is returned	 * by the comapreTo() method of the string class. 	 * If the family names are equal then the comparison is between the first names.	 * These are compared using the compareTo() method of the string class.	 * If the first names are not equal then the comparison is complete and the value 	 * returned using the compareTo() method of the string class. If the first names 	 * are equal then the middle names are compared using the compareTo() method of 	 * the string class and the value returned by the compareTo() method of the string 	 * class is returned. 	 * @param theName - theName object to which the invoking object is being compared. 	 * @return - returns a positive value if the invoking Name's family name is alphabetically	 * after the parameter's family name or the invoking name and the parameter Name	 * have the same family name and the first name of the invoking Name is after the first name	 * of the parameter name or the family and first names of the invoking name and the 	 * parameter name are the same and the middle name of the invoking name is after the middle 	 * of the parameter Name.  	 * returns are negative value if the invoking Name's	 * family name is alphabetically before the parameter's family name or the invoking name 	 * and the parameter Name have the same family name 	 * and the first name of the invoking Name is before the first name	 * of the parameter name or the family and first names of the invoking name and the 	 * parameter name are the same and the middle name of the invoking name is before the middle 	 * of the parameter Name.  	 * returns 0 if all the three parts of the invoking and parameter 	 * Name are the same  	 */	public int compareTo(Name theName) {		int compareFamily = myFamily.compareTo(theName.myFamily); 		if (compareFamily != 0) {			return compareFamily;		}// family names were different		int compareFirst = myFirst.compareTo(theName.myFirst); 		if (compareFirst != 0) {			return compareFirst;		}//  first names were different with identical family names 		return myMiddle.compareTo(theName.myMiddle);	}// compareTo	 	/**	 * Calls the compareTo() method of this class with 	 * the parameter Name object. Returns true if the compareTo()	 * method returns a negative value.	 * @param theName the Name object being compared	 * @return true if the compareTo() method returns a negative value,	 * indicating that the invoking NAme is before the parameter.  	 */	public boolean before(Name theName) {		return compareTo(theName) < 0;	}//before 		/**	 * Calls the compareTo() method of this class with 	 * the parameter Name object. Returns true if the compareTo()	 * method returns a positive value.	 * @param theName the Name object being compared	 * @return true if the compareTo() method returns a positive value,	 * indicating that the invoking Name is after the parameter.	 */	public boolean after(Name theName) {		return compareTo(theName) > 0;	}//after		/**	 * Overrides the toString() method of the Object class	 * returns a string in the format of the last name, first name and middle name. 	 * @return a String in the format of the last name, first name and middle name. 	 */	public String toString() {			return myFamily + ", " + myFirst + (myMiddle.equals("") ? "" : " " + myMiddle);			}//toString}// Name