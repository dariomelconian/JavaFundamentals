public class Question1 {
	public static void main(String[] args) {
		Answer1 var1 = null;
		boolean testPassed = true;
		// Test 1
		var1 = new Answer1();
		var1.m(1);
		
		// Test 2
		try {
			Answer1[] arr = new Answer1[5];
			for (int i = 0; i < 5; ++i) {
				arr[i] = new Answer1();
				if (arr[i].numObjectsAnswer1() != (i+1)) testPassed = false;
			}
			var1 = new Answer1();
			if (var1.numObjectsAnswer1() == 7) 
				System.out.println("Test 2 passed");
			else System.out.println("Test 2 failed");
		}
		catch (Exception e) {
			System.out.println("Test 2 failed");
		}
		
		// Test 3
		try {
			var1.method1(3);
		} 
		catch (Exception e) {
			System.out.println("Test 3 failed");
		}
		
		// Test 4
		try {
			var1.method1(4);
			System.out.println("Test 4 failed");
		}
		catch (Exception3 e) {
			System.out.println("Test 4 passed");
		}
		catch (Exception e) {
			System.out.println("Test 4 failed");
		}
		
		// Test 5
		try {
			var1.method1(5);
			System.out.println("Test 5 failed");
		}
		catch (Exception3 e) {
			System.out.println("Test 5 passed");
		}
		catch (Exception e) {
			System.out.println("Test 5 failed");
		}
		
		// Test 6
		try {
			var1.method1(6);
			System.out.println("Test 6 passed");
		}
		catch (Exception3 e) {
			System.out.println("Test 5 failed");
		}
		catch (Exception e) {
			System.out.println("Test 5 failed");
		}
				
	}
}