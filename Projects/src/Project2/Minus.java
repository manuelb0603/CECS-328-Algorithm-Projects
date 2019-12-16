package Project2;
/**
 * Operator for Subtraction
 *
 */
public class Minus extends Operation{

	@Override
	public int evaluation(int a, int b) {
		// TODO Auto-generated method stub
		return a - b;
	}

	@Override
	public int getPriority() {
		// TODO Auto-generated method stub
		return 1;
	}

	public String toString() {
		return "-";
	}
}
