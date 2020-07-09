
package for_arrays_and_for_loops_lab;

public class ArraysAndForLoops {
	// reference to an array to hold some random ints
	private static int myInts[];
	//constant maximum number of elements in the array
	private static final int MAXNUMS = 100;

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
	
	private static void displayMaximum() {
		
		int toReturn = myInts[0];
		for (int i = 1; i < myInts.length; i++) {
			if(myInts[i] > toReturn) {
				toReturn = myInts[i];
			}//if
		}//for
		System.out.println("\n The maximum number in the array is: \n"+ toReturn + "\t");
	}//displayMaximum
	
	private static void displayMinimum() {
		int toReturn = myInts[0];
		for (int i = 0; i < myInts.length; i++) {
			if(myInts[i] < toReturn) {
				toReturn = myInts[i];
				}//if
			}//for
		System.out.println("\n The minimum number in the array is: \n" + toReturn + "\t");
	}//displayMinimum
	
	private static void searchindisplayMyInts(String msg, int a) {
		System.out.println(msg);
		for (int i = 0; i < myInts.length; i++) {
			if(a < myInts[i]) {
				System.out.print(myInts[i] + "\t");
				}//if
			}//for
	}//searchdisplayMyInts
	
	private static void displayMyEvenInts() {
		int toReturn = myInts[0];
		for (int i = 0; i < myInts.length; i++) {
			if(myInts[i] % 2 == 0) {
				toReturn = myInts[i];
				System.out.print(myInts[i] + "\t");
				}//if
			}//for
	}//displayMinimum
	
	private static int evenInts () {
		int numOfEvens = 0;
		for( int i = 0; i < myInts.length; i++) {
			if(myInts[i] % 2 == 0) {
				numOfEvens ++;
			}
		}//for
		return numOfEvens;
	}
	
	
	private static void displayMyIntsBackwards(String msg) {
		System.out.println(msg);
		for( int i = myInts.length - 1; i >= 0; i--) {
		System.out.print(myInts[i] + "\t");
		if( i % 10 == 9) {//10 values will be displayed per line
			System.out.println();
		}//if
		}//for
	}
	
	private static void displayEveryOtherInt(String msg) {
		System.out.println(msg);
		for( int i = 0; i < myInts.length; i+=2) {
		System.out.print(myInts[i] + "\t");
		if( i % 10 == 6) {//10 values will be displayed per line
			System.out.println( );
		}//if
		}//for
	}
	
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
		displayEveryOtherInt("Everyother Ints in the array are:");
		displayMyIntsBackwards("\n The ints written backwards will be: \n");
		searchindisplayMyInts("\n All of the ints larger than 45 are: \n ",45);
		displayMaximum();
		displayMinimum();
		System.out.print("\nThe sum of the array is " + sum () + "\n");
		System.out.print("\nThe even numbers in the array are " + evenInts () + "\n");
	}//main

}//ArraysAndForLoops
