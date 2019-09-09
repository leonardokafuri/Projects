import java.util.Scanner;
public class TryToParseDouble
{
   public static void main (String[] args)
   {
      Scanner input = new Scanner(System.in);
      String s;
      double p; 
      try
      {
         System.out.print("Please enter a double number >> ");
         s = input.nextLine();
         p = Double.parseDouble(s);
         System.out.println(p);
      }catch(NumberFormatException num)
       {
         p=0;
         System.out.println(p);
         System.out.println("Sorry, input was not a number");
       }
    }
   
   }


