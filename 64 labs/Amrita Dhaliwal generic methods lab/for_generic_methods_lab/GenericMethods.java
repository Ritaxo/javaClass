package for_generic_methods_lab;

import java.util.*;

public class GenericMethods{

	/**
	 * Displays the list of all elements in the array. 
	 * Is called to display the elements for other methods. 
	 * @param msg- Displays a message before the elements. 
	 */
	public static <E> void display(String msg, E [] theArray, int theCount) {
		System.out.println(msg);
		if(theCount == 0) {
			System.out.println("The array is empty.");
		} else {
			for (int i = 0; i < theCount; i++) {
				System.out.print(theArray[i] + "\t");//tabs between  values
				if( i % 10 == 9) {//10 values will be displayed per line
					System.out.println();
				}//if
			}//for
		}//else - the array had elements to display
		System.out.println();//makes a blank line at the end
	}//display

	/**
	 * 
	 * @param theArray
	 * @param theCount
	 */
	public static <E extends Comparable<E>> void bubbleSort(E[] theArray, int theCount){
		if(theCount > 1) {
			for (int passNum = 1; passNum < theCount; passNum++) {
				for(int j = 0; j < theCount - passNum; j++) {
					if(theArray[j + 1].compareTo( theArray[j]) < 0 ){
						swap(theArray, j, j + 1);
					}//if
				}//inner for
			}//outer for
		}//if there are elements to sort
	}//bubbleSort


	private static <E> void swap (E[] theArray, int firstPos, int secondPos){
		E temp = theArray[firstPos];
		theArray[firstPos] = theArray[secondPos];
		theArray[secondPos] = temp;
	}//swap
	
	/**
	 * Determines and returns the maximum value stored in the array
	 * @param theArray- an array of any type of elements 
	 * @param theCount- the no. of elements in the array
	 * @return- the largest element in the array
	 */
	public static <E extends Comparable <E>> E maximum(E[] theArray, int theCount){
		if(theCount < 1) {
			return null;
		}//empty array has no maximum
		E maxNow = theArray[0];
		for (int i = 1; i < theCount; i++) {
			if(maxNow.compareTo(theArray[i]) < 0){
				maxNow = theArray[i];
			}//if
		}//for
		return maxNow;
	}//maximum
	
	/**
	 * Determines and returns the minimum value stored in the array
	 * @param theArray- an array of any type of elements 
	 * @param theCount- the no. of elements in the array
	 * @return- the smallest element in the array
	 */
	public static <E extends Comparable <E>> E minimum (E[] theArray, int theCount){
		if(theCount < 1) {
			return null;
		}//empty array has no minimum
		E minNow = theArray[0];
		for (int i = 1; i < theCount; i++) {
			if(minNow.compareTo(theArray[i]) > 0){
				minNow = theArray[i];
			}//if
		}//for
		return minNow;
	}//minimum
	
	/**
	 * Displays a list of all the elements in the array that are greater than an  parameter a
	 * @param msg- msg displayed when displaying the elements.
	 * @param theArray- an array of any type of elements 
	 * @param a- E parameter, i.e the paramater should be of the type that the array is. 
	 *  @param theCount- the no. of elements in the array
	 */
	public static <E extends Comparable <E>> void searchindisplayMyInts(String msg, E[] theArray, E a, int theCount ) {
		System.out.println(msg);
		int j = 0;
		for (int i = 0; i <= theCount-1; i++) {
			if(a.compareTo(theArray[i]) < 0) {
				System.out.print(theArray[i] + "\t");
				j++;
			}//if
			}
			if(j == theCount) {
				System.out.print("There is no int greater than" + a);
			}//for
	}//searchdisplayMyInts
	
	/**
	 * Displays the elements in the array backwards. This method just displays the elements in an reverse order to which the elements are stored in the array. 
	 * @param msg- msg displayed when displaying the elements.
	 * @param theArray- an array of any type of elements 
	 * @param theCount- the no. of elements in the array
	 */
	public static <E extends Comparable <E>> void displayMyIntsBackwards(String msg, E[] theArray, int theCount ) {
		System.out.println(msg);
		for( int i = theCount - 1; i >= 0; i--) {
		System.out.print(theArray[i] + "\t");
		if( i % 10 == 9) {//10 values will be displayed per line
			System.out.println();
		}//if
		}//for
	}//displayMyIntsBackwards
	
	/**
	  * Displays every other element in the array.  
	 * @param msg- msg displayed when displaying the elements.
	 * @param theArray- an array of any type of elements 
	 * @param theCount- the no. of elements in the array
	 */
	public static <E extends Comparable <E>> void displayEveryOtherInt(String msg, E[] theArray, int theCount) {
		System.out.println(msg);
		for( int i = 0; i < theCount - 1; i+=2) {
		System.out.print(theArray[i] + "\t");
		if( i % 10 == 6) {//10 values will be displayed per line
			System.out.println( );
		}//if
		}//for
	}//displayEveryOtherInt
	
	/**
	 * Determines and returns the index that is the first occurrence of the parameter in the array
	 * @param theArray- an array of any type of elements 
	 * @param a- E parameter, i.e the paramater should be of the type that the array is. 
	 * @param theCount- the no. of elements in the array
	 * @return- An int i, the index of the first occurrence . 
	 */
	public static <E extends Comparable <E>> int firstOccurence (E[] theArray, E a, int theCount) {
		int i = 0; 
		while (theArray[i] != a) {
			i++;
			if(i == theCount) {
				return -1;
			}
		}return i;
	}//firstOccurence
	
	/**
	 * Determines and returns the index	 that is the first occurrence greater than the parameter in the array 
	 * @param theArray- an array of any type of elements 
	 * @param a- E parameter, i.e the paramater should be of the type that the array is. 
	 * @param theCount- the no. of elements in the array
	 * @return- An int i, the index of the first occurrence greater than the parameter in the array. 
	 */
	public static <E extends Comparable <E>> int firstOccurencegreaterthan(E[] theArray, E a, int theCount) {
		int i = 0; 
		while (a.compareTo(theArray[i])>= 0) {
			if(i == theCount-1) {
				return -1;
			}
			i++;
		}return i;
	}//firstOccurencegreaterthan
	
	
	/**
	 * Determines and returns the index	that is the last occurrence of the parameter in the array 
	 * @param theArray- an array of any type of elements 
	 * @param a- E parameter, i.e the paramater should be of the type that the array is. 
	 * @param theCount- the no. of elements in the array
	 * @return- An int toReturn, the index of the last occurrence of the parameter in the array.
	 */
	public static <E extends Comparable <E>> int lastOccurence(E[] theArray, E a, int theCount) { 
		int toReturn =-1; 
		int i = 0; 
		while (i < theCount-1) {
			if (theArray[i] == a) {
				toReturn = i;  
			}
			i++;

		}
		return toReturn;	
	}//lastOccurence
	
	/**
	 * Determines and returns the index	that is the last occurrence greater than the parameter in the array 
	 * @param theArray- an array of any type of elements 
	 * @param a- E parameter, i.e the paramater should be of the type that the array is. 
	 * @param theCount- the no. of elements in the array
	 * @return- An int toReturn, the index of the last occurrence greater than the parameter in the array.
	 */
	public static <E extends Comparable <E>> int lastOccurencegreaterthan(E[] theArray, E a, int theCount) { 
		int toReturn =-1; 
		int i = 0; 
		while (i < theCount-1) {
			if (a.compareTo(theArray[i])>= 0) {
				toReturn = i;  
			}
			i++;

		}
		return toReturn;	
	}
	
	/**
	 * Replaces every value in the array that matches an E param with -1 
	 * @param theArray- an array of any type of elements 
	 * @param a- E parameter, i.e the paramater should be of the type that the array is. 
	 * @param theCount- the no. of elements in the array
	 */
	public static <E extends Comparable <E>> void matchesAnInt(E[] theArray, E a, int theCount ) {
		for (int i=0; i<  theCount; i++) {
			//random ints will be in range 0-49
			if (theArray[i] == a) {
				theArray[i] = null;
			}//if
		}//for
	}//matchesAnInt
	
	/**
	 * Reverses the order in which the elements are stored in the array. 
	 * @param theArray- an array of any type of elements 
	 * @param theCount- the no. of elements in the array
	 */
	public static <E extends Comparable <E>> void reverseMyInts(E[] theArray, int theCount) {
		for (int i = 0; i <theCount/2;  i++) {
			E hold = theArray[i];
			theArray[i] = theArray[theCount -i-1];
			theArray[theCount -i-1] = hold;
		}//for
	}//reverseMyInts
	
	/**
	 * Rotates the elements in the array by one position. 
	 * @param theArray- an array of any type of elements 
	 * @param theCount- the no. of elements in the array
	 */
	public static <E> void rotatesMyIntsBy1(E[]theArray, int theCount) {
		E[]temp =(E[]) new Object [theCount];
		for (int i= 0; i<theCount-1; i++) {
			temp[i+1] = theArray[i];
		}
		for(int i=0; i<1; i++ ) {
			temp[i]=theArray[theCount-1+i];
		}
		for(int j = 0; j < theCount ; j++) {
			theArray[j] = temp[j];
		}//for
		
	}//rotatesMyInts by one
	
	/**
	 *Rotates the elements in the array by two position. 
	 * @param theArray- an array of any type of elements 
	 * @param theCount- the no. of elements in the array
	 */
	public static <E> void rotatesMyIntsBy2(E[]theArray, int theCount) {
		E[]temp =(E[]) new Object [theCount];
		for (int i= 0; i<theCount-2; i++) {
			temp[i+2] = theArray[i];

		}for(int i=0; i<2; i++ ) {
			temp[i]=theArray[theCount-2+i];
		}
		theArray = temp;
	}//rotatesMyInts by n
	
	/**
	 * Rotates the elements in the array by n position
	 * @param n- int param , rotates the array by n positions. 
	 * @param theArray- an array of any type of elements 
	 * @param theCount- the no. of elements in the array
	 */
	public static <E> void rotatesMyInts(E[]theArray, int theCount, int n) {
		E[]temp =(E[]) new Object [theCount];
		for (int i= 0; i<theCount-n; i++) {
			temp[i+n] = theArray[i];

		}for(int i=0; i<n; i++ ) {
			temp[i]=theArray[theCount-n+i];
		}
		theArray = temp;
	}//rotatesMyInts by n 
	/**
	 * This method displays the elements in the array that are in 
	 * positions that are multiples of 5.  
	 * @param msg:The message displayed before the elements.
	 * @param theArray- an array of any type of elements 
	 * @param theCount- the no. of elements in the array
	 */
	public static <E> void displayMultiplesOf5(String msg, E[]theArray, int theCount ) {
		System.out.println(msg);
		for (int i = 0; i < theCount; i++) {
			if(i % 5 == 0 ) {
				System.out.print(theArray[i] + "\t");//tabs between values
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
	 * @param theArray- an array of any type of elements 
	 * @param theCount- the no. of elements in the array
	 */
	public static <E> void displayMultiplesOf4(String msg, E[]theArray, int theCount ) {
		System.out.println(msg);
		for (int i = 0; i < theCount; i++) {
			if(i % 4 == 0 ) {
				System.out.print(theArray[i] + "\t");//tabs between values
			}
			if( i % 10 == 4) {
				System.out.println();
			}//if
		}//for
		System.out.println();//makes a blank line at the end
	}//displayMyNumbers
	
	/**
	 * This method displays the elements in the array that are in 
	 * positions that are multiples of 4.  
	 * @param n - An int param 
	 * @param msg:The message displayed before the elements.
	 * @param theArray- an array of any type of elements 
	 * @param theCount- the no. of elements in the array
	 */
	public static <E> void displayMultiplesOfn(int n ,String msg, E[]theArray, int theCount ) {
		System.out.println(msg);
		for (int i = 0; i < theCount; i++) {
			if(i % n == 0 ) {
				System.out.print(theArray[i] + "\t");//tabs between values
			}
			if( i % 10 == n) {
				System.out.println();
			}//if
		}//for
		System.out.println();//makes a blank line at the end
	}//displayMyNumbers
	
}	
