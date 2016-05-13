package test.v8.dsi;

import java.util.function.Supplier;

public interface DefaulableFactory {
	static Defaulable create(Supplier<Defaulable> supplier) {
		return supplier.get();
	}
}
