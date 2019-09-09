package MidtermTesting;

public class InsertionSort {
	
	
	public int[] InsertionSort(int[]list)
	{
		int i,j,key,temp;
		for(i=1;i<list.length;i++)
		{
			key=list[i];
			j=i-1;
			while(j>=0 && key<list[j])
			{
				temp=list[j];
				list[j]=list[j+1];
				list[j+1]=temp;
				j--;
			}
			
		}
		return list;
	}
	
	public static void main(String [] args)
	{
		int [] list = {2,4,5,62,3,24,69,36};
		InsertionSort obj = new InsertionSort();
		obj.InsertionSort(list);
		obj.print(list);
		
	}
	
	public void print(int[] list)
	{
		for(int i=0; i<list.length;i++)
		{
			System.out.print(list[i]+" ");
		}
	}

}
