// Student name:  Dario Melconian	
// Student ID:  251044493

public class Answer1 extends ClassA {
	
	public static int numObjectsAnswer1;
	
	
	// numObjectsAnswer method
	public int numObjectsAnswer1() {
				
		return numObjectsAnswer1;
	}
	
	
	// constructor
	public Answer1() {
		
		numObjectsAnswer1 ++;
	}
	
	
	// method1 method
	public void method1(int test) throws Exception3 {
		
		ClassB var = new ClassB();

		try { 
			
			var.methodB1(test);
			
			var.methodB2(test);
	
	
		}
		catch (Exception1 e) {
			
			m(test);
			
			// catch the Exception1 in methodB1
			if (test == 3) {
				
				System.out.println("methodB1 threw the exception");
			}
		}
		
		catch (Exception2 e) {
				
			// catch the Exception2 in methodB1
			if (test == 5) {
				
				System.out.println("methodB1 threw the exception");
			}
			
			// catch the Exception2 in methodB2
			if (test == 4) {
				
				System.out.println("methodB2 threw the exception");
			}
			
			// catch Exception3 
			throw new Exception3("test");
			
			
		}  // catch closes
		
	}  // method closes
		
}  // class closes