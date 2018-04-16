package demo.java.codewars;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class PaginationHelperTest {

    private static PaginationHelper<Character> helper;

    @BeforeClass
    public static void init() {
        helper = new PaginationHelper<>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f'), 4);
    }

    @Test
    public void testPageCount() {
        assertEquals(helper.pageCount(), 2);
    }

    @Test
    public void testItemCount() {
        assertEquals(helper.itemCount(), 6);
    }

    @Test
    public void testPageItemCount1() {
        assertEquals(helper.pageItemCount(0), 4);
    }

    @Test
    public void testPageItemCount2() {
        assertEquals(helper.pageItemCount(1), 2);
    }

    @Test
    public void testPageItemCount3() {
        assertEquals(helper.pageItemCount(2), -1);
    }

    @Test
    public void testPageIndex1() {
        assertEquals(helper.pageIndex(5), 1);
    }

    @Test
    public void testPageIndex2() {
        assertEquals(helper.pageIndex(2), 0);
    }

    @Test
    public void testPageIndex3() {
        assertEquals(helper.pageIndex(20), -1);
    }

    @Test
    public void testPageIndex4() {
        assertEquals(helper.pageIndex(-10), -1);
    }

    @Test
    public void testPageIndex5() {
        helper = new PaginationHelper<>(null, 4);
        assertEquals(helper.pageIndex(0), -1);
    }
}
