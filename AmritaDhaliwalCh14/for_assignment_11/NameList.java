package for_assignment_11;
public class NameList {

	private Name myArray[]; //refers to the array of Name objects
	private int myCount; // holds the current count of Name objects in the list

	public NameList () {
		myArray = new Name[100];
		myCount = 0;
	}// 0 parameter constructor

	public NameList (int theMax) {
		myArray = new Name[theMax];
		myCount = 0;
	}// 1 parameter constructor

	public boolean isFull() {
		return myCount == myArray.length;
	}//isFull

	public boolean add(Name theName) {
		if (!isFull()) {
			myArray [myCount++] = theName;
			return true;
		} // add was successful
		System.out.println("Attempting to add to full array");
		return false;
	}//add
	
	public String toString() {
		String stringToReturn = "";
		for (int i = 0; i < myCount; i++) {
			stringToReturn += myArray [i] + "\n"; //"\n" for the new line character
		}//for
		return stringToReturn;
	}//toString

	public Name searchSorted(Name theName) {
		int i = 0;
		while ( i < myCount && (myArray[i]).before(theName)){
			i++;
		}//while
		return (i < myCount && (myArray[i].equals(theName)) ? myArray[i] : null); 
	}//search
	
	
	
	public Name search(Name theName) {
		int i = 0;
		while ( i < myCount && !(myArray[i].equals(theName))){
			i++;
		}//while
		return (i < myCount ? myArray[i] : null); 
		
	}//search Sorted 

	private void swap (int firstPos, int otherPos) {
		Name temp = myArray[firstPos];
		myArray[firstPos] = myArray[otherPos];
		myArray[otherPos] = temp;
	}//swap
	
	public void bubbleSort() {
		for(int passNum = 1; passNum < myCount; passNum++) {
			for (int j = 0; j < myCount - passNum; j++) {
				if(myArray[j+1].before(myArray[j])) {
					swap(j, j+1);
				}//if
			}//inner for loop for one pass
		}//for loop that controls passes over the data
	}//bubbleSort
	
	
	public void selectionSort() {
		for (int passNum = 0; passNum < myCount - 1; passNum++) {
			int posOfSmallest = passNum;
			for (int compareIndex = passNum + 1; compareIndex < myCount; compareIndex++) {	
				if( (myArray[compareIndex]).before(myArray[posOfSmallest])){
					posOfSmallest = compareIndex;	
				}//if better candidate for smallest found
			}//for compareIndex
			if(posOfSmallest != passNum) {
				swap(posOfSmallest, passNum);
			}//if we need to swap
		}//for passNum
	}//selectionSort
	
	public void insertionSort() {
		for(int passNum = 0; passNum < myCount; passNum++) {
			Name toBeInserted = myArray[passNum];
			int compareIndex = passNum -1;
			while ((compareIndex >=1) && toBeInserted.compareTo(myArray[compareIndex]) < 0){
				myArray[compareIndex +1] = myArray[compareIndex];
				compareIndex --;
			}//allWhile
			myArray[compareIndex + 1] = toBeInserted;
		}//for
	}//InsertionSort
	

	


	public Name binarySearch(Name nameToFind) {
		int low = 0;
		int high = myCount - 1;
		int middle = (low + high)/2;
		while (low <= high && ! (myArray[middle].equals(nameToFind)) ) {
			if ( nameToFind.before (myArray[middle])) {
				high = middle - 1;
			} else {
				low = middle + 1;
			}//else
			middle = (low + high)/2;
		}//while
		return (myArray[middle].equals(nameToFind) ? myArray[middle] : null);
	}//binarySearch

}//NameList
