package test;
import java.util.*;
public class Question18a {

	public static void power1(int x, int y)
	{
		if(y>=0)
		{
			int result = 1;
		    for (int i = 0; i < y; i++)
		    { result *= x;
		    }
		System.out.println(x+" to the power of "+ y + " is : "+ result );
		}
		else
		{
			System.out.println("Invalid number");
		}
	}
	
	public static void main(String[] args) {
		int x,y;
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter a value : ");
		x=scan.nextInt();
		System.out.print("Enter a power a : ");
		y=scan.nextInt();
		power1(x,y);
	}

}
