package demo.java.codewars;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TenMinWalkTest {
    @Test
    public void test1() {
        assertEquals("Should return true", true, TenMinWalk.isValid(new char[] {'n','s','n','s','n','s','n','s','n','s'}));
    }
    @Test
    public void test2() {
        assertEquals("Should return false", false, TenMinWalk.isValid(new char[] {'w','e','w','e','w','e','w','e','w','e','w','e'}));
    }
    @Test
    public void test3() {
        assertEquals("Should return false", false, TenMinWalk.isValid(new char[] {'w'}));
    }
    @Test
    public void test4() {
        assertEquals("Should return false", false, TenMinWalk.isValid(new char[] {'n','n','n','s','n','s','n','s','n','s'}));
    }
}
