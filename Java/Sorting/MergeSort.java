package Sorting;

public class MergeSort {
	/*
	 * Merge sort divides the array given into 2, sort those 2 lists then merge them back together by
	 * comparing the 2 lists and put the lowest value 1st into the main list 
	 * so example: 
	 * array 2,4,3,1
	 * divided array 
	 * 2,4   3,1
	 * then sort those 2 
	 * 2,4   1,3
	 * then merge by comparing first the 2 to 1, if 1 is lower 1 gets added first
	 * 1, 
	 * compares 2 to 3 - 2 is lower so gets added 
	 * 1,2
	 * then compares 4 and 3 - 3 is lower, add 3 to list 
	 * 1,2,3 
	 * then put the last value remaining at the end 
	 * 1,2,3,4
	 * 
	 * Big O analysis 
	 * Its a recursive method that calls itself 
	 * divide and conquer algorithm 
	 * very efficient for large data sets
	 * does log n merge steps because each merge step doubles the list size 
	 * it does n work for each merge step because must look at every item 
	 * so it runs in O(N log n)
	 */
	public void mergeSort(int[] list, int lowIndex,int highIndex)
	{
		if(lowIndex==highIndex)//if there is only one item left in the list 
			return;//return the value and that's the base case
		else // if there is more than 1 item to be sorted in the list 
		{
			int midIndex = (lowIndex+highIndex)/2; // calculate the midddle index
			mergeSort(list,lowIndex,midIndex); // calling merge sort on the bottom half with the low and high index calculated
			mergeSort(list,midIndex+1,highIndex);// calling merge sort on the top half sending midIndex +1 as the lowIndex 
			merge(list,lowIndex,midIndex,highIndex); //calling function merge to merge both arrays 
		}
	}
	
	public void merge(int[] list, int lowIndex, int midIndex, int highIndex) {
		int[] L = new int[midIndex - lowIndex + 2];
		for (int i = lowIndex; i <= midIndex; i++) {
			L[i - lowIndex] = list[i];
		}
		L[midIndex - lowIndex + 1] = Integer.MAX_VALUE;
		
		
		int[] R = new int[highIndex - midIndex + 1];
		for (int i = midIndex + 1; i <= highIndex; i++) {
			R[i - midIndex - 1] = list[i];
		}
		R[highIndex - midIndex] = Integer.MAX_VALUE;
		
		
		int i = 0, j = 0;
		
		for (int k = lowIndex; k <= highIndex; k++) {
			if (L[i] <= R[j]) {
				list[k] = L[i];
				i++;
			}
			else {
				list[k] = R[j];
				j++;
			}
		} 
	}
	 static void printArray(int arr[]) 
	    { 
	        int n = arr.length; 
	        for (int i=0; i<n; ++i) 
	            System.out.print(arr[i] + " "); 
	        System.out.println(); 
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {12, 11, 13, 5, 6, 7,29,15,25}; 
		  
        System.out.println("Given Array"); 
        printArray(arr); 
  
        MergeSort ob = new MergeSort(); 
        ob.mergeSort(arr, 0, arr.length-1); 
  
        System.out.println("\nSorted array"); 
        printArray(arr); 

	}

}
