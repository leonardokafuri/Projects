package test;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(factorial(10));
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Your name :");
		String a= scan.nextLine();
		System.out.println("Your name is : "+ a);
		System.out.println("***** program ended ******");

	}
	
	public static int factorial (int n)
	{
		if(n==1)
		{
			return 1;
		}else 
		{
			return n*factorial(n-1);
		}
	}

}
