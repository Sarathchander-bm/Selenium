package basicJava;

public class MethodOverriding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Parent p = new Child();
		p.add(10, 11);
		// not allowed/accessible as add with 3 parameter is not present in parent
		// p.add(1,2, 3);
		Child c = new Child();
		c.add(1, 2);
		c.add(1, 4, 3);
	}

}

class Parent {
	public void add(int a, int b) {
		System.out.println("Parent add 2par");
	}
}

class Child extends Parent {
	public void add(int a, int b) {
		System.out.println("Child add 2par");
	}

	public void add(int a, int b, int c) {
		System.out.println("Child add 3 par");
	}
}
