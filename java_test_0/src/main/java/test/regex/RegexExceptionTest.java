package test.regex;

import org.junit.Test;

public class RegexExceptionTest {

	@Test(expected=NullPointerException.class)
	public void testXNull() {
		String regex = "x";
		String input = null;
		RegexUtils.matches(regex, input);
	}
}
