package demo.lang;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StringCompareDemo {

	private static final Logger log = LoggerFactory.getLogger(StringCompareDemo.class);
	@Test
	public void testName() throws Exception {
		String[] targets =  new String[]{null, "", "acc", "sdfsd", "xxoo"};
		for (String target : targets) {
			if ("acc".equals(target)) {
				log.debug(target);
			}
		}
	}
}
