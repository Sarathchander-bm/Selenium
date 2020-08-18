package basicJava;

import java.util.ArrayList;
import java.util.List;

public class MethodOverridingGlobantInteview {

	public static void main(String[] args) {
		// we must pass int parameter as we do not have default constructor
		ParentClass p = new ChildClass(10);
		System.out.println(p.k);
		p.add();
		// below method is not accesable as it is not in parent
		// p.add("Abhishek");
		ChildClass c = new ChildClass(10);
		System.out.println(c.k);
		c.add();
		System.out.println(c.add("Abhishek"));
		// No overriding for varible
		// OP
		// 5
		// 10

		// We can have final list without any problem
		final List<Integer> ls = new ArrayList<Integer>();
		ls.add(5);
		ls.add(15);
		ls.add(13);
		ls.add(16);

		System.out.println(ls);
		// if you try to remove with ls.remove(5); it will try to remove at index 5
		// below code will remove value 5
		ls.remove((Integer) 5);
		System.out.println(ls);

	}

}

class ParentClass {

	int k = 5;

	ParentClass(int a) {
	}

	int add() {
		System.out.println("In child Parent method");
		return 5;
	}
}

class ChildClass extends ParentClass {
	int k = 10;

	// If Parent does not have default constructor then in child we must define
	// parameteried
	// constructor in child
	// and super with parameter(super is also must with par), else we will get below
	// error at line
	// class Child
	// extends Parent
	// compile time Error ---------------
	// Implicit super constructor Parent() is undefined for default constructor.
	// Must define an explicit constructor
	ChildClass(int a) {
		super(a);

	}

// compile time Error-----
	// The return type is incompatible with Parent.add()
//	String add() {
//		return "abhishek";
//	}

	// we can override method with final keyword
	final String add(String name) {
		return "Hellow " + name;
	}

	// compile time error
	// This static method cannot hide the instance method from Parent
//	static int add() {
//		return 5;
//	}

	int add() {
		System.out.println("In child add method");
		return 5;
	}
}
