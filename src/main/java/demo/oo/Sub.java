package demo.oo;

public class Sub extends Base {

	public String showMe() {
		return "Sub";
	}
	
	public static void main(String[] args) {
		Sub s = new Sub();
		s.print();
	}
}
