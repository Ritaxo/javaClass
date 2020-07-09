package for_arrays_and_for_loops_lab;


public class NewArraysAndForLoopsPart2 {
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
		System.out.println(msg);
		for (int i = 0; i < myInts.length; i++) {
			System.out.print(myInts[i] + "\t");//tabs between values
			if( i % 10 == 9) {//10 values will be displayed per line
				System.out.println();
			}//if
		}//for
		System.out.println();//makes a blank line at the end
	}//displayMyNumbers
	
	/**
	 * Calculates and returns the sum of all the elements in the array 
	 * that are greater than an int param. 
	 * @param a - an int param, the elements need to be greater than this param. 
	 * @return- the sum of the elements greater than a. 
	 */
	public static int sumOfAllIntsGreaterThan(int a ) {
		int sum = 0;
		for (int i=0; i<  myInts.length; i++) {
			//random ints will be in range 0-49
			if (myInts[i] > a) { 
				sum = sum + myInts[i];
			}//if
		}//for
		return sum;
	}//sumOfAllints
	
	/**
	 * Replaces every value in the array that matches an int param with -1 
	 * @param a- user given int param, which is replaced by -1
	 */
	public static void matchesAnInt(int a ) {
		for (int i=0; i<  myInts.length; i++) {
			//random ints will be in range 0-49
			if (myInts[i] == a) {
				myInts[i] = -1;
			}//if
		}//for
	}//matchesAnInt
	
	/**
	 * Reverses the order in which the ints are stored in the array. 
	 */
	public static void reverseMyInts() {
		for (int i = 0; i <myInts.length/2;  i++) {
			int hold = myInts[i];
			myInts[i] = myInts[myInts.length -i-1];
			myInts[myInts.length -i-1] = hold;
		}//for
	}//reverseMyInts
	
	/**
	 * Rotates the elements in the array by one position. 
	 */
	public static void rotatesMyIntsBy1() {
		int []temp =new int [myInts.length];
		for (int i= 0; i<myInts.length-1; i++) {
			temp [i+1] = myInts[i];
		}for(int i=0; i<1; i++ ) {
			temp[i]=myInts[myInts.length-1+i];
		}
		myInts = temp;
	}//rotatesMyInts by one
	
	/**
	 *Rotates the elements in the array by two position. 
	 */
	public static void rotatesMyIntsBy2() {
		int []temp =new int [myInts.length];
		for (int i= 0; i<myInts.length-2; i++) {
			temp[i+2] = myInts[i];

		}for(int i=0; i<2; i++ ) {
			temp[i]=myInts[myInts.length-2+i];
		}
		myInts = temp;
	}//rotatesMyInts by n
	
	/**
	 * Rotates the elements in the array by n position
	 * @param n- int param , rotates the array by n positions. . 
	 */
	public static void rotatesMyInts(int n) {
		int []temp =new int [myInts.length];
		for (int i= 0; i<myInts.length-n; i++) {
			temp[i+n] = myInts[i];

		}for(int i=0; i<n; i++ ) {
			temp[i]=myInts[myInts.length-n+i];
		}
		myInts = temp;
	}//rotatesMyInts by n 
	
	/**
	 * This method displays the elements in the array that are in 
	 * positions that are multiples of 5. 
	 * @param msg:The message displayed before the elements. 
	 */
	public static void displayMultiplesOf5(String msg) {
		System.out.println(msg);
		for (int i = 0; i < myInts.length; i++) {
			if(i % 5 == 0 ) {
				System.out.print(myInts[i] + "\t");//tabs between values
			}
			if( i % 9 == 4 ) {
				System.out.println();
			}//if
		}//for
		System.out.println();//makes a blank line at the end
	}//displayMyNumbers
	
	/**
	 * This method displays the elements in the array that are in 
	 * positions that are multiples of 4. 
	 * @param msg:The message displayed before the elements.  
	 */
	public static void displayMultiplesOf4(String msg) {
		System.out.println(msg);
		for (int i = 0; i < myInts.length; i++) {
			if(i % 4 == 0 ) {
				System.out.print(myInts[i] + "\t");//tabs between values
			}
			if( i % 10 == 4) {
				System.out.println();
			}//if
		}//for
		System.out.println();//makes a blank line at the end
	}//displayMyNumbers
	
	/**
	 * This method displays the elements in the array that are in 
	 * positions that are multiples of given param. 
	 * @param msg:The message displayed before the elements. 
	 * @param n- an int param.  
	 */
	public static void displayMultiplesOfn(String msg, int n) {
		System.out.println(msg);
		for (int i = 0; i < myInts.length; i++) {
			if(i % n == 0 ) {
				System.out.print(myInts[i] + "\t");//tabs between values
			}
			if( i % 10 == n) {
				System.out.println();
			}//if
		}//for
		System.out.println();//makes a blank line at the end
	}//displayMyNumbers
	
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
		matchesAnInt(0);
		displayMyInts("\nThe 0's in the array have been made -1: \n");
		rotatesMyIntsBy1();
		displayMyInts("\nElements in the array rotated by one position: \n");
		System.out.println("The sum of all the ints greater than 49  " + sumOfAllIntsGreaterThan(49));
		reverseMyInts();
		displayMyInts("\nThe ints in the array have been reversed: \n");
		displayMultiplesOf5("\nThe ints whose indexs are multiples of 5: \n");
		displayMultiplesOf4("\nThe ints whose indexs are multiples of 4: \n");
		displayMultiplesOfn("\nThe ints whose indexs are multiples of 9: \n", 9);
	}//main
}//ArraysAndForLoops
