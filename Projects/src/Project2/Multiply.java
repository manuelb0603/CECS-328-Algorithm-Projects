package Project2;
/**
 * Operator for Multiplication
 *
 */
public class Multiply extends Operation{

	@Override
	public int evaluation(int a, int b) {
		return a * b;
	}

	@Override
	public int getPriority() {
		
		return 2;
	}

	public String toString() {
		return "*";
	}
}
