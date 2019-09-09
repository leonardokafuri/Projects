package Sorting;

public class InsertionSort {
	/*
	 * Big O analysis 
	 Insertion sort is not a fast sorting algorithm
	 because it uses nested loops to shift items
	 into place 
	 
	 it is useful only for small data sets 
	 */
	
	public int [] insertionSort(int [] list)
	{
		int i,j,key,temp; // creating the values 
		for(i=1; i<list.length; i++) // starting the list at index 1 so i=1 because the 1st is already sorted  and going through the list 
		{
			key=list[i]; // setting the key value to the index i
			j=i-1; // j value will be the left value of the index to be compared 
			while (j>=0 && key<list[j]) // use a while loop to go through whole array so while j >=0 and the key value is lower than the value being compared 
			{
				temp = list[j]; // temp will hold the left value lower 
				list[j]=list[j+1]; // list[j] will hold the value that is higher 
				list[j+1]=temp; // list j+1 will be holding the lower value
				j--; // reduce j till reaches the end of the array
			}
		}
		
		return list; // return the list sorted 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] list = new int[] {9,4,5,1,7}; // creating the array 
		InsertionSort test = new InsertionSort(); // object
		test.insertionSort(list);// calling the method to sort
		System.out.println("This is Insertion sort");
		for(int x= 0; x<list.length; x++) // looping through the array to be printed 
		System.out.print(list[x]+",");
	}

}
