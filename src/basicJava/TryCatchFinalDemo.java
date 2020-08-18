package basicJava;

import java.io.FileNotFoundException;

import org.apache.commons.collections.functors.ExceptionFactory;

public class TryCatchFinalDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("First call " + tryCatch(0));
		System.out.println("Second call " + tryCatch(5));
	
		
		//o/p
//		/ by zero
//		In ArithmeticException
//		in finally
//		First call 300
//		3
//		in try
//		in finally
//		Second call 300

		
		// In all condition return from finally will be considered 
	}

	static int tryCatch(int a) {

		try {
			int b = 15;
			System.out.println(b / a);
			System.out.println("in try");
			return b / a;
		} catch (ArithmeticException e) {
			System.out.println(e.getMessage());
			System.out.println("In ArithmeticException");
			// System.exit(0);
			return 100;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("In Exception");
			// we can use system.exit for exit without finally
			// System.exit(0);
			return 200;
		} finally {
			System.out.println("in finally");

			// We can have try catch in finally as well
//			try {
//				int c = 0, d = 33;
//				int k = d / c;
//			} catch (Exception e) {
//				System.out.println("In finally" + e.getMessage());
//			}
			return 300;
		}
		// un reachable code
		// return 400;
	}
}
