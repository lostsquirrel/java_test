package demo.oo;

public class Base {
	
	private String showMe() {
		return "Base";
	}
	
	public void print() {
		System.out.println(showMe());
		System.out.println(showMe());
	}

}
