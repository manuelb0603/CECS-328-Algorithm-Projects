package Project2;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * 
 * @author Manuel Beltran, John Luu
 *
 */
public class Main {
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int choice;
		
		do {
			Menu();
			choice = scan.nextInt();
			if(scan.hasNextLine()) {scan.nextLine();}
			if (choice == 1)
				{
					System.out.println("Begin to enter the arithmetic expression");
					String stringArithmetic = scan.nextLine();
					ArrayList<Operation> ops = new ArrayList<Operation>();
					
					//Turn string into an array of operators
					for(int i = 0; i < stringArithmetic.length(); i++) {
						char operator = stringArithmetic.charAt(i);
						
						//Turn character into arithmetic operators
						if(operator == '^') {ops.add(new Exponent());}
						else if(operator == '*') {ops.add(new Multiply());}
						else if(operator == '/') {ops.add(new Divide());}
						else if(operator == '+') {ops.add(new Plus());}
						else if(operator == '-') {ops.add(new Minus());}
						//Turn character into an Integer
						else {	
							String number = "";
							
							//Loop through each character in string for a multiple digit Integer
							while(operator != '^' && operator != '*' && operator != '/' 
									&& operator != '+' && operator != '-') {
								
								number += operator;							
								
								//Move to check next index
								i++;
								//Break if index exceeds string end
								if(i >= stringArithmetic.length()) { break;}
								operator = stringArithmetic.charAt(i);	
								}
							
							//Subtract index so for loop can be on the right index if continued
							if(i < stringArithmetic.length()) {i--;}
							//Create Integer object
							ops.add(new Integer(java.lang.Integer.parseInt(number)));					
							}

					}
					//Create Tree
					ParseTree tree = new ParseTree(ops);
					//Reprint expression to verify integrity
					tree.walk();
					System.out.println("");
					//Print the evaluation of expression
					System.out.println(tree.evaluate());

					
			}
		} while (choice != 2);

	}
	public static void Menu() {
		System.out.println("1. Choose to enter the arithmetic expression\n"
				+ "2. Exit");
		}
}