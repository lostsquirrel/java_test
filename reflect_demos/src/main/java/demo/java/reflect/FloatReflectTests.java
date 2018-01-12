package demo.java.reflect;


import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;

public class FloatReflectTests {

    private static final Logger log = LoggerFactory.getLogger(FloatReflectTests.class);

    private static final String PRIMITIVE_FIELD_NAME = "primitive";
    private static final String BOXED_FIELD_NAME = "boxed";

    private static final float primitiveValue = 3.14f;

    private static final Float boxedValue = new Float(3.14f);

    private Foo foo;

    private Field field;

    @Before
    public void init() throws IllegalAccessException, InstantiationException {
        foo = Foo.class.newInstance();
    }

    @Test
    public void testReflectPrimitiveSetWithPrimitive() throws NoSuchFieldException, IllegalAccessException {
        this.getPrimitiveField().set(foo, primitiveValue);
        assertPrimitive();
    }

    @Test
    public void testReflectPrimitiveSetWithBoxed() throws NoSuchFieldException, IllegalAccessException {
        this.getPrimitiveField().set(foo, boxedValue);
        assertPrimitive();
    }

    @Test
    public void testReflectPrimitiveSetFloatWithPrimitive() throws NoSuchFieldException, IllegalAccessException {
        this.getPrimitiveField().setFloat(foo, primitiveValue);
        assertPrimitive();
    }

    @Test
    public void testReflectPrimitiveSetFloatWithBoxed()throws NoSuchFieldException, IllegalAccessException {
        this.getPrimitiveField().setFloat(foo, boxedValue);
        assertPrimitive();
    }

    @Test
    public void testReflectBoxedSetWithPrimitive() throws NoSuchFieldException, IllegalAccessException {
        this.getBoxedField().set(foo, primitiveValue);
        assertBoxed();
    }

    @Test
    public void testReflectBoxedSetWithBoxed() throws NoSuchFieldException, IllegalAccessException {
        this.getBoxedField().set(foo, boxedValue);
        assertBoxed();
    }

    /**
     * Can not set java.lang.Float field demo.java.reflect.Foo.boxed to (float)3.14
     */
    @Test(expected = IllegalArgumentException.class)
    public void testReflectBoxedSetFloatWithPrimitive() throws NoSuchFieldException, IllegalAccessException {
        this.getBoxedField().setFloat(foo, primitiveValue);
        assertBoxed();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testReflectBoxedSetFloatWithBoxed()throws NoSuchFieldException, IllegalAccessException {
        this.getBoxedField().setFloat(foo, boxedValue);
    }

    private Field getPrimitiveField() throws NoSuchFieldException {
        field = Foo.class.getDeclaredField(PRIMITIVE_FIELD_NAME);
        makeAccessible();
        return field;
    }

    private void makeAccessible() {
        field.setAccessible(true);
    }


    private void assertBoxed() {
        Assert.assertTrue(boxedValue.equals(foo.getBoxed()));
    }

    private void assertPrimitive() {
        Assert.assertTrue(primitiveValue == foo.getPrimitive());
    }
    private Field getBoxedField() throws NoSuchFieldException {
        field = Foo.class.getDeclaredField(BOXED_FIELD_NAME);
        makeAccessible();
        return field;
    }

    @After
    public void destroy() {

        log.debug("{}", foo);
    }
}

