package Project2;
/**
 * Operator for exponent
 *
 */
public class Exponent extends Operation{

	@Override
	public int evaluation(int a, int b) {
		// TODO Auto-generated method stub
		return (int)Math.pow(a,b);
	}

	@Override
	public int getPriority() {
		// TODO Auto-generated method stub
		return 3;
	}
	
	public String toString() {
		return "^";
	}
}
