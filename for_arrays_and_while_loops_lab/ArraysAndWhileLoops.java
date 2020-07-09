package for_arrays_and_while_loops_lab;

public class ArraysAndWhileLoops {
	// reference to an array to hold some random ints
	private static int myInts[];
	//constant maximum number of elements in the array
	private static final int MAXNUMS = 100;

	private static void displayMyInts(String msg) {
		System.out.println(msg);
		System.out.println("Amrita Dhaliwal");
		for (int i = 0; i < myInts.length; i++) {
			System.out.print(myInts[i] + "\t");//tabs between values
			if( i % 10 == 9) {//10 values will be displayed per line
				System.out.println();
			}//if
		}//for
		System.out.println();//makes a blank line at the end
	}//displayMyNumbers

	public static void displayElements(int exceedme) {
		int i = 0;
		int sum = 0;
		System.out.println("These are the ints greater then 100\n");
		while(sum <= exceedme) {
			sum = myInts[i] + sum; 
			System.out.println(myInts[i]);
			i++;
		}
	}



	public static int firstOccurence(int findme) {
		int i = 0; 
		while (myInts[i] != findme) {
			i++;
			if(i == MAXNUMS) {
				return -1;
			}
		}return i+1;
	}

	public static int firstOccurencegreaterthan(int findme) {
		int i = 0; 
		while (myInts[i] <= findme) {
			if(i == MAXNUMS) {
				return -1;
			}
			i++;
		}return i+ 1;
	}

	**public static int lastOccurence(int findme) { 
		int toReturn =-1; 
		int i = 0; 
		while (i < MAXNUMS) {
			if (myInts[i] == findme) {
				toReturn = i;  
			}
			if(i == MAXNUMS) {
				toReturn = -1;
			}
			i++;

		}
		return toReturn;	
	}


	public static int lastOccurencegreaterthan(int findme) { 
		int toReturn =0; 
		int i = 0; 
		while (i < MAXNUMS) {
			if (myInts[i] > findme) {
				toReturn = i;  
			}
			if(i == MAXNUMS) {
				toReturn = -1;
			}
			i++;

		}
		return toReturn;	
	}

	public static int ascendOrder() {  
		int i = 0; 
		while (myInts[i] < myInts[i + 1]) {
			if(i == MAXNUMS) {
				return  -1;
				}
			i++;
		}
		return i;	
	}

	

	public static void main(String[] args) {
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
		displayElements(100);
		System.out.println("\n The last Occurence of 0 in the array \n " + lastOccurence(0));
		System.out.println("\n The last Occurence of 90 in the array \n " + lastOccurence(90));
		System.out.println("\n The first Occurence of 20 in the array \n " + firstOccurence(20));
		System.out.println("\n The first Occurence of an int greater than 40 in the array \n " + firstOccurencegreaterthan(40));
		System.out.println("\n The last Occurence of an int greater than 40 in the array \n" + lastOccurencegreaterthan(40));
		System.out.println("\n The first Occurence of an int not in ascending order in the array \n" + ascendOrder());
		
		

	}//main

}//ArraysAndWhileLoops

