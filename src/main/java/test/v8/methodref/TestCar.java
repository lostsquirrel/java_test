package test.v8.methodref;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestCar {
	
	private static final Logger logger = LoggerFactory.getLogger(TestCar.class);
	
	final List< Car > cars = Arrays.asList(Car.create(Car::new));

// 构造器引用
	//Class< T >::new
//	Class::new
	@Test
	public void testConstructor() throws Exception {
		final Car car = Car.create( Car::new );
		logger.debug(car.toString());
	}
	
//	表述方法引用
	@Test
	public void testStaticM() throws Exception {
//		Class::static_method
		cars.forEach(Car::collide);
	}
	
	@Test
	public void testInstanceMA() throws Exception {
//		Class::method
		cars.forEach(Car::repair);
	}
	
	@Test
	public void testInstanceMP() throws Exception {
//		instance::method
		final Car police = Car.create(Car::new);
		cars.forEach(police::follow);
	}
}
