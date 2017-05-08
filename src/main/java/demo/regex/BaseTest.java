package demo.regex;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Assert;

public class BaseTest {

	protected String regex;
	
	protected CharSequence input;
	
	protected Boolean result;
	
	protected Boolean expected;
	
	protected String message;
	
	private Map<String, Boolean> source = new HashMap<>();
	
	public void doMatch() {
		doMatchBase();
	}

	private void doMatchBase() {
		result = RegexUtils.matches(regex, input);
		message = String.format("regex: %s, input: %s. matches: %s", regex, input, result);
		Assert.assertEquals(message, expected, result);
	}
	
	public void doMathBatch() {
		for (Entry<String, Boolean> item : source.entrySet()) {
			input = item.getKey();
			expected = item.getValue();
			doMatchBase();
		}
		destory();
	}
	
	public void add(String input, Boolean expected) {
		source.put(input, expected);
	}
	
	public void destory() {
		source.clear();
	}
}
