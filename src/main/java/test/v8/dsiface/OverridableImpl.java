package test.v8.dsiface;

public class OverridableImpl implements Defaulable {
	@Override
	public String notRequired() {
		return "Overridden implementation";
	}
}
