package MidtermTesting;

public class SelectionSort {

	public int [] SelectionSort (int [] list )
	{
		int i,j,minvalue,minindex,temp;
		for(i=0;i<list.length;i++)
		{
			minvalue=list[i];
			minindex=i;
			for(j=i;j<list.length;j++)
			{
				if(list[j]<minvalue)
				{
					minvalue=list[j];
					minindex=j;
				}
			}
			
			if(list[i]>minvalue)
			{
				temp=list[i];
				list[i]=list[minindex];
				list[minindex]=temp;
			}
		}
		return list;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] list = {5,3,2,6,7,8,20};
		SelectionSort obj = new SelectionSort();
		obj.SelectionSort(list);
		obj.print(list);
		

	}
	
	public void print(int [] list)
	{
		for(int i=0;i<list.length; i++)
			System.out.print(list[i]+" ");
	}

}
