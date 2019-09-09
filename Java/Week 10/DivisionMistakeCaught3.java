import java.util.Scanner;
import java.util.InputMismatchException;
public class DivisionMistakeCaught3
{
    public static void main (String[] args)
   {
      Scanner input = new Scanner(System.in);
      int numerator, denominator, result;
      try
      {
         System.out.print("Enter numerator >> ");
         numerator= input.nextInt();
         System.out.print("Enter denominator >> ");
         denominator = input.nextInt();
         result = numerator/denominator;
         System.out.println(numerator + "/" + denominator + " = " + result);
      }      
      
      catch(ArithmeticException e)
      {
         System.out.println(e.getMessage());
      }
     catch(InputMismatchException e)
      {
         System.out.println("Wrong data type");
      }
      System.out.println("end of program");
   }
   
}