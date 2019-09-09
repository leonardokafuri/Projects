import java.util.Scanner;
public class DivisionMistakeCaught
{
    public static void main (String[] args)
   {
      Scanner input = new Scanner(System.in);
      int numerator, denominator, result;
      System.out.print("Enter numerator >> ");
      numerator= input.nextInt();
      System.out.print("Enter denominator >> ");
      denominator = input.nextInt();
      try
      {
         result = numerator/denominator;
         System.out.println(numerator + "/" + denominator + " = " + result);
      } catch(ArithmeticException mistake)
      {
      // System.out.println("Arithmetic exception has been caught and thrown");
         System.out.println( mistake.getMessage()); // built in message in the exection class 
      }
      System.out.println("End of program");
   }
      
}


