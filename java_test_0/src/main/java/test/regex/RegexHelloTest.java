package test.regex;

import org.junit.Assert;
import org.junit.Test;

public class RegexHelloTest {

	@Test
	public void testHelloWorld() {
		String regex = "a*b";
		String input = "aaaaab";
		boolean b = RegexUtils.matches(regex, input);
		
		Assert.assertTrue(b);
	}

	@Test
	public void testHelloWorld1() {
		String regex = "a*b";
		String input = "ab";
		boolean b = RegexUtils.matches(regex, input);
		
		Assert.assertTrue(b);
	}
	
	@Test
	public void testHelloWorld2() {
		String regex = "a*b";
		String input = "aaaacccddd";
		boolean b = RegexUtils.matches(regex, input);
		
		Assert.assertFalse(b);
	}
	
	@Test
	public void testHelloWorld3() {
		String regex = "a*b";
		String input = "bbbbcccddd";
		boolean b = RegexUtils.matches(regex, input);
		
		Assert.assertFalse(b);
	}
	
	@Test
	public void testHelloWorld4() {
		String regex = "a*b";
		String input = "ba";
		boolean b = RegexUtils.matches(regex, input);
		
		Assert.assertFalse(b);
	}
	
}
