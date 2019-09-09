package Sorting;
import java.util.Random;
import java.util.Arrays;
public class QuickSort {
	/*
	 * Quick sort is a recursive method 
	 * Divide and conquer algorithm 
	 * very efficient with large data-sets
	 * Big O analysis: 
	 * Worst case : O(n^2)
	 * Average case O(n log n)
	 * Performance depends largely on pivot selection 
	 */
	
	public void quickSort(int [] A) // method that will be called in main
	{
		quickSort(A,0,A.length-1); // calling private method and passing A, the first indeces and last indeces of A
	}
	private void quickSort(int[]A, int low, int high)
	{
		if(low<high+1) // if there is more than one item left to sort 
		{
			int p = partition(A,low,high);// get a new pivot value
			quickSort(A,low,p-1);//call quick sort on each the left and right partition
			quickSort(A,p+1,high);
		}
	}
	private void swap(int[] A,int index1,int index2)
	{
		int temp= A[index1]; // swap 2 values 
		A[index1]=A[index2];
		A[index2]= temp;
		
	}
	//returns random pivot index between low and high inclusive 
	private int getPivot(int low,int high) // Receives the low and high index for a partition  and find a new pivot within that range
	{
		Random rand = new Random();
		return rand.nextInt((high-low)+1)+low;
	}
	//moves all n<pivot to left of pivot and all n>pivot 
	// to right of pivot, then returns pivot index
	private int partition(int[] A, int low, int high)
	{
		swap(A,low,getPivot(low,high)); // start by getting a pivot in that range then the swap will swap that pivot into the left most position
		int border = low +1;// set a border which is the left pointer just to the right of the pivot location
		for(int i=border; i<=high; i++) // go through the items in this partition
		{
			if(A[i] < A[low]) // pivot is A[low]
			{
				swap(A,i,border++); // if the value that its being compared is lower swap with the border value
			}
		}
		swap(A,low,border-1); // swap the pivot value into its proper position
		return border-1; // return the index of the pivot value
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QuickSort qs = new QuickSort();
		int [] A= {9,0,1,3,4,5,2,9,8,7,6,5,9,1,0,9};
		System.out.println(Arrays.toString(A));
		qs.quickSort(A);
		System.out.println(Arrays.toString(A));
		

	}

}
