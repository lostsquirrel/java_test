package demo.java.generics;


public class Hello {

    private Float a;

    public static void main(String[] args) {
       System.out.println("hello java");
    }

    public Float getA() {
        return a;
    }

    public void setA(Float a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return "Hello{" +
                "a=" + a +
                '}';
    }
}

