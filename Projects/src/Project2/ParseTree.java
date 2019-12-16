package Project2;

import java.util.ArrayList;

/**
 * Binary Tree for Operation
 *
 */
public class ParseTree {
	private Operation root;
	//the left input to the root Operator (null if root is an integer)
	private ParseTree left = null;
	//the right input to the root Operator (null if root is an integer)
	private ParseTree right = null;
	
	/**
	 * Converts ArrayList<Operation> into ParseTree
	 * @param operations- ArrayList of Operation holding arithmetic expression
	 */
	public ParseTree(ArrayList<Operation> operations) {
		
		//Find the operation with the least priority to be root
		int leastPriority = 4;
		int indexLeastPriority = 0;
		for (int i = 0; i < operations.size(); i++) {
			int opPriority = operations.get(i).getPriority();
			if (opPriority < leastPriority || opPriority == leastPriority) {
				indexLeastPriority = i;
				leastPriority = opPriority;}
		}
		root = operations.get(indexLeastPriority);

		//if root is not an Integer, create a left and right tree
		if (root.getPriority() != 4) {
			ArrayList<Operation> leftArray = new ArrayList<Operation>();
			ArrayList<Operation> rightArray = new ArrayList<Operation>();

			//Left of array of found new root goes to left tree
			for (int i = 0; i < indexLeastPriority; i++) {
				leftArray.add(operations.get(i));
			}
			//Right of array of found new root goes to right tree
			for (int i = indexLeastPriority + 1; i < operations.size(); i++) {
				rightArray.add(operations.get(i));
			}
		left = new ParseTree(leftArray);
		right = new ParseTree(rightArray);
		}
		
	}
	/**
	 * Recursively evaluates elements in a tree
	 * @return int -- integer of evaluation
	 */
	public int evaluate() {
		if(left != null && right != null) { 
			return root.evaluation(left.evaluate(),right.evaluate());}
		else {return root.evaluation();}			
		}
	
	/**
	 * Walks through tree printing expression built in tree
	 */
	public void walk() {
		if(left != null) {left.walk();}
		System.out.printf("%s",root);
		if(right != null) {right.walk();}

	}
	
}
