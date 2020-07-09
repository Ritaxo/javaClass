package for_assignment_16;

/**
* A class that defines a generic type for Nodes used within a WCSLinkedList20190409. 
* Contains basic constructors and  access and modifier methods.
* @author: Barbara Li Santi
* @version 1.4
*/

public class Node<E> {
	/**
	 * the data portion of a Node<E>
	 */
	private E myData;
	
	/**
	 * the link to the next Node<E>
	 */
	private Node<E> myLink;
	
	/**
	 * one parameter constructor that assigns the parameter to the data field
	 * and defaults the link field to null
	 * @param theData to be assigned to the data field
	 */
	public Node (E theData) {
		myData = theData;
		myLink = null;
	} //one argument constructor
	
	/**
	 * two parameter constructor that assigns its parameters to the two 
	 * instance variable fields
	 * @param theData to be assigned to the data field
	 * @param theLink to be assigned to the link field
	 */
	public Node (E theData, Node<E> theLink) {
		myData = theData;
		myLink = theLink;
	} //two argument constructor
	
	/**
	 * modifier method for the link field
	 * @param theLink to be assigned to the link field
	 */
	public void setLink(Node<E> theLink) {
		myLink = theLink;
	}  //setLink
	
	/**
	 * modifier method for the data field
	 * @param theData to be assigned to the data field
	 */
	public void setData(E theData) {
		myData = theData;
	}  //getData

	/**
	 * access method for the link field
	 * @return the link field of this Node<E>
	 */
	public Node<E> getLink(){
		return myLink;
	}  //getLink
	
	/**
	 * access method for the data field
	 * @return the data portion of this Node<E>
	 */
	public E getData() {
		return myData;
	}  //getData
		
}//Node<E> class