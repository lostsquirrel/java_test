package demo.exception.test;

import demo.exception.FinallyDemos;
import org.junit.Assert;
import org.junit.Test;

public class FinallyDemosTest {

    @Test
    public void testReturnInFinally() {
        Assert.assertEquals(2, FinallyDemos.returnInFinally());
    }

    @Test
    public void testModifyInFinally() {
        Assert.assertEquals(1, FinallyDemos.modifyInFinally());
    }

    @Test
    public void testReturnInTryNotExecute() {
        Assert.assertEquals(2, FinallyDemos.returnInTryNotExecute());
    }
}
