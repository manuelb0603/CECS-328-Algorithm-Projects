package Project2;
/**
 * Operator for division
 *
 */
public class Divide extends Operation{

	@Override
	public int evaluation(int a, int b) {
		return (int)(a / b);
	}

	@Override
	public int getPriority() {
		return 2;
	}
	public String toString() {
		return "/";
	}
}
