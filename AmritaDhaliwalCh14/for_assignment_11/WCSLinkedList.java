package for_assignment_11;

import java.util.Comparator;

public class WCSLinkedList <E extends Comparable<E> >  {

	private Node<E> myHead;
	private int myCount;
	private Comparator <E> myComparator;

	public WCSLinkedList (Comparator<E> theComparator) {
		myHead = null;
		myComparator = theComparator;
	}   //0 argument constructor

	public WCSLinkedList () {
		myHead = null;
		myComparator = null;
	}  //1 argument constructor


	public E search (E findMe) {
		Node <E> mover = myHead;
		while(mover != null && !mover.getData().equals(findMe)) {
			mover = mover.getLink();
		}if ( mover != null) {
			return mover.getData();
		}
		return null;
	}//search

	public E add(E addMe) {

	} //toString
	
	public E delete(E deleteMe) {

	} //toString

	private int myCompare(E firstItem, E secondItem) {
		
	}
	
	public int getCount() {
		int count =0;
		Node <E> mover = myHead;
		while(mover != null ) {
			mover = mover.getLink();
			count++;
		}
		return count;
	}

	public String toString() {
		String toReturn = "";
		Node<E> mover = myHead;
		while (mover != null) {
			toReturn += mover.getData() + "\n";
			mover = mover.getLink();
		}// while
		return toReturn;
	} //toString

	public void addAtTail2 (E theData) {
		Node<E> tempPtr = new Node< >(theData);
		if (myHead == null) { 
	        myHead = new Node(theData); 
	        return; 
	    }tempPtr.setLink(null);
	    Node last = myHead;  
	    while (last.getLink() != null) { 
	        last = last.getLink();}
	    last.getLink() = new_node;
	} // addToFront



	public static void main (String args []){
		WCSLinkedList<String> myStringLinkedList = new WCSLinkedList<>();
		myStringLinkedList.myHead = new Node< >("George");
		myStringLinkedList.myHead.setLink(new Node< >("Lydia"));
		myStringLinkedList.myHead.getLink().setLink(new Node< >("Barbara"));
		myStringLinkedList.myHead.getLink().getLink().setLink(new Node< >("Betty"));
		myStringLinkedList.myHead.getLink().getLink().getLink().setLink(new Node< >("Mikey"));
		System.out.println(myStringLinkedList.myHead.getData().toString());
		System.out.println(myStringLinkedList.myHead.getLink().getData().toString());
		System.out.println(myStringLinkedList.myHead.getLink().getLink().getData().toString());
		System.out.println(myStringLinkedList.myHead.getLink().getLink().getLink().getData().toString());
		System.out.println(myStringLinkedList.myHead.getLink().getLink().getLink().getLink().getData().toString());
	}//main Homework 14.5
}
