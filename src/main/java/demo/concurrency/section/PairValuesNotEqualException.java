package demo.concurrency.section;

public class PairValuesNotEqualException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PairValuesNotEqualException(Pair pair) {
		super(String.format("Pair %s被玩坏了", pair));
	}
}
