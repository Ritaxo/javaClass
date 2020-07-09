package for_cs64_exam_1;

import java.util.Comparator;

public class ExamCollection {
	/**
	 * A string instance variable to represent the name of the ExamCollection.
	 */
	private String myNameOfCollection;

	/**
	 * An instance variable that is a reference to an array of BirthInfo objects.
	 *  It hold the reference to BirthInfos in ExamCollection. 
	 */
	private BirthInfo myArray[];

	/**
	 * An instance variable that represents the count of the BirthInfos in the ExamCollection.
	 */
	private int myCount;

	/**
	 * An instance variable that represents an object that can implement a 
	 * secondary ordering scheme for the ExamCollection 
	 */
	private Comparator<BirthInfo> myComparator;

	/**
	 * A static final variable that represents the maximum size of the exam Collection 
	 * when none is provided
	 */
	public final static int DEFAULT_SIZE = 5; 

	/**
	 * A 3 parameter constructor with a string represents the name for the ExamCollection,
	 * int that represents the Maximum size  of the ExamCollection and Comparator<BirthInfo> parameters. 
	 * @param theName -  Assigns this parameter to myNameOfCollection
	 * @param maxSize - Uses this parameter to construct an array of BirthInfo object references 
	 * that is then assigned to myArray. 
	 * @param theComparator - Assigns this to myComparator 
	 * assigns myCOunt to 0
	 */
	public ExamCollection(String theName, int maxSize, Comparator<BirthInfo> theComparator){
		myNameOfCollection = theName;
		myArray = new BirthInfo[maxSize];
	    myComparator = theComparator;
		myCount = 0;
	}//3-parameter constructor
	/**
	 * A 2 parameter constructor with a string that represents the name for the ExamCollection,
	 * int that represents the Maximum size  of the ExamCollection. 
	 * @param theName -  Assigns this parameter to myNameOfCollection
	 * @param maxSize - Uses this parameter to construct an array of BirthInfo object references 
	 * that is then assigned to myArray.
	 * assigns myCount to 0 
	 * Assigns myComparator to null. 
	 */
	public ExamCollection(String theName, int maxSize){
		myNameOfCollection = theName;
		myArray = new BirthInfo[maxSize];
		myCount = 0;
		myComparator = null;
	}//2-parameter constructor

	/**
	 * A 2 parameter constructor with a string that represents the name for the ExamCollection,
	 * and a Comparator<BirthInfo> parameter. 
	 * @param theName - Assigns this parameter to myNameOfCollection
	 * @param theComparator - Assigns this to myComparator 
	 *  assigns myCount to 0
	 *  Uses the Static int called DEFAULT_SIZE to construct an array of BirthInfo references 
	 *  that is then assigned to to myArray.   
	 **/
	public ExamCollection(String theName, Comparator<BirthInfo> theComparator){
		myNameOfCollection = theName;
		myArray = new BirthInfo[DEFAULT_SIZE];
		myCount = 0;
	    myComparator = theComparator;
	}//2-parameter constructor
	/**
	 *  A parameter constructor with a string that represents the name for the ExamCollection. 
	 * @param theName - Assigns this parameter to myNameOfCollection
	 * assigns myCount to 0
	 * Uses the Static int called DEFAULT_SIZE to construct an array of BirthInfo references 
	 * that is then assigned to to myArray.
	 * Assigns myComparator to null.  
	 */
	public ExamCollection(String theName){
		myNameOfCollection = theName;
		myArray = new BirthInfo[DEFAULT_SIZE];
		myCount = 0;
		myComparator = null;
	}//2-parameter constructor

	/**
	 * toReturn is an object that is a string representation of  of the information. 
	 * and a for loop is used to add spaces between each birthInfo object in its string representation.   
	 * @return toReturn 
	 */
	public String toString() {
		String toReturn =  myNameOfCollection + " " + myCount + ":";
		for (int i = 0; i < myCount; i++) {
			toReturn = toReturn + myArray[i] + "\n" ;
		}
		return toReturn;
	}

	/**
	 * Checks to see if the BirthInfo item can be added. 
	 * If myCount is less than default size then theBirthInfo parameter should be assigned to the next available 
	 * empty spot. 
	 * @param theBirthInfo - a birthInfor object 
	 * @return
	 */
	public boolean addItem (BirthInfo theBirthInfo) {
		if (myCount <  myArray.length) {
			myArray [myCount++] = theBirthInfo;
			return true;	
		} //if
		return false;
	}
	/**
	 * An access method for the string instance variable  
	 * @return myNameOfCollection - 
	 */
	public String getNameOfCollection() {
		return myNameOfCollection;
	}//access method

	/**
	 * A modifier method that modifies the myNameOfCollection to the parameter theNameOfCollection 
	 * only if the theNameOfCollection is not an empty string.    
	 * @param theNameOfCollection
	 */
	public void setNameOfCollection(String theNameOfCollection) {
		if (theNameOfCollection == "") {
			System.out.println("Wrong assignment, Empty string cannot be assigned to myNameOfCollection.");
		} else {
			myNameOfCollection = theNameOfCollection;  
		}
	}
	/**
	 * An Access method for myArray
	 * @return myArray. 
	 */
	public BirthInfo[] getArray() {
		return myArray;
	}
	
	/**
	 * A modifier method for myCount and myArray. 
	 * It only modifies if the new Count is less than the size of the new Array.   
	 * @param theArray - the new Array of BirthInfo object references.  
	 * @param theCount - the new Count of the BirthInfos in the ExamCollection
	 */
	public void setArrayAndCount( BirthInfo theArray[], int theCount) {
		if(theCount > theArray.length) {
			System.out.println("The count entered is greater then the lenth of the array given."); 
		} else {
			myArray = theArray;
			myCount = theCount;	 
		}
	}
	/**
	 * An Access method for myCount.
	 * @return myCount
	 */
	public int getCount() {
		return myCount;
	}

	/**
	 * The getElementAtIndex method has a return type BirthInfo and a parameter rtheIndexInArray, 
	 * this methods checks to see if the parameter is valid and then returns the BirthInfo
	 * reference stored at that parameter index.     
	 * @param theIndexInArray - represents an Index in the array. 
	 * @return The BirthInfo reference in the myArray at the parameter theIndexInArray. 
	 */
	public BirthInfo getElementAtIndex (int theIndexInArray) {
		if( theIndexInArray < 0 || theIndexInArray >= myArray.length) {
			System.out.println("Invalid size of array. ");
			return null;
		}else if ( theIndexInArray > myCount -1){
			System.out.println("Index out of bound. Invalid for count."); 
			return new BirthInfo("","","");
		} 
		return myArray[theIndexInArray];
	}

	/**
	 * The changeElementAtIndex method has a return type boolean.This method Assigns theBirthInfo parameter
	 * to the myArray at theIndexInArray parameter.     
	 * @param theIndexInArray- is an index in the Array.  
	 * @param theBirthInfo - is a reference to a BirthInfo object to be 
	 * stored at that index of the array. 
	 * @return true  
	 */
	public boolean changeElementAtIndex(int theIndexInArray, BirthInfo theBirthInfo) {
		if( theIndexInArray < 0 || theIndexInArray >= myArray.length){
			System.out.println("Invalid size of array. ");
			return false;
		}else if ( theIndexInArray > myCount -1){
			System.out.println("Index out of bound. Invalid for count."); 
			return false;
		}  
		myArray[theIndexInArray] = theBirthInfo; 
		return true;

	}
	/**
	 * Checks to see whether two ExamCollections are the same.
	 */
	public boolean equals(Object theOther){
		ExamCollection  theExamCollection  = (ExamCollection)theOther;
		return myNameOfCollection.equals(theExamCollection.myNameOfCollection)
				&& myCount == theExamCollection.myCount
				&& myArray.equals(theExamCollection.myArray);
	}//equals

	/**
	 * to checks to see if the Exam Collection is full.   
	 * @return true if the count of BirthInfos is equal to the myArray length  
	 */
	public boolean isFull() {
		return myCount == myArray.length;
	}

	/**
	 * to checks to see if the Exam Collection is empty.   
	 * @return true if the count of BirthInfos is equal to zero.  
	 */
	public boolean isEmpty() {
		return myCount == 0;
	}

	public void alphaSort() {
		

	}
	/**
	 * The method indexFirstOccurence takes in an BirthInfo parameter and
	 * checks if the parameter is in myArray and if its present it  
	 * returns the index in myArray of the BirthInfo parameter.  
	 * @param theBirthInfo - abirthInfo parameter 
	 * @return either the index of the first occurrence of the parameter or -1.   
	 */
	public int indexFirstOccurence(BirthInfo theBirthInfo) {
		int toReturn = 0;
		int i = 0;
		for (i= 0; i < myCount; i++) {
			if(myArray[i].equals(theBirthInfo)) {
			return i;
			}
			return -1; 
		}
		return toReturn;
	}

	/**
	 * This method will delete the first occurrence of the BirthInfo
	 * parameter in the collection.  
	 * @param theBirthInfo
	 * @return true if the parameter is found and is deleted. 
	 */
	public boolean deleteFirstOccurence(BirthInfo theBirthInfo) {
		int i = 0;
		while( i< myCount && !myArray[i].equals(theBirthInfo)) {
			i++;
		}//while
		if(i == myCount) {
			return false;
		}//not there to delete
		for (int j = i ; j < myCount -1; j++) {
			myArray[j] = myArray[j+1];
		}//for
		myCount--;
		return true;
	}
	
/**
 * A method that takes in a BirthInfo parameter and 
 * attempts to delete every occurrence of a BirthInfo in the collection that equals the parameter.    
 * @param deleteMe - The item to be delete 
 * @return true - If the parameter is found and deleted.    
 */
	public boolean deleteAllOccurences(BirthInfo deleteMe) {
		boolean toReturn = false;
		while (deleteFirstOccurence(deleteMe)) {
			toReturn = true; 
		}//while
		return toReturn;
	}//deleteAllOccureneces
	
	

}
