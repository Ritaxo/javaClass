package for_assignment_16;/*** A class for maintaining an ordered linked list. It currently contains a constructor for* creating the list and recursive methods for adding in order, searching, deleting, and toString.* It also contains non-recursive methods for saving to a file and loading from a file.* @author Barbara Li Santi* @version 1.3*/import java.util.*;import java.io.*;public class WCSOrderedLinkedList<E extends Comparable<E>> {	private Node<E> myHead; //refers to the Node at the head of the list	private boolean addSuccessful;// used to indicate that the add methods						// changed the composition of the list or not	private E objectBeingAdded; // holds a reference to object					   // being added for the recursion	private boolean deleteSuccessful; // used to indicate that the delete methods						// changed the composition of the list or not	private E objectToDelete; // holds a reference to object					   // being deleted for the recursion		private E objectSearchingFor; // holds a reference to object for which we					   //  search for the recursion		private Comparator<E> myComparator; // in charge of comparing objects in the						//list to keep the list in order		public WCSOrderedLinkedList () {		myHead = null;		myComparator = null;	}  //1 argument constructor		public WCSOrderedLinkedList (Comparator<E> theComparator) {		myHead = null;		myComparator = theComparator;	}  //1 argument constructor	private int myCompare (E firstE, E secondE){		if(myComparator == null) {			return firstE.compareTo(secondE);		}//no comparator		return myComparator.compare(firstE, secondE);	}//myCompare	public boolean add (E toInsert) {		addSuccessful = false;		objectBeingAdded = toInsert;		myHead = add (myHead);		return addSuccessful;	}//public addInOrderR method	private Node<E> add (Node<E> currentHead) {		if (currentHead == null) { 			addSuccessful = true;			return new Node<E> (objectBeingAdded);		} // We got to the end of the list.		if (objectBeingAdded.equals(currentHead.getData())){			return currentHead;		}//duplicate found		if (myCompare(objectBeingAdded,				currentHead.getData()) < 0) {			addSuccessful = true;			return new Node<E> (objectBeingAdded, currentHead);		} // We found the correct position, adding at the head of a sublist		//we need to continue looking for the correct position		//currentHead's link field may be the pointer that needs		//to be reassigned to point to the new Node 		currentHead.setLink(add (currentHead.getLink()));		return currentHead;	}// private addInOrderR method		public E search(E findMe) {		objectSearchingFor = findMe;		return search(myHead);	}//public search		private E search (Node<E> currentHead) {//not smart searches all 									// the way to the end of the list		if (currentHead == null) {			return null;		}//item is not in list		if (objectSearchingFor.equals(currentHead.getData())){			System.out.println("we have equal records in search");			return currentHead.getData();		}//found item in list		if (myCompare(objectSearchingFor,				currentHead.getData()) < 0){			return null;		}//item in list is after item we are looking for, so it's not there		return search(currentHead.getLink());	}//private search	public boolean delete(E toDelete) {		deleteSuccessful = false;		objectToDelete = toDelete;		myHead = delete(myHead);		return deleteSuccessful;	}//public delete	private Node<E> delete(Node<E> currentHead) {		if (currentHead == null) {			return currentHead;		}//item to delete is not in list		if (objectToDelete.equals(currentHead.getData())){			deleteSuccessful = true;			return currentHead.getLink();		}//found item to delete		if (myCompare(objectToDelete,				currentHead.getData()) < 0){			return currentHead;		}//item in list is after item we are looking for, so it's not there		currentHead.setLink(delete(currentHead.getLink()));		return currentHead;	}//private delete	public boolean isEmpty() {		return myHead == null;	}//isEmpty		public String saveToFile(String fileName) {		String messageFromSave = "";		try {			ObjectOutputStream oOS = new ObjectOutputStream(							new FileOutputStream(fileName));			Node<E> mover = myHead;			while(mover != null) {				oOS.writeObject(mover.getData());				mover = mover.getLink();			}//while			oOS.flush();			oOS.close();		}//try		catch(Exception e) {			messageFromSave = e.toString();		}//catch				return messageFromSave;	}//saveToFile		public String toString() {		return toString(myHead);	}//public toString		private String toString(Node<E> currentHead){		if(currentHead == null) {			return "";		}//end of list		return currentHead.getData() + "\n" + toString(currentHead.getLink());	}  //private toString}//WCSLinkedList