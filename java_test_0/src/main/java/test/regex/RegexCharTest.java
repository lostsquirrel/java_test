package test.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class RegexCharTest {

	private String regex;
	
	private CharSequence input;
	
	private Boolean result;
	
	private Boolean expected;
	
	private String message;
	
	@Test
	public void testHelloWorld() {
		String regex = "a*b";
		String input = "aaaaab";
		boolean b = matches(regex, input);
		
		Assert.assertTrue(b);
	}

	@Test
	public void testHelloWorld1() {
		String regex = "a*b";
		String input = "ab";
		boolean b = matches(regex, input);
		
		Assert.assertTrue(b);
	}
	
	@Test
	public void testHelloWorld2() {
		String regex = "a*b";
		String input = "aaaacccddd";
		boolean b = matches(regex, input);
		
		Assert.assertFalse(b);
	}
	
	@Test
	public void testHelloWorld3() {
		String regex = "a*b";
		String input = "bbbbcccddd";
		boolean b = matches(regex, input);
		
		Assert.assertFalse(b);
	}
	
	@Test
	public void testHelloWorld4() {
		String regex = "a*b";
		String input = "ba";
		boolean b = matches(regex, input);
		
		Assert.assertFalse(b);
	}
	
	@Test
	public void testXX() {
		regex = "x";
		input = "x";
		doMatch();
		Assert.assertTrue(message , result);
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
		doMatch();
		Assert.assertFalse(message , result);
	}
	
	@Test
	public void testXEmpty() {
		regex = "x";
		input = "";
		doMatch();
		Assert.assertFalse(message , result);
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
	
	@Test(expected=NullPointerException.class)
	public void testXNull() {
		regex = "x";
		input = null;
		expected = false;
		doMatch();
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
	
	@After
	public void doMatch() {
		result = matches(regex, input);
		message = String.format("regex: %s, input: %s. matches: %s", regex, input, result);
		Assert.assertEquals(message, expected, result);
	}
	
	private boolean matchesx(String regex, String input) {
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(input);
		boolean b = m.matches();
		return b;
	}
	
	private boolean matches(String regex, CharSequence input) {
		boolean b = Pattern.matches(regex, input);
		return b;
	}

	@Test
	public void test() {

	}
}
