package for_assignment_04;

public class TestBirthInfo {
	public static void main (String args[]) {
	Name n1,n2;
	BirthDate b1,b2;
	Birthinfo z1, z2, z3, z4, z5;

	
// Testing name constructors
 n1= new Name("Akash", "Raja", "Shekhara" );
 n2 = new Name("Amrita", "Dhaliwal");
 
// Testing get methods 	
    System.out.println(n1.getFirst() + " is the first name of n1."); 
	System.out.println(n1.getMiddle() + " is the middle name of n1.");
	System.out.println(n1.getFamily() + " is the Family name of n1.");
	
	// Testing set methods 
	n1.setFirst("Amrita");
	System.out.println(n1.toString() + " is the new first name of n1.");
	n1.setMiddle("Raja");
	System.out.println( n1.toString() + " is the new middle name n2.");
	n2.setFamily("Shekhara");
	System.out.println(n2.toString() + " is the new last name n2.");
	
	// equals 
	if (n1.equals(n2)){
		System.out.println(n2.toString() + " is the name of both n1 and n2");	
	}else{
		System.out.println("n1 and n2 are not equal.");
	}
	
	//CompareTo
	 
	if (n1.compareTo(n2) < 0) {
		System.out.println(n1.toString()+" is before "+  n2.toString());	
	}else if (n1.compareTo(n2) > 0) {
		System.out.println(n1.toString() + " is after " + n2.toString());
	}else if(n1.compareTo(n2) == 0) {
		System.out.println( n1.toString() + " is equal to " +  n2.toString());
	}//compareTo
	
	// before
	if (n2.before(n1)) {
		System.out.println(n2.toString() + " is before " + n1.toString());		
	}else {
		System.out.println(n2.toString() + " is not before " + n1.toString() );
	}
	
	//after
	if(n2.after(n1)) {
		System.out.println(n2.toString() + " is after " + n1.toString());	
	}else {
		System.out.println(n2.toString() + " is not after " + n1.toString());
	}
	
	// Testing BirthDate constructors
	 b1= new BirthDate(5, 19, 1997);
	 b2 = new BirthDate(15, 3);
	 
	 	System.out.println(b1.getMonth() + " is the month of BirthDate of b1."); 
		System.out.println(b1.getYear() + " is the year of BirthDate of b1.");
		System.out.println(b1.getDay() + " is the day of BirthDate of b1.");
	 
		// Testing set methods 
		b1.setMonth(12);
		System.out.println(b1.toString() + " is the new month of BirthDate of b1.");
		b1.setDay(15);
		System.out.println( b1.toString() + " is the new the year of BirthDate of b1.");
		b2.setYear(2023);
		System.out.println(b2.toString() + " is the new day of BirthDate of b2.");
		
		// equals 
		if (b1.equals(b2)){
			System.out.println(b2.toString() + " is the BirthDate of both b1 and b2");	
		}else{
			System.out.println("b1 and b2 are not equal.");
		}
		
		if (b1.compareTo(b2) < 0) {
			System.out.println(b1.toString()+" is before "+  b2.toString());	
		}else if (b1.compareTo(b2) > 0) {
			System.out.println(b1.toString() + " is after " + b2.toString());
		}else if(b1.compareTo(b2) == 0) {
			System.out.println( b1.toString() + " is equal to " +  b2.toString());
		}//compareTo
		
		// before
		if (b2.before(b1)) {
			System.out.println(b2.toString() + " is before " + b1.toString());		
		}else {
			System.out.println(b2.toString() + " is not before " + b1.toString() );
		}
		
		// Testing Birthinfo constructors
		 z1= new Birthinfo("Akash", "Raja", "Shekhara",5, 19, 1997);
		 z2 = new Birthinfo("Amrita","Raja","Dhaliwal",15, 3);
		 z3 = new Birthinfo("Amrita", "Dhaliwal",15, 3, 2014);
		 z4 = new Birthinfo("Amrita","Raja", "Dhaliwal");
		 
		// Testing get methods 
		 	System.out.println(z1.getName() + " is the name of z1."); 
			System.out.println(z1.getBirthDate() + " is the BirthDate of z1.");
	    
			// Testing set methods 
			z1.setName(n1);
			System.out.println(z1.toString() + " is the new month of BirthDate of b1.");
			z2.setBirthDate(b1);
			System.out.println( b2.toString() + " is the new the year of BirthDate of b1.");
			
			// equals 
			if (z1.equals(z2)){
				System.out.println(z1.toString() + " is the BirthDate of both b1 and b2");	
			}else{
				System.out.println("z1 and z2 are not equal.");
			}	
			
		
			
			
			
		//Testing 
			
	}//main class
}//TestBirthInfo
