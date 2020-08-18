package Java8;
interface interface1
{
	default void add(int a,int b) {
		System.out.println(a+b);
	}
	
	void abstractMethod(int c);
	
	static public void myStatic()
	{
		System.out.println("This is static");
	}
}
interface interface2
{
	default void add(int a,int b) {
		System.out.println(a+b);
	}
}
public class DefaultAndStaticMethod implements interface1, interface2 {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DefaultAndStaticMethod defaultAndStaticMethod=new DefaultAndStaticMethod();
		defaultAndStaticMethod.abstractMethod(5);
		defaultAndStaticMethod.add(5,6);
		interface1.myStatic();
	}

	

	@Override
	public void abstractMethod(int c) {
		System.out.println("impleted abstract method "+c);
		
	}

	@Override
	public void add(int a, int b) {
		System.out.println("Implemented duplicate methodb int in implementing class "+a+b);
	}

}
