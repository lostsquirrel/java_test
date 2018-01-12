package demo.java.reflect;

public class Foo {
    private float primitive;

    private Float boxed;

    public float getPrimitive() {
        return primitive;
    }

    public void setPrimitive(float primitive) {
        this.primitive = primitive;
    }

    public Float getBoxed() {
        return boxed;
    }

    public void setBoxed(Float boxed) {
        this.boxed = boxed;
    }

    @Override
    public String toString() {
        return "Foo{" +
                "primitive=" + primitive +
                ", boxed=" + boxed +
                '}';
    }
}
