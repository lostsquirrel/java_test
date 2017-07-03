package demo.io;

import java.io.IOException;
import java.util.Scanner;

import org.junit.Test;

public class TestScanner {

	private void test1() {
		Scanner s = new Scanner(System.in);
		System.out.println("test1:" + s.hashCode());
		System.out.println(s.nextInt());
//		s.close();
	}
	
	private void test2() {
		Scanner s = new Scanner(System.in);
		System.out.println("test2:" + s.hashCode());
		System.out.println(s.nextInt());
	}
	
	@Test
	public void testScanner() {
		test1();
		test2();
	}
	
	@Test
	public void testScanner2() throws IOException {
		Scanner s = new Scanner(System.in);
		System.out.println(System.in.available());
		System.out.println("test1:" + s.hashCode());
		System.out.println(s.nextInt());
		s.reset();
		s.close();
//		System.out.println(System.in.available());
//		Scanner s1 = new Scanner(System.in);
//		System.out.println("test2:" + s1.hashCode());
//		System.out.println(s1.nextInt());
//		s1.close();
	}
	
}
