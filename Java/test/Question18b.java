package test;

import java.util.Scanner;
public class Question18b {
	
	public static int power2(int x,int y)
	{
		int result =0;
		if(y == 0)
		{
			return 1;
		}else 
		{
		if(y>0) 
		   return  result = x * power2(x,y-1);
		else 
			return -1;
		}
	}

	public static void main(String[] args) {
		int x ,y,answer;
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter a value : ");
		x=scan.nextInt();
		System.out.print("Enter a power : ");
		y=scan.nextInt();
		answer = power2(x,y);
		if(answer == -1)
		System.out.print("Invalid entry");
		else
		System.out.print(answer);
	}
}
