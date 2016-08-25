package demo.regex;

import org.junit.Test;

public class RegexCharsTest extends BaseTest {

	@Test
	public void testSimpleA() throws Exception {
		regex = "[abc]";
		input = "a";
		expected = true;
	}
	
	@Test
	public void testSimpleB() throws Exception {
		regex = "[abc]";
		input = "b";
		expected = true;
	}
	
	@Test
	public void testSimpleC() throws Exception {
		regex = "[abc]";
		input = "c";
		expected = true;
	}
	
	@Test
	public void testSimpleD() throws Exception {
		regex = "[abc]";
		input = "d";
		expected = false;
	}
	
	@Test
	public void testSimpleEmpty() throws Exception {
		regex = "[abc]";
		input = "";
		expected = false;
	}
	
	@Test
	public void testNegationA() throws Exception {
		regex = "[^abc]";
		input = "a";
		expected = false;
	}
	
	@Test
	public void testNegationB() throws Exception {
		regex = "[^abc]";
		input = "b";
		expected = false;
	}
	
	@Test
	public void testNegationC() throws Exception {
		regex = "[^abc]";
		input = "c";
		expected = false;
	}
	
	@Test
	public void testNegationD() throws Exception {
		regex = "[^abc]";
		input = "d";
		expected = true;
	}
	
	@Test
	public void testNegationUA() throws Exception {
		regex = "[^abc]";
		input = "A";
		expected = true;
	}
	
	@Test
	public void testNegationEmpty() throws Exception {
		regex = "[^abc]";
		input = "";
		expected = false; 
	}
	
	@Test
	public void testRange() throws Exception {
		regex = "[a-zC-M]";
		add("", false);
		add("a", true);
		add("d", true);
		add("z", true);
		add("A", false);
		add("C", true);
		add("G", true);
		add("M", true);
		add("N", false);
		add("_", false);
		
		doMathBatch();
	}
	
	@Test
	public void testUnion() throws Exception {
		regex = "[a-d[m-p]]";
		add("", false);
		add("a", true);
		add("c", true);
		add("d", true);
		add("g", false);
		add("m", true);
		add("o", true);
		add("p", true);
		add("t", false);
		add("_", false);
		
		doMathBatch();
	}
	@Test
	public void testUnion2() throws Exception {
		regex = "[a-dm-p]";
		add("", false);
		add("a", true);
		add("c", true);
		add("d", true);
		add("g", false);
		add("m", true);
		add("o", true);
		add("p", true);
		add("t", false);
		add("_", false);
		
		doMathBatch();
	}
	
	@Test
	public void testIntersection() throws Exception {
		regex = "[a-e&&d-g]";
		add("", false);
		add("a", false);
		add("d", true);
		add("e", true);
		add("g", false);
		add("o", false);
		add("_", false);
		
		doMathBatch();
	}
	
	@Test
	public void testSubtraction() throws Exception {
		regex = "[a-z&&[^m-p]]";
		
		add("", false);
		add("a", true);
		add("d", true);
		add("m", false);
		add("o", false);
		add("p", false);
		add("t", true);
		add("z", true);
		add("_", false);
		
		doMathBatch();
	}
}
