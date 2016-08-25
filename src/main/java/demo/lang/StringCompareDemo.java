package demo.lang;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class StringCompareDemo {

	private static final Log log = LogFactory.getLog(StringCompareDemo.class);
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
