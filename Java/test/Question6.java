package test;

public class Question6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		countDownByTwo(2);

	}
	public static void countDownByTwo(int n)
	{
		if(n>=0)
		{
			System.out.println(n+" ");
			countDownByTwo(n-2);
		}//end if
	}//end countDownByTwo

}
