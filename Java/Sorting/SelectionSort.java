package Sorting;

public class SelectionSort {
	/*
	 * Big O analysis:
	 selection sort is not a fast sorting algorithm 
	 because it uses nested loops to sort 
	 
	 its only useful for small data sets
	 */
	public int[] selectionSort(int[] list) //taking an array of numbers that will be sorted
	{
		int i,j,minValue,minIndex,temp =0; // i for outter loop, j for inner loop, temp for swapping, minIndex tracking the min value
		for(i=0;i<list.length; i++)//this will run through the values of the array being passed
		{
			minValue = list[i];
			minIndex=i; //initialize minValue and minIndex to first unsorted item each time through the outer loop
			for(j=i;j<list.length;j++) // this will run through the next unsorted item of the array all the way till the end 
			{
				if(list[j]<minValue)// compare each time it is being run for the min value
				{
					minValue=list[j]; // if its true set the min value to that value of the array
					minIndex=j;
				}
			}
			//check if the value was the first, if it was dont swap if its not 
			if(minValue<list[i])
			{
				//swap the min value with the first unsorted value
				temp=list[i];
				list[i]=list[minIndex];
				list[minIndex]=temp;
			}
		}
		
		return list;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] list = new int[] {7,8,5,4,9,2}; // creating the array 
		SelectionSort test = new SelectionSort(); // object
		test.selectionSort(list);// calling the method to sort
		System.out.println("This is Selection Sort");
		for(int x= 0; x<list.length; x++) // looping through the array to be printed 
		System.out.print(list[x]+",");

	}

}
