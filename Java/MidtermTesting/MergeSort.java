package MidtermTesting;

public class MergeSort {
	
	public void mergesort (int [] list, int low,int high)
	{
		if(high==low)
		{
			return;
		}else
		{
			int mid = (high+low)/2;
			mergesort(list,low,mid);
			mergesort(list,mid+1,high);
			merge(list,low,mid,high);
		}
	}
	public void merge(int [] list, int low ,int mid,int high)
	{
		int[] L = new int [mid-low+2];
		for(int i = low; i<=mid;i++)
		{
			L[i-low]=list[i];
		}
		L[mid-low+1]=Integer.MAX_VALUE;
		
		int [] R = new int [high-mid+1];
		for(int i=mid+1;i<=high;i++)
		{
			R[i-mid-1]=list[i];
		}
		R[high-mid]=Integer.MAX_VALUE;
		
		int i=0,j=0;
		
		for(int k=low;k<=high;k++)
		{
			if(L[i]<R[j])
			{
				list[k]=L[i];
				i++;
			}else
			{
				list[k]=R[j];
				j++;
			}
			
		}
	}
	
	public void print(int [] list)
	{
		for(int i =0; i<list.length;i++)
		{
			System.out.print(list[i]+" ");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] list = {2,4,5,6,7,3,9,22,42,69};
		MergeSort obj = new MergeSort();
		obj.mergesort(list, 0, list.length-1);
		obj.print(list);

	}

}
