public class ClassB {
	public ClassB () {
		Answer1 var1 = new Answer1();
		Answer1 var2 = new Answer1();
	}
	
	public void methodB1(int test) throws Exception1, Exception2 {
		if (test == 3) throw new Exception1("Test 3 failed");
		if (test == 5) throw new Exception2("Test 5 failed");
	}
	
	public void methodB2(int test) throws Exception2 {
		if (test == 4) throw new Exception2("Test 4 failed");
	}
}
		