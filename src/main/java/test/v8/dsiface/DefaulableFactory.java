package test.v8.dsiface;

import java.util.function.Supplier;

public interface DefaulableFactory {
	static Defaulable create(Supplier<Defaulable> supplier) {
		return supplier.get();
	}
}
