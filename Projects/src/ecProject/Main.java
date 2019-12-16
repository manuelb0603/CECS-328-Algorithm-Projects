package ecProject;

import java.util.*;
import java.io.*;
/**
 * @author Manuel Beltran, John Luu
 */
public class Main{
	public static void main(String[] args)
	{
		//Create scanner 
		Scanner scan = new Scanner(System.in);
		
		QuickSort qs = new QuickSort();
		RadixSort rs = new RadixSort();
		
		int num;
		int kBit;
		int choice;
		String[] elements;
		int[] numbers;
		
		do {
			Menu();
			choice = scan.nextInt();
			scan.nextLine();
			
			if(choice == 1)
			{
				//Number 1
				System.out.println("Please enter non-negative integer : ");
				num = scan.nextInt();
				scan.nextLine();
				System.out.println("Please enter a number of bit places : ");
				kBit = scan.nextInt();
				scan.nextLine();
				System.out.println("Kth bit set number : " + setKthBit(num, kBit));
			}
			else if(choice == 2)
			{
				//Number 2
				System.out.println("Please enter binary of zeros and ones");
				String binary = scan.nextLine();
				int decimal = Integer.parseInt(binary,2);
				System.out.println("Value: " + decimal);
				
			}
			else if(choice == 3)
			{
				//Number 3
				double start1;
				double start2;
				double end1; 
				double end2;
				
				System.out.println("Enter non-negative numbers separated with commas");
				System.out.println("ex. 1,2,3,4");
				String stringInput = scan.nextLine();
				elements = stringInput.split(",");
				System.out.println(elements.length);
				numbers = new int[elements.length];
				for(int i = 0;i < elements.length;i++)
				{
					numbers[i] = Integer.parseInt(elements[i]);
				}
				
				System.out.println("Sorting with QuickSort! ");
				start1 = System.currentTimeMillis();
				qs.sort(numbers, 0, numbers.length -1);
				end1 = System.currentTimeMillis();
				System.out.println("Elapsed "+ getStringTime(start1,end1));
				qs.printArray(numbers);
				System.out.println("Sorting with RadixSort! ");
				start2 = System.currentTimeMillis();
				rs.radixsort(numbers, numbers.length);
				end2 = System.currentTimeMillis();
				System.out.println("Elapsed "+ getStringTime(start2,end2));
				rs.print(numbers,numbers.length);
				System.out.println();
			}
			else if(choice == 4)
			{
				//Number 4
				double s1;
				double e1;
				double s2; 
				double e2;
				System.out.println("Please enter a length for array : ");
				int length = scan.nextInt();
				scan.nextLine();
				System.out.println("Please enter max range to generate numbers from 0 to max :");
				int max = scan.nextInt();
				scan.nextLine();
				int[] array;
				array = new int[length];
				for(int i = 0; i<length; i++)
				{
					int inRandom = getRandomInteger(max, 0);
					array[i] = inRandom;
				}
				
				System.out.println("Sorting with QuickSort! ");
				s1 = System.currentTimeMillis();
				qs.sort(array, 0, array.length -1);
				e1 = System.currentTimeMillis();
				System.out.println("Elapsed "+ getStringTime(s1,e1));

				qs.printArray(array);
				System.out.println("Sorting with RadixSort! ");
				s2 = System.currentTimeMillis();
				rs.radixsort(array, array.length);
				e2 = System.currentTimeMillis();
				System.out.println("Elapsed "+ getStringTime(s2,e2));
				rs.print(array, array.length);
				System.out.println();
			}
		}while(choice != 5);
		scan.close();
		System.out.println("Have a Good Day! ");
	}
	
	public static void Menu()
	{
		System.out.println("1. Find K-bit Binary representation of number\n"
				+ "2. Find Decimal Number of Binary input\n"
				+ "3. Calculate Running Time of RadixSort and QuickSort\n"
				+ "4. Generate Random Array and Find running time of RadixSort and QuickSort\n"
				+ "5. Quit ");
	}
	
	/**
	 * Function to set the kth bit
	 */
	public static int setKthBit(int n, int k)
	{
		return ((1 << k) | n);
	}
	public static String getStringTime(double start, double end)
    {
    	double timeLength = (end - start);
    	double newTimeLength = (timeLength >= 1000) ? (timeLength) / 1000 : timeLength;
    	String timeString = "Time : " + Double.toString(newTimeLength);
    	timeString = (timeLength >= 1000) ? timeString + "seconds" : timeString + "miliseconds";
    	return timeString;
    }
	public static int getRandomInteger(int maximum, int minimum){
        return ((int) (Math.random()*(maximum - minimum))) + minimum;
    }
}