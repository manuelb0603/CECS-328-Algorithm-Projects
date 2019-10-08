package Project1;

import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.Random;
import java.util.Scanner;

public class Main {
	
	
	ArrayList<Integer> arrayList = new ArrayList<Integer>();
	
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int choice;
		
		do {
			Menu();
			choice = scan.nextInt();
			scan.hasNextLine();
			switch(choice)
			{
			case 1: 
				{
				
					System.out.println("Enter your Array as integers"
							+ " followed by Commas");
					int[] intArray = parseStringToIntArray(scan.nextLine());
					runAlgs(intArray,"1234", false);
					
					
			break;
			}
			case 2: 
			{
				System.out.println("Enter an Array Size");
				int size = scan.nextInt();
				System.out.println("Enter number(s) to run Solutions: \n1. Solution 1 \n2. Solution 2 \n3. Solution 3 \n4.Solution 4");
				runAlgs(genRandomArray(size), scan.nextLine(), true);
				
				break;
			}
			case 3:
			{
				System.out.println("Enter an Array1 Size");
				int size = scan.nextInt();
				System.out.println("Enter an Arrar2 Size");
				int size2 = scan.nextInt();
				System.out.println("Enter number to run Solution: \n1. Solution 1 \n2. Solution 2 \n3. Solution 3 \n4.Solution 4");
				int solutionToRun = scan.nextInt();
				predictRandomArray(size, size2, solutionToRun);
				
			}
			}
		}while(choice != 4);
		scan.close();
		System.out.println("System Closed!");
	}
	
	
	
	//***************************Algorithms***************************************************************
	public static int Alg1(int[] arrayList) {
		int maxSum = 0;
		for(int i = 0; i < arrayList.length; i++)
		{
			for(int j = i; j < arrayList.length; j++)
			{
				int thisSum = 0;
				for(int k= i; k<= j; k++) {
					thisSum += arrayList[k];
				}
				if(thisSum > maxSum) {
					maxSum = thisSum;
				}
			}
		}
		return maxSum;
	}
	
	public static int Alg2(int[] A) {
		int maxSum = 0;
		for(int i = 0; i < A.length; i++) {
			int thisSum = 0;
			for(int j = i; j < A.length; j++)
			{
				thisSum += A[j];
				if(thisSum > maxSum) {
					maxSum = thisSum;
				}
			}
		}
		return maxSum;
	}
	
	public static int Alg3(int[] A, int l, int r) {
		//Base Case1
		if (l == r) {
			return A[l];
		}
		
		//Base Case 2
		if(l+1 == r) {
			return Math.max(Math.max(A[l],A[r]),A[l]+A[r]);
		}
		
		int  mid = (l + r)/2;
		//Find the MSS that occurs in the left half of A
		int mss_left = Alg3(A,l,mid);
		
		//Find the mSS that occurs in the right half of A
		int mss_right = Alg3(A, mid+1, l);
		
		//Find the MSS that intersects both the left and right halves
		double mss_middle = mss_middle(A, l, mid, r);
		return (int) Math.max(Math.max(mss_left,mss_right),mss_middle);
	}
	
	public static double mss_middle(int[] a,int left,int mid,int right)
	{
	 double max_left_sum = Double.NEGATIVE_INFINITY;
	 int sum = 0;
	 int i;
	 for(i=mid; i >= left; i--)
	 {
	 sum += a[i];
	 if(sum > max_left_sum)
	 max_left_sum = sum;
	 }
	 double max_right_sum = Double.NEGATIVE_INFINITY;
	 sum = 0;
	 for(i=mid+1; i <= right; i++)
	 {
	 sum += a[i];
	 if(sum > max_right_sum)
	 max_right_sum = sum;
	 }
	 return max_left_sum + max_right_sum;
	}
	
	public static int Alg4(int[]A) {
		int max_sum = 0;
		int this_sum = 0;
		for(int i=0; i< A.length; i++)
		{
		 this_sum += A[i];
		 if(this_sum > max_sum) {
			 max_sum = this_sum;
		 }
		 else if(this_sum < 0) {
			 this_sum = 0;
		 }
		}
		return max_sum;
	}
	
	
	
	//*********************************************Functions*******************************************************

	public static void Menu() {
		System.out.println("1. Enter your own array to test the Algorithms\n"
				+ "2. Enter an Array size to be used to test select Algorithms\n"
				+ "3. Select a algorithm to estimate numbers runtime based on "
				+ "different array sizes\n"
				+ "4. Quit \n");
		}
	
	public static void prediction(double timelength, int size1, int size2, int toRun) {}
	
	/**
	 * This function prints the MSS and Time of chosen algorithm and makes a prediction between 2 random arrays.
	 * @param size1 - int size of random array 1
	 * @param size2 - int size of random array 2
	 * @param toRun - int choice for Algorithm to be run
	 */
	public static void predictRandomArray(int size1, int size2, int toRun) {
		double start;
		double end;
		int x;
		
		for (int i = 0; i < 2; i++) {
			int n = (i == 0) ? size1 : size2;
			int[] A =  genRandomArray(n);
			if ( toRun == 1) {
				start = System.currentTimeMillis();
				x = Alg1(A);
				end = System.currentTimeMillis();
				
			}
			else if (toRun == 2) {
				start = System.currentTimeMillis();
				x = Alg2(A);
				end = System.currentTimeMillis();
				
	
			}
			else if (toRun == 3) {
				start = System.currentTimeMillis();
				x = Alg3(A, 0, n-1);
				end = System.currentTimeMillis();
				
	
			}
			else {
				start = System.currentTimeMillis();
				x = Alg4(A);
				end = System.currentTimeMillis();
				}
			System.out.printf("MSS: %s\t%s", x, getStringTime(start,end));
			if (i == 0) {
				prediction(end - start, size1, size2, toRun);
			}
		}
			
		
	}
	
	/**
	 * This function runs algorithms of choice of a given Array and prints the MSS and/or run time
	 * @param A - int array that algorithm will perform on
	 * @param toRun - String containing up to 4 characters consisting of 1,2,3, or 4 in order to run corresponding Alg
	 * @param printTime - boolean to determine to print the run time
	 */
	public static void runAlgs(int[]A, String toRun, boolean printTime) {
		if ( toRun.contains("1")) {
			double start = System.currentTimeMillis();
			int x = Alg1(A);
			double end = System.currentTimeMillis();
			String time = (printTime) ? getStringTime(start,end) : "";
			
			
			System.out.printf("MSS: %s\t%s", x, time);
		}
		if (toRun.contains("2")) {
			double start = System.currentTimeMillis();
			int x = Alg2(A);
			double end = System.currentTimeMillis();
			String time = (printTime) ? getStringTime(start,end) : "";
			
			
			System.out.printf("MSS: %s\t%s", x, time);
		}
		if (toRun.contains("3")) {
			double start = System.currentTimeMillis();
			int x = Alg3(A, 0, A.length-1);
			double end = System.currentTimeMillis();
			String time = (printTime) ? getStringTime(start,end) : "";
			
			
			System.out.printf("MSS: %s\t%s", x, time);
		}
		if (toRun.contains("4")) {
			double start = System.currentTimeMillis();
			int x = Alg4(A);
			double end = System.currentTimeMillis();
			String time = (printTime) ? getStringTime(start,end) : "";
			
			
			System.out.printf("MSS: %s\t%s", x, time);
		}
	}
	
	/**
	 * This function takes in the start and end time, then returns "Time: [timeLength]" + "seconds" or "miliseconds" depending on the
	 * time length
	 * @param start - double that represents a start time
	 * @param end - double that represents an end time
	 * @return timeString - a string that is formatted for printing the time
	 */
	public static String getStringTime(double start, double end) {
		double timeLength = end - start;
		timeLength = (timeLength >= 1000) ? (timeLength) / 1000 : timeLength;
		
		String timeString = "Time:" + Double.toString(timeLength).format("%f.02");
		timeString = (timeLength >= 1000) ? timeString + "seconds" : timeString + "miliseconds";
		return timeString;
	}



	public static int[] genRandomArray(int n){
		int[] intArray = new int[n];
		Random random = new Random();
		for(int i = 0; i < n; i++) {
			intArray[i] = (random.nextInt(50 + 50) - 50);
		}
		return intArray;
		}
	
	public static int[] S_ArrayToInt_Array(String[] array) {
	    int[] intArray = new int[array.length];
	    for (int i = 0; i < array.length; i++) {
	    	intArray[i] = Integer.parseInt(array[i]);
	    }
	    return intArray;
	}

	public static int[] parseStringToIntArray(String string) {
	    return S_ArrayToInt_Array(string.split(","));
	}
}
