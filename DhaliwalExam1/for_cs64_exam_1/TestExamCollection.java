package for_cs64_exam_1;


public class TestExamCollection {
	
	public static void main (String args[]) {
		
		String n1, n2, n3, n4;
		BirthInfo b1, b2, b3, b4;
		n1 = "Amrita";
		n2 = "Akash";
		n3 = "Rita";
		n4 = "Loney";
		 b1= new BirthInfo("Akash", "Raja", "Shekhara",5, 19, 1997);
		 b2 = new BirthInfo("Amrita","Raja","Dhaliwal",15, 3);
		 b3 = new BirthInfo("Amrita", "Dhaliwal",15, 3, 2014);
		 b4 = new BirthInfo("","Raja", "Dhaliwal");
		ExamCollection EC1, EC2,EC3, EC4, EC5;
		
		EC1 = new ExamCollection ("Amrita", 1,  BirthInfo.CHRON_COMP ); 	
		System.out.println(EC1.toString() + " is the info for EC1.\n");
		
		EC2 = new ExamCollection (n2, 5); 
		System.out.println(EC2.toString() + " is the info for EC2.\n");
		
		EC5 = new ExamCollection(n3, 0);
		
		EC3 = new ExamCollection (n3, BirthInfo.CHRON_COMP );
		System.out.println(EC3.toString() + " is the info for EC3.\n");
		
		EC4 = new ExamCollection (n4);
		System.out.println(EC4.toString() + " is the info for EC4.\n");
		
		if(EC1.addItem(b1)) {
			System.out.println(b1 + " was successfully added to EC1:\n" + EC1.toString() );
		}else {
			System.out.println(b1 + " was not successfully added to EC1:\n" + EC1.toString() );
		}
		
		if(EC1.addItem(b1)) {
			System.out.println(b1 + " successfully added to EC1:\n" + EC1.toString() );
		}else {
			System.out.println(b1 + " not successfully added to EC1:\n" + EC1.toString() );
		}
		
		
        System.out.println(EC2.getNameOfCollection() + " is the name of the EC2 collection.\n ");
        
       
        EC2.setNameOfCollection("");
        System.out.println("The name change of EC2 was unsuccessful:\n" + EC2.toString() + "\n" );
        
        EC2.setNameOfCollection("Raja");
        System.out.println("The name of EC2 has been changed to:\n"+ EC2.toString() + "\n");
		
      //  System.out.println("The elements in the EC1 array are:\n" + EC2.getArray() + "\n" ); 
		
        //EC2.setArrayAndCount(, 6);
        //System.out.println("The name of EC2 has been changed to:\n"+ EC2.toString() + "\n");
        
        System.out.println("The count of elements in of EC1 is/are:\n"+ EC1.getCount() + "\n"); 
        
        
        System.out.println("The elements in EC2 at 3 is:"+ EC2.getElementAtIndex(3)+ "\n" );
        System.out.println("The elements in EC2 at -3 is:"+ EC1.getElementAtIndex(-3) + "\n" );
        System.out.println("The elements in EC1 at 0 is:\n"+EC1.getElementAtIndex(0) + "\n");
		
        System.out.println("Can the new element b1, be added to EC2 at 2:"+ EC2.changeElementAtIndex(2,b1)+ "\n" );
        System.out.println("Can the new element b2  be added to EC2 at -3:"+ EC1.changeElementAtIndex(-3, b2) + "\n" );
        System.out.println("Can the new element b3 be added to EC2 at 0:"+EC1.changeElementAtIndex(0, b3) + "\n"); 
        
        System.out.println ("" + EC1.equals(EC1));
        System.out.println ("" +EC1.equals(EC2));
        
        System.out.println ("Is EC5 full:" + EC5.isFull() + "is full \n");
        System.out.println ("Is EC2 full:" + EC2.isFull() + "is not full \n");
        
        System.out.println ("Where is b1 present in EC1:" + EC1.indexFirstOccurence(b1)+ "\n");
        System.out.println ("Where is b1 present in EC2:" + EC2.indexFirstOccurence(b1)+ "\n");
    	 
        System.out.println ("Can first occurence of b1 be deleted from EC1:" + EC1.deleteFirstOccurence(b1)+ "\n");
        
        EC2.addItem(b1);
        System.out.println ("Can first occurence of b1 be deleted from EC2:" + EC2.deleteFirstOccurence(b1)+ "\n");
      
        EC1.addItem(b1);
        EC2.addItem(b1);
        System.out.println ("Can all occurences of b1 be deleted from EC2:"+ EC2.deleteAllOccurences(b1) + "\n") ;
        System.out.println ("Can all occurences of b1 be deleted from EC1:"+ EC1.deleteAllOccurences(b1) + "\n") ;
        
        
	}
	

}
