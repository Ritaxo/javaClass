package for_final_project;
import java.util.*;
import java.io.*;

public class BirthInfoCollection {
	private TreeSet <BirthInfo> myAlphaTree;
	private TreeSet <BirthInfo> myDateTree;
	
	public BirthInfoCollection () {
		myAlphaTree = new TreeSet <>();
		myDateTree = new TreeSet <>(BirthInfo.CHRON_COMP);
	}//zero parameter constructor 
	
	public BirthInfo search (BirthInfo findme) {
		if(myAlphaTree.contains(findme)) {
			for (BirthInfo current : myAlphaTree) {
				if(current.equals(findme)) {
					return current;
				}//if
			}//for
		}//if
		return null;
	}//search
	
	public boolean add (BirthInfo addme) {
//		if (!myAlphaTree.contains(addme)) {//search(addme) != null
//			return false;
//		}//Duplicate
		return (myAlphaTree.add(addme) && myDateTree.add(addme));
	}//add
	
	public boolean delete(BirthInfo deleteMe) {
		BirthInfo found = search(deleteMe); 
		if (found != null) {
			return (myAlphaTree.remove(found) && myDateTree.remove(found)); 
		}//If we found it 
		return false;
	}//

	public String toStringAlphabetical() {
		return myDateTree.toString(); 
	}//toStringAlphabetical
	
	public String toStringChronological() {
		return myDateTree.toString(); 
	}//toStringAlphabetical
	
	public String saveToFile(String fileName) {
		String toReturn ="";
	try {
		ObjectOutputStream oOS = new ObjectOutputStream(new FileOutputStream (fileName));
		for(BirthInfo current: myAlphaTree) {
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
