package demo.v8.repeatanno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class RepeatingAnnotations {
	@Target(ElementType.TYPE)
	@Retention(RetentionPolicy.RUNTIME)
	public @interface Filters {
		Filter[] value();
	}

	@Target(ElementType.TYPE)
	@Retention(RetentionPolicy.RUNTIME)
	@Repeatable(Filters.class)
	public @interface Filter {
		String value();
	};

	@Filter("filter1")
	@Filter("filter2")
	@Filter("filter3")
	@Filter("filter4")
	@Filter("filter5")
	@Filter("filter6")
	@Filter("filter7")
	public interface Filterable {
	}
	
	@Filters({@Filter("filter7"), @Filter("filter6")})
	public class TestX {
		
	}

	public static void main(String[] args) {
		for (Filter filter : Filterable.class.getAnnotationsByType(Filter.class)) {
			System.out.println(filter.value());
		}
		
		for (Filter filter : TestX.class.getAnnotationsByType(Filter.class)) {
			System.out.println(filter.value());
		}
	}
}
