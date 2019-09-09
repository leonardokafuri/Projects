package test;

import java.util.Scanner;
public class Question18c {
	public static int power3(int x, int y)
	{	
		if ( y == 0 ) {
	        return 1;
	    }
	    if(y % 2 == 0 ){
	        // even y
	    	return power3( x, y/2 ) * power3( x, y/2 );
	    } else{
	        // odd y
	    	return x *( power3( x, y/2 ) * power3(x, y/2 ));
	    }
	}
	public static void main(String[] args) {
		int x,y,answer;
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter a value : ");
		x=scan.nextInt();
		System.out.print("Enter a power : ");
		y=scan.nextInt();
		answer = power3(x,y);
		System.out.println(answer);
	}
}
