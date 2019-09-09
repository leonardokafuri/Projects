package MidtermTesting;

public class BubbleSort {
	
	public int [] bubblesort (int [] list)
	{
		int i ,j ,temp;
		for(i=0;i<list.length-1;i++)
		{
			for(j=0;j<list.length-1-i;j++)
			{
				if(list[j]>list[j+1])
				{
					temp= list[j+1];
					list[j+1]=list[j];
					list[j]=temp;
				}
			}
			
		}
		return list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] list = {5,3,2,6,7,8,20};
		BubbleSort obj = new BubbleSort();
		obj.bubblesort(list);
		obj.print(list);
		

	}
	
	public void print(int [] list)
	{
		for(int i=0;i<list.length; i++)
			System.out.print(list[i]+" ");
	}


}
