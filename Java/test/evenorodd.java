package test;
import java.util.Scanner;
public class evenorodd {
	   public static void main(String args[])
	   {
	      int x;
	      System.out.println("Enter an integer to check if it is odd or even");
	      Scanner in = new Scanner(System.in);
	      x = in.nextInt();
	      int f =0;
	     
	      if (x % 2 == 0) {
	         System.out.println("The number is even.");
	      		System.out.println(f);}
	      else
	         System.out.println("The number is odd.");
	   }
}
