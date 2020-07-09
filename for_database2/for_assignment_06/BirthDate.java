package for_assignment_06;

import java.util.Calendar;
/**
 * A BirthDate objects that consists of three ints corresponding 
 * to each part of a person's BirthDate. 
 */
public class BirthDate {
	
	/**
	 * An int that contains the day
	 */
	private int myDay;//reference to a person's day of birth date
	
	/**
	 * An int that contains the month
	 */
	private int myMonth;//reference to a person's month of birth date
	
	/**
	 * An int that contains the year
	 */
	private int myYear;//reference to a person's year of birth date
	
	/**
	 * An array that contains the no. of days in each month
	 */
	static final int[] MAX_DAYS_IN_MONTHS = {0,31,29,31,30,31,30,31,31,30,31,30,31};
	
	/**
	 * An array that contains the names of the months
	 */
	static final String[] MONTH_NAMES = {"","January", "february","March","April","May","June","July","August","September","October","November","December"};
	
	static final String[] DAYS_IN_MONTHS = {"","1", "2", "3", "4","5","6","7","8", "9","10", "11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","28","29","30"};
	
	/**
	 * Constructs a new BirthDate object assigning parameters to all three parts of the BirthDate.
	 * @param theDay an int that contains the day
	 * @param theMonth an int that contains the month 
	 * @param theYear an int that contains the year 
	 */
	public BirthDate (int theMonth, int theDay, int theYear) {
		myDay = theDay;
		myMonth = theMonth;
		myYear = theYear;
	}//3 parameter constructor
	
	/**
	 * Constructs a new BirthDate object assigning parameters to all two parts of the BirthDate.
	 * @param theDay an int that contains the day 
	 * @param theMonth an int that contains the year
	 */
	public BirthDate (int theMonth, int theDay) {
		myMonth = theMonth;
		myDay = theDay;
		myYear = 0;
	}//2 parameter constructor
	
	/**
	 * Constructs a new BirthDate object with no parameters.
	 */
	public BirthDate () {
		myDay = 0;
		myMonth = 0;
		myYear = 0;
	}//0 parameter constructor
	
	/**
	 * returns the invoking BirthDate's month.
	 * @return myMonth an int that contains the month 
	 */
	public int getMonth() {
		return myMonth;
	}//setMonth
	
	/**
	 *  Modifies the Month of the invoking BirthDate object.
	 * @param theMonth an int that contains the new month
	 */
	public void setMonth(int theMonth) {
		if(theMonth > 0 && theMonth <= 12) {
			myMonth = theMonth;
		}//if
		else{
			System.out.println("Please enter a month value between 1-12.");
		}//else
	}//setMonth
	
	/**
	 * returns the invoking BirthDate's day.
	 * @return myDay an int that contains the Day
	 */
	public int getDay() {
		return myDay;
	}//getDay
	
	/**
	 * Modifies the day of the invoking BirthDate object.
	 * @param theDay an int that contains the new day
	 */
	public void setDay(int theDay) {
		if(theDay >=1 && theDay<= MAX_DAYS_IN_MONTHS[myMonth]) {
			myDay = theDay;
		}//if
		else {
			System.out.println(theDay + "is out of range for" + MONTH_NAMES[myMonth]);
		}//else
		
	}//else
	
	/**
	 * returns the invoking BirthDate's year.
	 * @return myYear myDay an int that contains the year
	 */
	public int getYear() {
		return myYear;
	}//getYear
	
	
	/**
	 * Modifies the year of the invoking BirthDate object.
	 * @param theYear an int that contains the new Year
	 */
	public void setYear(int theYear) {
		if(theYear <= Calendar.YEAR) {
			myYear = theYear;
		}//if
		else {
			System.out.println("Please enter a year less than" + Calendar.YEAR);	
		}//else
	}
	
	/**
	 * Overrides the equal() method of Object class.
	 * Compares the day, month and year 
	 * of the invoking BirthDate and parameter BirthDate. 
	 * Returns true of each pair of the int is the same. 
	 * @param theOther - the object to which the invoking name is being compared.
	 * @return the result of invoking the equals() method of the int class. 
	 * on the day, month and year parts of the invoking BirthDate and parameter BirthDate.
	 */
	public boolean equals(Object theOther) {
		BirthDate theBirthDate = (BirthDate)theOther;
		return myMonth == theBirthDate.myMonth
				&& myDay == theBirthDate.myDay
				&& myYear == theBirthDate.myYear;
	}// equals
	
	/**
	 * Calls the compareTo() method of this class with 
	 * the parameter BirthDate object. Returns true if the compareTo()
	 * method returns a negative value.
	 * @param theBirthDate the BirthDate object being compared
	 * @return true if the compareTo() method returns a negative value,
	 * indicating that the invoking BirthDatete is before the parameter.  
	 */
	public boolean before (BirthDate theBirthDate) {
		return myMonth < theBirthDate.myMonth  
				||((myMonth == theBirthDate.myMonth) && (myDay < theBirthDate.myDay)) 
				||((myMonth == theBirthDate.myMonth) && (myDay == theBirthDate.myDay) && (myYear < theBirthDate.myYear));
		}//before
	
	/**
	 * Compares invoking BirthDate to the parameter BirthDateusing the 
	 * compareTo() method of the int class.
	 * The BirthDate months are first compared.
	 * If the BirthDate months are not equal,
	 * then the comparison is complete and the value is returned
	 * by the comapreTo() method of the int class. 
	 * If the BirthDate months are equal then the comparison is between the BirthDate days.
	 * These are compared using the compareTo() method of the int class.
	 * If the first names are not equal then the comparison is complete and the value 
	 * is returned using the compareTo() method of the int class. If the BirthDate days 
	 * are equal then the BirthDate Years are compared using the compareTo() method of 
	 * the int class and the value returned by the compareTo() method of the int 
	 * class is returned. 
	 * @param theBirthDate - theBirthDate object to which the invoking object is being compared. 
	 * @return - returns a positive value if the invoking BirthDate's month is alphabetically
	 * after the parameter's BirthDate month or the invoking BirthDate and the parameter BirthDate
	 * have the same month and the BirthDate days of the invoking BirthDate is after the day  
	 * of the parameter BirthDate or the month and day BirthDate of the invoking BirthDate and the 
	 * parameter BirthDate are the same and the BirthDate year of the invoking BirthDate is after the year 
	 * of the parameter BirthDate.  
	 * returns are negative value if the invoking BirthDate's
	 * month is alphabetically before the parameter's BirthDate month or the invoking BirthDate 
	 * and the parameter BirthDate have the same BirthDate month 
	 * and the BirthDate day of the invoking BirthDate is before the BirthDate day
	 * of the parameter  BirthDate or the month and day of the invoking  BirthDate and the 
	 * parameter  BirthDate are the same and the  BirthDate year of the invoking BirthDate is before the year 
	 * of the parameter BirthDate.  
	 * returns 0 if all the three parts of the invoking and parameter 
	 * BirthDate are the same  
	 */
	public int compareTo (BirthDate theBirthDate) {
		int compareMonth = myMonth - theBirthDate.myMonth; 
		if (compareMonth != 0) {
			return compareMonth;
		}// the Months were different
		int compareDay = myDay - theBirthDate.myDay; 
		if (compareDay != 0) {
			return compareDay;
		}//  Days were different with identical Months names 
		return myYear - theBirthDate.myYear;
	}// compareTo
	
	/**
	 * Overrides the toString() method of the Object class
	 * returns a string in the format of the month, day and year. 
	 * @return a String in the format of the month, day and year.
	 */
	public String toString(){
		if(myMonth == 0) {
			return "";
		}//if default birthdate with no data
		return MONTH_NAMES[myMonth] + " " + myDay + (myYear !=0 ? ", " + myYear : "");     	
	}
	
}
