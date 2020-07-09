package for_cs64_exam_1;


/**
 * A person's name.
 * @author Barbara Li Santi
 *
 */
public class Name implements Comparable<Name>{
	/**
	 * The first name.
	 */
	private String myFirst;
	/**
	 * The middle name (optional).
	 */
	private String myMiddle;
	/**
	 * The last name.
	 */
	private String myFamily;

	/**
	 * Constructor including the middle name.
	 * @param theFirst The first name.
	 * @param theMiddle The middle name.
	 * @param theFamily The last name.
	 */
	public Name(String theFirst, String theMiddle, String theFamily){
		myFirst = theFirst;
		myMiddle = theMiddle;
		myFamily = theFamily;
	}//3 parameter constructor

	/**
	 * Constructor without the middle name.
	 * @param theFirst The first name.
	 * @param theFamily The last name.
	 */
	public Name(String theFirst, String theFamily){
		myFirst = theFirst;
		myMiddle = "";
		myFamily = theFamily;
	}//2 parameter constructor

	/**
	 * Access method for the first name.
	 * @return String representation of the first name.
	 */
	public String getFirst(){
		return myFirst;
	}//getFirst

	/**
	 * Changes the first name.
	 * @param theFirst The new first name.
	 */
	public void setFirst(String theFirst){
		myFirst = theFirst;
	}//setFirst

	/**
	 * Access method for the middle name.
	 * @return String representation of the middle name.
	 */
	public String getMiddle(){
		return myMiddle;
	}//getMiddle

	/**
	 * Changes the middle name.
	 * @param theMiddle The new middle name.
	 */
	public void setMiddle(String theMiddle){
		myMiddle = theMiddle;
	}//theMiddle

	/**
	 * Access method for the last name.
	 * @return String representation of the last name.
	 */
	public String getFamily(){
		return myFamily;
	}//getFamily

	/**
	 * Changes the last name.
	 * @param theFamily The new last name.
	 */
	public void setFamily(String theFamily){
		myFamily = theFamily;
	}//theFamily

	/**
	 * Checks if the invoking name is identical to the parameter name.
	 * @param theOther The name to be compared.
	 * @return True if the names are equal, false if they are not equal.
	 */
	public boolean equals(Object theOther){
		Name theName = (Name)theOther;
		return myFamily.equals(theName.myFamily)
				&& myFirst.equals(theName.myFirst)
				&& myMiddle.equals(theName.myMiddle);
	}//equals

	/**
	 * Compares the invoking name to the parameter name
	 * @param theName The name to be compared.
	 * @return Negative if the invoking name is before the parameter, 0 if they are equal, and positive if the invoking
	 * name comes after the parameter.
	 */
	public int compareTo(Name theName){
		int compareFamily = myFamily.compareTo(theName.myFamily);
		if(compareFamily !=0){
			return compareFamily;
		}//family names were different
		int compareFirst = myFirst.compareTo(theName.myFirst);
		if(compareFirst !=0){
			return compareFirst;
		}//family names were the same, but first names were different
		return myMiddle.compareTo(theName.myMiddle);
	}//compareTo

	/**
	 * Checks whether the invoking name is before the parameter name.
	 * @param theName The name to be compared.
	 * @return True if the invoking name is before, False if the invoking name is not before.
	 */
	public boolean before(Name theName){
		return compareTo(theName) < 0;
	}//before

	/**
	 * Checks whether the invoking name is after the parameter name.
	 * @param theName The name to be compared.
	 * @return True if the invoking name is after, False if the invoking name is not after.
	 */
	public boolean after(Name theName){
		return compareTo(theName) > 0;
	}//after

	/**
	 * String representation of the name.
	 */
	public String toString(){
		return  myFamily + ", " + myFirst + (!myMiddle.equals("")? " " + myMiddle : "");
	}//toString

}//Name