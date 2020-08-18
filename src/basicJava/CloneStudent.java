package basicJava;

public class CloneStudent implements Cloneable {

	int rollno;
	String name;

	CloneStudent(int rollno, String name) {
		this.rollno = rollno;
		this.name = name;
	}

	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public static void main(String[] args) {
		try {
			CloneStudent s1 = new CloneStudent(101, "amit");

			CloneStudent s2 = (CloneStudent) s1.clone();

			System.out.println(s1.rollno + " " + s1.name);
			System.out.println(s2.rollno + " " + s2.name);

		} catch (CloneNotSupportedException c) {
		}

	}

}
