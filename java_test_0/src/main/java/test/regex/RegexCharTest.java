package test.regex;

import org.junit.Test;

public class RegexCharTest extends BaseTest {
	
	@Test
	public void testXX() {
		regex = "x";
		input = "x";
		expected = true;
	}
	
	@Test
	public void testXXXX() {
		regex = "x";
		input = "xxx";
		expected = false;
	}
	
	@Test
	public void testXO() {
		regex = "x";
		input = "o";
		expected = false;
	}
	
	@Test
	public void testXEmpty() {
		regex = "x";
		input = "";
		expected = false;
	}
	
	@Test
	public void testBackslash() {
		regex = "\\\\";
		input = "\\";
		expected = true;
	}
	
	@Test
	public void testBackslash1() {
		regex = "\\\\";
		input = "/";
		expected = false;
	}
	
	@Test
	public void testOct() {
		regex = "\\0101";
		input = "A";
		expected = true;
	}
	
	@Test
	public void testHex() {
		regex = "\\x41";
		input = "A";
		expected = true;
	}
	
	@Test
	public void testUnicode() {
		regex = "\\u0041";
		input = "A";
		expected = true;
	}
	
}
