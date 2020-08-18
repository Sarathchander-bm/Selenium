package basicJava.p1;

public class AcessModifireMethodOverriding extends A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
//Ref : javatpoint
	// Compile error : Cannot reduce the visibility of the inherited method from A
	// void protectedMsg(){System.out.println("Hello java");}
	// protected void publicMsg() {System.out.println("hellow ");}

	public void protectedMsg() {
		System.out.println("we can increasee/keep same the visibility");
	}
}

class A {
	protected void protectedMsg() {
		System.out.println("Hello java");
	}

	public void publicMsg() {
		System.out.println("Hello java");
	}
}
