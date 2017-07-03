package demo.function;

import java.util.Arrays;

public class VaryingVariableDemo {

	private static void test(String a, Integer ... v) {
		System.out.println(a);
		System.out.println(Arrays.toString(v));
	}
	
	public static void main(String[] args) {
		test("abc");
	}
}
