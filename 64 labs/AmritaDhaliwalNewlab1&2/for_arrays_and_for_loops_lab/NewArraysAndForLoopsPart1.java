
package for_arrays_and_for_loops_lab;

public class NewArraysAndForLoopsPart1 {
	// reference to an array to hold some random ints
	private static int myInts[];
	//constant maximum number of elements in the array
	private static final int MAXNUMS = 100;

	/**
	 * Displays the list of all ints in the array. 
	 * Is called to display the ints for other methods. 
	 * @param msg- Displays a message before the ints. 
	 */
	private static void displayMyInts(String msg) {
		System.out.println(msg + "Amrita Dhaliwal");
		for (int i = 0; i < myInts.length; i++) {
			System.out.print(myInts[i] + "\t");//tabs between values
			if( i % 10 == 9) {//10 values will be displayed per line
				System.out.println();
			}//if
		}//for
		System.out.println();//makes a blank line at the end
	}//displayMyNumbers
	
	/**
	 * Determines and returns the maximum value stored in the array
	 */
	private static void displayMaximum() {
		
		int toReturn = myInts[0];
		for (int i = 1; i < myInts.length; i++) {
			if(myInts[i] > toReturn) {
				toReturn = myInts[i];
			}//if
		}//for
		System.out.println("\n The maximum number in the array is: \n"+ toReturn + "\t");
	}//displayMaximum
	
	/**
	 * Determines and returns the minimum value stored in the array
	 */
	private static void displayMinimum() {
		int toReturn = myInts[0];
		for (int i = 0; i < myInts.length; i++) {
			if(myInts[i] < toReturn) {
				toReturn = myInts[i];
				}//if
			}//for
		System.out.println("\n The minimum number in the array is: \n" + toReturn + "\t");
	}//displayMinimum
	
	/**
	 * Displays a list of all the elements in the array that are greater than an  parameter a
	 * @param msg- msg displayed when displaying the ints.
	 * @param a- int parameter
	 */
	private static void searchindisplayMyInts(String msg, int a) {
		System.out.println(msg);
		for (int i = 0; i < myInts.length; i++) {
			if(a < myInts[i]) {
				System.out.print(myInts[i] + "\t");
				}//if
			if(i == myInts.length) {
				System.out.print("There is no int greater than" + a);
			}
			}//for
	}//searchdisplayMyInts
	
	/**
	 *Displays the list of all even ints in the array. 
	 */
	private static void displayMyEvenInts() {
		int toReturn = myInts[0];
		for (int i = 0; i < myInts.length; i++) {
			if(myInts[i] % 2 == 0) {
				toReturn = myInts[i];
				System.out.print(myInts[i] + "\t");
				}//if
			}//for
	}//displayMinimum
	
	/**
	 * Calculates and returns the number of elements in the array that are even. 
	 * @return- number of even ints in the array
	 */
	private static int evenInts () {
		int numOfEvens = 0;
		for( int i = 0; i < myInts.length; i++) {
			if(myInts[i] % 2 == 0) {
				numOfEvens ++;
			}
		}//for
		return numOfEvens;
	}
	
	/**
	 * Displays the elements in the array backwards. This method just displays the ints in an reverse order to which the elements are stored in the array
	 * @param msg- msg displayed when displaying the elements.
	 */
	private static void displayMyIntsBackwards(String msg) {
		System.out.println(msg);
		for( int i = myInts.length - 1; i >= 0; i--) {
		System.out.print(myInts[i] + "\t");
		if( i % 10 == 9) {//10 values will be displayed per line
			System.out.println();
		}//if
		}//for
	}
	
	/**
	 * Displays every other element in the array.  
	 * @param msg- the message displayed indicating the start of this new  of the array. 
	 */
	private static void displayEveryOtherInt(String msg) {
		System.out.println(msg);
		for( int i = 0; i < myInts.length; i+=2) {
		System.out.print(myInts[i] + "\t");
		if( i % 10 == 6) {//10 values will be displayed per line
			System.out.println( );
		}//if
		}//for
	}
	
	/**
	 * Calculates and returns the sum of all elements in the array. 
	 * @return
	 */
	private static int sum () {
		int mySum = 0;
		for( int i = 0; i < myInts.length; i++) {
			mySum += myInts[i];
		}//for
		return mySum;
	}
	
	
	public static void main (String args[]) {
		//allocate array to hold the ints
		myInts = new int [MAXNUMS];
		System.out.println("Array will contain " + myInts.length + 
				" random integers in the range 0-49");
		// generate random ints
		for (int i=0; i<  myInts.length; i++) {
			//random ints will be in range 0-49
			myInts[i]=(int) (Math.random() * 50);
		}//for
		// display values in the array with message
		displayMyInts("\nThe ints in the array are: \n");
		displayMaximum();
		displayMinimum();
		searchindisplayMyInts("\n All of the ints larger than 45 are: \n ",45);
		searchindisplayMyInts("\n There are no ints larger than 50: \n ",50);
		displayMyEvenInts();
		System.out.print("\nThe total number even ints in the array are " + evenInts () + "\n");
		displayMyIntsBackwards("\n The ints written backwards will be: \n");
		displayEveryOtherInt("Everyother Int in the array are:");
		System.out.print("\nThe sum of all the elements in the array is " + sum () + "\n");
	}//main

}//ArraysAndForLoops
