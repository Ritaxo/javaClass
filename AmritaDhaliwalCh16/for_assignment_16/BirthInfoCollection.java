package for_assignment_16;
import java.io.*;
public class BirthInfoCollection {
	private WCSOrderedLinkedList<BirthInfo> myAlphaList;
	private WCSOrderedLinkedList<BirthInfo> myDateList;
	
	public BirthInfoCollection () {
		myAlphaList = new WCSOrderedLinkedList <BirthInfo>();
		myDateList = new WCSOrderedLinkedList <BirthInfo>(BirthInfo.CHRON_COMP);
	}//zero parameter constructor 
	
	public BirthInfo search (BirthInfo findme) {
		return myAlphaList.search(findme);
	}//search
	
	public boolean add (BirthInfo addme) {
		if (search(addme) != null) {
			return false;
		}//Duplicate
		return (myAlphaList.add(addme) && myDateList.add(addme));
	}//add
	
	public boolean delete(BirthInfo deleteme) {
		BirthInfo found = search(deleteme); 
		if (found != null) {
			return (myAlphaList.delete(found) && myDateList.delete(found)); 
		}//If we found it 
		return false;
	}//

	public String toStringAlphabetical() {
		return myAlphaList.toString(); 
	}//toStringAlphabetical
	
	public String toStringChronological() {
		return myDateList.toString(); 
	}//toStringAlphabetical
	
	public String saveToFile(String fileName) {
		return myAlphaList.saveToFile(fileName); 
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
