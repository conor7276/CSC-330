
public class TestInterfaces implements A, B {

	@Override
	public void doSomething(int a) {
		// TODO Auto-generated method stub
		System.out.println(a + " yay!");
	}	
	
	public void doSomething(int a, int b) {
		System.out.println(a + " " + b);
	}
	
}