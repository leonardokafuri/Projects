package Sorting;

public class BubbleSort {
	
	/*
	 * Big O analysis:
	 * Not an efficient algorithm because it uses nested loops
	 * useful only for small data set
	 */
	
	public int [] bubblesort(int [] list)
	{
		int i,j,temp; // i for outter loop , j for inner loop and temp for swapping 
		for(i=0;i<list.length -1;i++) // will run through the length of the list -1 
		{
			for(j=0; j<list.length-1-i;j++) // will run through the array minus the number of iterations completed which is i
			{
				if(list[j]>list[j+1])//comparing an item to the item to its mediate right 
				{
					temp=list[j];
					list[j]=list[j+1];
					list[j+1]=temp;
				}
			}
		}
		return list;
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] list = new int[] {7,8,5,4,9,2}; // creating the array 
		BubbleSort test = new BubbleSort(); // object
		test.bubblesort(list);// calling the method to sort
		System.out.println("This is Bubble Sort");
		for(int x= 0; x<list.length; x++) // looping through the array to be printed 
		System.out.print(list[x]+",");


	}

}
