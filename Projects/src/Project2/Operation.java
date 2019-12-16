package Project2;
/**
 * Operator for arithmetic
 *
 */
public abstract class Operation {
	public Operation() {	}
	
	public  int evaluation() {return 0;}
	/**
	 * Evaluates a and b using arithmetic calculation
	 * @param a- an int number used for calculations
	 * @param b- an int number
	 * @return int- evaluation result
	 */
	public  int evaluation(int a, int b) {return 0;}
	/**
	 * Priority operator has in the expression. Higher number holds higher priority
	 * @return int- level of priority
	 */
	public  int getPriority() {return 0;}
	
	/**
	 * Print output of the class
	 */
	public String toString() {
		return "Operator";
	}

}
