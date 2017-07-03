package demo.others;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestInstanceof {

	private static final Logger log = LoggerFactory.getLogger(TestInstanceof.class);
	@Test
	public void testNull() throws Exception {
		if (null instanceof TestInstanceof) {
			log.debug("instanceof can accept null");
		}
	}
}
