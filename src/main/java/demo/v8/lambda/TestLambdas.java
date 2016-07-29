package demo.v8.lambda;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestLambdas {

	final static Logger logger = LoggerFactory.getLogger(TestLambdas.class);

	@Test
	public void testLambdasNoType() throws Exception {
		Arrays.asList("a", "b", "d").forEach(e -> System.out.println(e));
	}

	@Test
	public void testLambdasHasType() throws Exception {
		Arrays.asList("e", "f", "g").forEach((String e) -> System.out.println(e));
	}

	@Test
	public void testLambdasWithCodeBlock() throws Exception {
		Arrays.asList("h", "i", "j").forEach(e -> {
			System.out.print(e);
			System.out.print(e);
		});
	}

	@Test
	public void testLambdasWithLocalVariables() throws Exception {
		String separator = ","; // 隐式转为final
		Arrays.asList("k", "l", "m").forEach((String e) -> System.out.print(e + separator));
	}

	@Test
	public void testLambdasWithFinalLocalVariables() throws Exception {
		final String separator = ",";
		Arrays.asList("n", "o", "p").forEach((String e) -> System.out.print(e + separator));
	}

	@Test
	public void testLambdasWithReturnInferred() throws Exception {
		List<String> data = Arrays.asList("s", "r", "q");
		logger.info("source data:" + data);
		data.sort((e1, e2) -> e1.compareTo(e2));
		logger.info("sorted data:" + data);
	}

	@Test
	public void testLambdasWithReturn() throws Exception {
		List<String> data = Arrays.asList("b", "d", "a");
		logger.info("source data:" + data);
		data.sort((e1, e2) -> {
			int result = e1.compareTo(e2);
			return result;
		});
		logger.info("sorted data:" + data);
	}
}
