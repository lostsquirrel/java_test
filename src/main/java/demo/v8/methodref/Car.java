package demo.v8.methodref;

import java.util.function.Supplier;

public class Car {
	public static Car create(final Supplier< Car > supplier) {
        return supplier.get();
    }              
        
    public static void collide( final Car car ) {
        System.out.println( "Collided " + car.toString() );
    }
        
    public void follow( final Car another ) {
        System.out.println(this.toString() + " Following the " + another.toString() );
    }
        
    public void repair() {   
        System.out.println( "Repaired " + this.toString() );
    }

	@Override
	public String toString() {
		return "Car [" + super.hashCode() + "]";
	}
    
}
