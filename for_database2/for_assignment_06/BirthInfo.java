package for_assignment_06;

import java.util.Comparator;
public class BirthInfo implements  Comparable<BirthInfo>{
	/**
	 * The name for this object is a reference to a Name object.
	 */
	private Name myName;//three strings for the parts of the name

	/**
	 * The birth date for this object is a reference to a BirthDate object.
	 */
	private BirthDate myBD;//three ints for the month, day, and year of the birth date

	/**
	 * A chronological comparator that compares 2 BirthInfo objects using
	 * month as the first key, day as the second key, year as the third key, and
	 * the name as the fourth key.
	 */
	public static final ChronComp CHRON_COMP = new ChronComp();

	/**
	 * Constructor that is used when all 6 pieces of data are available
	 * @param theFirst - the given name of the person
	 * @param theMiddle - the middle name of the person
	 * @param theFamily - the family name of the person
	 * @param theMonth - the month of birth
	 * @param theDay - the day in the month of birth
	 * @param theYear - the year of birth
	 */
	public BirthInfo(String theFirst, String theMiddle, String theFamily, int theMonth, int theDay, int theYear){
		myName = new Name(theFirst, theMiddle, theFamily);
		myBD = new BirthDate(theMonth, theDay, theYear);
	}//6 parameter constructor

	/**
	 * Constructor that is used when the year of birth is not known
	 * @param theFirst - the given name of the person
	 * @param theMiddle - the middle name of the person
	 * @param theFamily - the family name of the person
	 * @param theMonth - the month of birth
	 * @param theDay - the day in the month of birth
	 */
	public BirthInfo(String theFirst, String theMiddle, String theFamily, int theMonth, int theDay){
		myName = new Name(theFirst, theMiddle, theFamily);
		myBD = new BirthDate(theMonth, theDay);
	}//5 parameter constructor no year of birth date

	/**
	 * Constructor that is used when the middle name of the person is not known
	 * @param theFirst - the given name of the person
	 * @param theFamily - the family name of the person
	 * @param theMonth - the month of birth
	 * @param theDay - the day in the month of birth
	 * @param theYear - the year of birth
	 */
	public BirthInfo(String theFirst, String theFamily, int theMonth, int theDay, int theYear){
		myName = new Name(theFirst, theFamily);
		myBD = new BirthDate(theMonth, theDay, theYear);
	}//5 parameter constructor no middle name

	/**
	 * Constructor that is used when both the middle name and the year of birth are not known
	 * @param theFirst - the given name of the person
	 * @param theFamily - the family name of the person
	 * @param theMonth - the month of birth
	 * @param theDay - the day in the month of birth
	 */
	public BirthInfo(String theFirst, String theFamily, int theMonth, int theDay){
		myName = new Name(theFirst, theFamily);
		myBD = new BirthDate(theMonth, theDay);
	}//4 parameter constructor

	/**
	 * Constructor that is used when only the three strings for the name are known
	 * @param theFirst - the given name of the person
	 * @param theMiddle - the middle name of the person
	 * @param theFamily - the family name of the person
	 */
	public BirthInfo(String theFirst, String theMiddle, String theFamily){
		myName = new Name(theFirst, theMiddle, theFamily);
		myBD = new BirthDate();
	}//3 parameter constructor no birth date

	/**
	 * Access method for the Name instance variable
	 * @return the Name of this BirthInfo object
	 */
	public Name getName(){
		return myName;
	}//getName

	/**
	 * Access method for the BirthDate instance variable
	 * @return the BirthDate of this BirthInfo object
	 */
	public BirthDate getBirthDate(){
		return myBD;
	}//getBirthDate

	/**
	 * Modifier method for the Name instance variable
	 * @param theName the new value for the Name instance variable
	 */
	public void setName(Name theName){
		myName = theName;
	}//setName

	/**
	 * Modifier method for the BirthDate instance variable
	 * @param theBirthDate the new value for the BirthDate instance variable
	 */
	public void setBirthDate(BirthDate theBirthDate){
		myBD = theBirthDate;
	}//setBirthDate

	/**
	 * returns a String representation of this BirthInfo object 
	 * using the toString methods in classes Name and BirthDate
	 * @return - the String representation of this object
	 */
	public String toString(){
		return myName + " " + myBD;
	}//toString

	/**
	 * Overrides the equals method in the Object class and
	 * uses only the equals method of class Name to determine equality
	 * @param theOther - the object to which this BirthInfo object is being compared for equality
	 * @return true if the Name instance variables of the this object and the parameter object are equal, false otherwise
	 */
	public boolean equals(Object theOther){
		BirthInfo theBirthInfo = (BirthInfo)theOther;
		return myName.equals(theBirthInfo.myName);
	}//equals

	/**
	 * Compares this BirthInfo object to the parameter using 
	 * only the compareTo of the Name class
	 * @param theBirthInfo - the object to which this BirthInfo object is being compared
	 * @return a negative value if this BirthInfo object's Name is before the parameter object's Name
	 * a positive value if this BirthInfo objects Name is after the parameter object's Name
	 * and zero if this BirthInfo object's Name is the equal to the parameter object's Name
	 */
	public int compareTo(BirthInfo theBirthInfo){
		return myName.compareTo(theBirthInfo.myName);
	}//compareTo


	/**
	 * A class that implements the Comparator interface so that we can construct
	 * an object that can compare BirthInfo objects using the chronological ordering scheme
	 * @author Barbara Li Santi
	 */
	public static class ChronComp implements Comparator<BirthInfo>{
		/**
		 * method needed by the Comparator object to compare two
		 * BirthInfo objects using the chronological ordering scheme
		 * @param bI1 - the first BirthInfo object being compared
		 * @param bI2 - the second BirthInfo object being compared
		 * @return a negative value if the first BirthInfo object is chronologically before the second BirthInfo Object
		 * a positive value if the first BirthInfo object is chronologically after the second BirthInfo object
		 * or zero if the two BirthInfo objects are equal with respect to the chronological ordering schmem
		 */
		public int compare (BirthInfo bI1, BirthInfo bI2){
			return (bI1.myBD.compareTo(bI2.myBD) != 0 ? 
					bI1.myBD.compareTo(bI2.myBD) : bI1.compareTo(bI2));
		}//compare
	}//ChronComp
	
	public boolean beforeChron(BirthInfo theBirthInfo) {
		return (myBD.compareTo(theBirthInfo.myBD)<0) 
				|| ((myBD.equals(theBirthInfo.myBD)) &&
						(myName.compareTo(theBirthInfo.myName)<0));
	}

}//BirthInfo
