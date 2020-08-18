package basicJava;

//ref :https://www.javatpoint.com/covariant-return-type
public class CovariantReturnTypeEx extends A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CovariantReturnTypeEx covariantReturnTypeEx = new CovariantReturnTypeEx();
		covariantReturnTypeEx.message();

		System.out.println(covariantReturnTypeEx.returnNumber());
	}

	CovariantReturnTypeEx get() {
		return this;
	}

	void message() {
		System.out.println("welcome to covariant return type");
	}

	// double returnNumber(){ return 1.2;} not allowed
	int returnNumber() {
		return 1;
	}
}

class A {
	// Both get methods have different return type but it is method overriding. This
	// is
	// known as covariant return type.

	A get() {
		return this;
	}

	// covariant return type support only for non-primitive data type
	int returnNumber() {
		return 1;
	}

}