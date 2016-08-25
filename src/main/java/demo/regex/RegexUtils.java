package demo.regex;

import java.util.regex.Pattern;

public class RegexUtils {

	public static boolean matches(String regex, CharSequence input) {
		boolean b = Pattern.matches(regex, input);
		return b;
	}
}
