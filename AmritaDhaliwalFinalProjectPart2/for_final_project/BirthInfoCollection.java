package for_final_project;
import java.util.*;
import java.io.*;

public class BirthInfoCollection {
	private HashSet <BirthInfo> myHashTable;
	
	/**
	 * Constructor of one HashSet
	 */
	public BirthInfoCollection () {
		myHashTable = new HashSet <BirthInfo>();
	}//zero parameter constructor 
	
	public BirthInfo search (BirthInfo findme) {
		if(myHashTable.contains(findme)) {
			for (BirthInfo current : myHashTable) {
				if(current.equals(findme)) {
					return current;
				}//if
			}//for
		}//if
		return null;
	}//search
	
	/**
	 * Adds the BirthInfo item to the myHashTable
	 * @param addme - BirthInfo item to be added
	 * @return true if the item has been added
	 */
	public boolean add (BirthInfo addme) {
//		if (!myHashTable.contains(addme)) {//search(addme) != null
//			return false;
//		}//Duplicate
		return (myHashTable.add(addme));
	}//add
	
	/**
	 * Delete should return true only if the atttempt
	 * to remove the found reference from both the HashSet's are successful. 
	 * @param deleteMe - the BirthInfo object to be removed.
	 * @return true if successful 
	 */
	public boolean delete(BirthInfo deleteMe) {
		BirthInfo found = search(deleteMe); 
		if (found != null) {
			return (myHashTable.remove(found) ); 
		}//If we found it 
		return false;
	}//
	
	/**
	 * toString returns a string representation of the BirthInfo  
	 * objects in alphabetical order. 
	 * @return String representation of the items in the table in alphabetical order
	 */
	public String toStringAlphabetical() {
		TreeSet <BirthInfo> alpha = new TreeSet <>(myHashTable);
		String toReturn = "";
		Iterator <BirthInfo> alphaIt = alpha.iterator();
		while (alphaIt.hasNext()) {
			toReturn += alphaIt.next() + "\n";
		}
		return toReturn; 
	}//toStringAlphabetical
	/**
	 * toString returns a string representation of the BirthInfo
	 * objects in chronological order
	 * @return String representation of the items in the table in chronological order
	 */
	public String toStringChronological() {
		TreeSet <BirthInfo> date = new TreeSet<>(BirthInfo.CHRON_COMP);
		Iterator <BirthInfo> hashIt = myHashTable.iterator();
		while (hashIt.hasNext()) {
			BirthInfo current = hashIt.next();
			if(!date.add(current)) {
				System.out.println("Error in adding" + current );
			}//if trouble in data structure
		}
		String toReturn = "";
		Iterator <BirthInfo> dateIt = date.iterator();
		while (dateIt.hasNext()) {
			toReturn += dateIt.next() + "\n";
		}
		return toReturn; 
	}//toStringAlphabetical
	
	public String saveToFile(String fileName) {
		String toReturn ="";
	try {
		ObjectOutputStream oOS = new ObjectOutputStream(new FileOutputStream (fileName));
		for(BirthInfo current: myHashTable) {
			oOS.writeObject(current);
		}//for
		oOS.flush();
		oOS.close();
	}//try
	catch(Exception e) {
		toReturn += e.toString();
	}
	return toReturn;
	}//saveToFile
	
	public String loadFromFile(String theFileName) {
		String toReturn ="";
		try {
			ObjectInputStream oIS = new ObjectInputStream(new FileInputStream (theFileName));
			while(true) {
				BirthInfo fromFile =(BirthInfo)(oIS.readObject());
				BirthInfo found = search(fromFile);
				if (found == null) {
					if(add(fromFile)) {
						toReturn += fromFile + " sucessfully added.\n";}
					else {
						toReturn += fromFile + " not sucessfully added.\n";}
				}else {
					toReturn += found + " already in database.\n" + "record not added from file!\n";
				}//else
			}//while
		}//try
		catch (EOFException eOF) {
			toReturn +="load from file" + theFileName + "complete.\n";
		} catch(Exception e) {
			toReturn += "Error in reading from file" + theFileName + "\n" +e;
		}
		return toReturn;
	}//
}
