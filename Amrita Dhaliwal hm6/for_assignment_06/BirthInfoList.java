package for_assignment_06;

public class BirthInfoList {
	/**
	 * array of BirthInfo Objects
	 */
	private BirthInfo myArray[];
	
	/**
	 * current count of BirthInfo Objects in List
	 */
	private int myCount;
	
	/**
	 * default capacity of the birthinfoList
	 */
	public static final int MAX=3; 
	
	/**
	 * 0 parameter constructor 
	 * COnstructs an array of references to BirthInfo of default length
	 */
	public BirthInfoList () {
		myArray = new BirthInfo[MAX];
		myCount = 0;
	}
	
	/**
	 * Checks to see if the array is full.
	 * @return true if the list is full and cannot hold another 
	 * record.  
	 */
	public boolean isFull(){
		return myCount == myArray.length;
	}//isFull
	
	/**
	 * A BirthInfo valued method named search that has a BirthInfo parameter
	 * @param findMe - BirthInfo parameter. searching in the array for the 
	 * associated Name instance variable of the parameter 
	 * @return- reference to the object in the array the associated the Name instance variable 
	 * of the parameter or returns null if there is 
	 * no record with matching Name in the list
	 */
	public BirthInfo search (BirthInfo findMe){
		for(int i = 0; i < myCount; i++) {
			if(myArray[i].equals(findMe)){
				return myArray[i];
			}//if
		}//for
		return null;
	}//search for loop version

	//	public BirthInfo search (BirthInfo findMe){
	//		int i = 0;
	//		while (i < myCount && !(myArray[i].equals(findMe))){
	//			i++;
	//		}//while
	//		return (i < myCount ? myArray[i] : null);
	//	}//search while loop version
/**
 * A boolean valued method named add that takes 
 * a BirthInfo parameter representing a person to insert into the database.
 * @param addMe
 * @return
 */
	public boolean add(BirthInfo addMe) {
		if (search(addMe) != null){
			return false;			
		}//if array was full
		if(isFull()) {
			BirthInfo[] newArray = new BirthInfo[2* myArray.length];
			for(int i = 0; i<myCount; i++) {
				newArray[i]= myArray[i];
			}//for
			myArray = newArray;
		}//if myArray was full
		myArray[myCount++] = addMe;
		return true;
	}//add
/**
 * Sorts the Array into Alphabetical order
 */
	public void alphaSort(){
		for (int passNum = 1; passNum < myCount; passNum++) {
			for(int j = 0; j < myCount - passNum; j++) {
				if(myArray[j + 1].compareTo(myArray[j]) < 0 ){//could use beforeAlpha
					swap(j, j + 1);
				}//if
			}//inner for
		}//outer for
	}//bubbleSort alphabetical

	/**
	 * Sorts the Array into Chronological order 
	 */
	public void dateSort(){
		for (int passNum = 1; passNum < myCount; passNum++) {
			for(int j = 0; j < myCount - passNum; j++) {
				if(myArray[j + 1].beforeChron(myArray[j]) ){
					swap(j, j + 1);
				}//if
			}//inner for
		}//outer for
	}//bubbleSort by birth date

	private void swap (int firstPos, int otherPos){
		BirthInfo temp = myArray[firstPos];
		myArray[firstPos] = myArray[otherPos];
		myArray[otherPos] = temp;
	}//swap

/**
 * a toString method that returns 
 * string representation of the entire array of BirthInfo objects.
 */
	public String toString(){
		if(myCount == 0){
			return "no data";
		}//if list is empty
		String toReturn = "";
		for (int i = 0; i < myCount; i++){
			toReturn += myArray[i].toString() + "\n";
		}//for
		return toReturn;
	}//toString

	private void moveToSmallerIndex(int fronthere) {
		for (int j =  fronthere +1; j< myCount; j++ ) {
			myArray[j-1] = myArray[j];
		}
	}
	/**
	 * The method has a BirthInfo parameter and attempts to delete a record from 
	 * the list that matches the Name instance variable of the parameter.
	 * @param deleteMe - the BirthInfo object whose associated name we want to delete. 
	 * @return - true if a record is deleted or returns false 
	 * if no matching record is found to delete 
	 */
	public boolean delete(BirthInfo deleteMe) {
		int i=0;
		while (i<myCount && !myArray[i].equals(deleteMe)) {
			i++;
		}//while
		if(i < myCount) {
			moveToSmallerIndex(i);
			myCount --;
			return true;
		}//if we fount it
		return false;
	}//deleteMe
	
}//BirthInfoList


