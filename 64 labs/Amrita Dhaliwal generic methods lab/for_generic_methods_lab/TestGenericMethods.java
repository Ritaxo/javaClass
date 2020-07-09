package for_generic_methods_lab;

public class TestGenericMethods {
	public static void main(String[] args) {
		//array of Integer references
		Integer[] myIntegers = new Integer [100];
		GenericMethods.display("\nThere should be no Integers in the array: \n", myIntegers, 0);
		Integer returnedValue = GenericMethods.maximum(myIntegers, 0);
		if(returnedValue == null){
			System.out.println("Since there are no elements, there is no maximum.");
		} else {
			System.out.println("The maximum value in the array is: " + returnedValue + ".");
		}//else
		
		
		Integer returnValue = GenericMethods.minimum(myIntegers, 0);
		if(returnValue == null){
			System.out.println("\nSince there are no elements, there is no minimum.\n");
		} else {
			System.out.println("\nThe minimum value in the array is: " + returnValue + ".\n");
		}//else
		
		System.out.println("Array will contain " + myIntegers.length + 
				" random Integers in the range 0-99");
		// generate random ints
		for (int i=0; i<  myIntegers.length; i++) {
			//random ints will be in range 0-99
			//auto-boxing the int on the right to assign
			//to the Integer on the left
			myIntegers[i] = (int) (Math.random() * 100);
		}//for
		GenericMethods.display("\nThe Integers in the array are: \n", myIntegers, myIntegers.length);
		returnedValue = GenericMethods.maximum(myIntegers, myIntegers.length);
		if(returnedValue == null){
			System.out.println("Since there are no elements, there is no maximum.");
		} else {
			System.out.println("The maximum value in the array is: " + returnedValue + ".");
		}//else
		
		
		returnValue = GenericMethods.minimum(myIntegers, myIntegers.length);
		if(returnValue == null){
			System.out.println("\n Since there are no elements, there is no minimum.\n");
		} else {
			System.out.println("\nThe minimum value in the array is: " + returnValue + ".\n");
		}//else
		
		
		GenericMethods.searchindisplayMyInts("\n All of the ints larger than 98 are: \n ",myIntegers, 98,myIntegers.length);
		
		 GenericMethods.displayMyIntsBackwards("\n The ints displayed backwards: \n",myIntegers, myIntegers.length);
		
		 GenericMethods.displayEveryOtherInt("\n Every other ints displayed: \n", myIntegers, myIntegers.length);
		 
		 returnValue = GenericMethods.firstOccurence(myIntegers,98, myIntegers.length);
			if(returnValue == -1){
				System.out.println("\n 98 does not occur in the array\n");
			} else {
				System.out.println("\nThe index of the first occurence of 98 in the array  is: " + returnValue + ".\n");
			}//else
			
			 returnValue = GenericMethods.firstOccurencegreaterthan(myIntegers,95, myIntegers.length);
				if(returnValue == -1){
					System.out.println("\n 95 does not occur in the array\n");
				} else {
					System.out.println("\nThe index of the first occurence of int greater than 95 is: " + returnValue + ".\n");
				}//else
				
				returnValue = GenericMethods.lastOccurence(myIntegers,95, myIntegers.length);
				if(returnValue == -1){
					System.out.println("\n 95 does not occur in the array\n");
				} else {
					System.out.println("\nThe index of the last occurence of 95 in the array is: " + returnValue + ".\n");
				}//else
				
				returnValue = GenericMethods.lastOccurencegreaterthan(myIntegers,95, myIntegers.length);
				if(returnValue == -1){
					System.out.println("\n 95 does not occur in the array\n");
				} else {
					System.out.println("\nThe index of the last occurence of an int greater than 95 in the array is: " + returnValue + ".\n");
				}//else
				
				 GenericMethods.rotatesMyIntsBy1(myIntegers, 100);
				 GenericMethods.display("\n Elements in the array rotated by one position: \n", myIntegers, myIntegers.length);
				 
				 GenericMethods.displayMultiplesOf5("\n Elements in the array that are in positions that are multiples of 5: \n",myIntegers, 100);
				 
				 GenericMethods.displayMultiplesOf4("\n Elements in the array that are in positions that are multiples of 4: \n",myIntegers, 100); 
				 
				 GenericMethods.displayMultiplesOfn(9,"\n Elements in the array that are in positions that are multiples of 9: \n",myIntegers, 100);
		 
		GenericMethods.bubbleSort(myIntegers,100);
		GenericMethods.display("\nThe Integers in the array after sorting are: \n", myIntegers, myIntegers.length);

		//array of String references
		String[] myStrings = new String[20];
		myStrings[0] = "Hi";
		myStrings[1] = "Hello";
		myStrings[2] = "Good-bye";
		myStrings[3] = "Bye";
		myStrings[4] = "Aardvark";
		myStrings[5] = "Dog";
		myStrings[6] = "Cat";
		myStrings[7] = "Mills";
		myStrings[8] = "College";
		myStrings[9] = "February";
		GenericMethods.display("\nThe Strings in the array are: \n", myStrings,10);
		String returnedString = GenericMethods.maximum(myStrings,10);
		if(returnedString == null){
			System.out.println("Since there are no elements, there is no maximum.");
		} else {
			System.out.println("The maximum String in the array is: " + returnedString + ".");
		}//else
		
		String returnString = GenericMethods.minimum(myStrings,10);
		if(returnString == null){
			System.out.println("\nSince there are no elements, there is no minimum.\n");
		} else {
			System.out.println("\nThe minimum String in the array is: " + returnString + ".\n");
		}//else
		
		GenericMethods.searchindisplayMyInts("\n All of the Strings larger than zzz are: \n", myStrings, "zzz",10);
		
		GenericMethods.searchindisplayMyInts("\n All of the Strings larger than College are:\n",myStrings, "College",10);
		
		 GenericMethods.displayMyIntsBackwards("\n The Strings displayed backwards: \n",myStrings, 10);
		 
		 GenericMethods.displayEveryOtherInt("\n Every other ints displayed:\n", myStrings, 10);
		
		 returnValue = GenericMethods.firstOccurence(myStrings,"Mills", 10);
			if(returnValue == -1){
				System.out.println("\n Mills does not occur in the array\n");
			} else {
				System.out.println("\nThe first occurence in the array of Mills is: " + returnValue + ".\n");
			}//else
			
			returnValue = GenericMethods.firstOccurence(myStrings,"Amrita", 10);
			if(returnValue == -1){
				System.out.println("\n Amrita does not occur in the array\n");
			} else {
				System.out.println("\nThe index of the first occurence in the array of Amrita is: " + returnValue + ".\n");
			}//else
			
			returnValue = GenericMethods.firstOccurencegreaterthan(myStrings,"Mills", 10);
			if(returnValue == -1){
				System.out.println("\n There is no occurence of an element in the array greater than Mills\n");
			} else {
				System.out.println("\nThe first occurence of an element in the array greater than Mills is" + returnValue + ".\n");
			}//else
			
			returnValue = GenericMethods.firstOccurencegreaterthan(myStrings,"Amrita", 10);
			if(returnValue == -1){
				System.out.println("\n There index of the is no occurence of an element in the array greater than Amrita \n");
			} else {
				System.out.println("\nThe index of the first occurence of an element in the array greater than Amrita is: " + returnValue + ".\n");
			}//else
			
			returnValue = GenericMethods.lastOccurence(myStrings,"Amrita", 10);
			if(returnValue == -1){
				System.out.println("\n There is no occurence of an element called Amrita \n");
			} else {
				System.out.println("\nThe index of the last occurence of an element in the array named Amrita is: " + returnValue + ".\n");
			}//else
			
			returnValue = GenericMethods.lastOccurence(myStrings,"Mills", 10);
			if(returnValue == -1){
				System.out.println("\n There is no occurence of an element called Mills \n");
			} else {
				System.out.println("\nThe Last occurence of an element named Mills is" + returnValue + ".\n");
			}//else
			
			returnValue = GenericMethods.lastOccurencegreaterthan(myStrings,"Amrita", 10);
			if(returnValue == -1){
				System.out.println("\n There no occurence of an element in the array greater than Amrita \n");
			} else {
				System.out.println("\nThe index of the last occurence of an element in the array greater than Amrita is: " + returnValue + ".\n");
			}//else
			
			returnValue = GenericMethods.lastOccurencegreaterthan(myStrings,"Mills", 10);
			if(returnValue == -1){
				System.out.println("\n There no occurence of an element in the array greater than Mills \n");
			} else {
				System.out.println("\nThe index of the last occurence of an element in the array greater than Mills is" + returnValue + ".\n");
			}//else
			
			GenericMethods.rotatesMyIntsBy1(myStrings, 10);
			GenericMethods.display("\n Elements in the array rotated by one position: \n", myStrings,10);
			
			 GenericMethods.displayMultiplesOf5("\n Elements in the array that are in positions that are multiples of 5: \n",myStrings,10);
			 
			 GenericMethods.displayMultiplesOf4("\n Elements in the array that are in positions that are multiples of 4: \n",myStrings,10); 
			 
			 GenericMethods.displayMultiplesOfn(9,"\n Elements in the array that are in positions that are multiples of : \n",myStrings,10);
			 
		 
		GenericMethods.bubbleSort(myStrings,10);
		GenericMethods.display("\nThe Strings in the array after sorting are: \n", myStrings,10);
	}//main
}//TestGenericMethods
