package test;
import java.lang.Math;
public class Question12 {
	
	public static int search (int a, int b, int n) 
	{
		int returnvalue;
		int mid=(a+b)/2;
		System.out.printf("Enter a = %2d, b = %2d, mid = %2d\n",a,b,mid);
		
		if((mid*mid<=n) && (n<(mid+1)*(mid+1)))
		{
			returnvalue= mid;
		}
		else if(mid*mid >n)
		{
			returnvalue=search(a,mid-1,n);
		}
		else
		{
			returnvalue=search(mid+1,b,n);
		}//end if
		System.out.printf("Leave a = %2d, b = %2d, mid = %2d \n",a,b,mid);
		return returnvalue;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n= 25;
		/*do
		{
			System.out.printf("For n = %2d, the result is %d\n",n,search(1,n,n));
			 //System.out.println(Math.sqrt(n)); 
			n++;
		}while(n<=100.00);*/
		
		
		
		System.out.printf("For n = %2d, the result is %d\n",n,search(1,n,n));


	}

}
