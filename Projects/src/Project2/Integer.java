package Project2;
/**
 * Operator for Integer
 *
 */
public class Integer extends Operation{
	
	private int number;
	
	public Integer(int value) { number = value;	}
	
	public int evaluation() {
		// TODO Auto-generated method stub
		return number;
	}

	@Override
	public int getPriority() {
		// TODO Auto-generated method stub
		return 4;
	}
	public String toString() {
		return "" + number;
	}
}
