import java.util.Scanner;
import java.util.InputMismatchException;
public class PlaceAnOrder
{
 public static void main (String[] args)
   {
      int item;
      double qty;
      Scanner input = new Scanner(System.in);
    try
    { 
      System.out.print("Enter item number ");
      item = input.nextInt();
      System.out.print("Enter quantity ");
      qty=input.nextDouble();
   
      OrderMessages oe = new OrderMessages(item, qty);
    }catch(OrderException om)
    {
     System.out.println(om.getMessage());
    }catch(InputMismatchException e)
    {
      System.out.println("Message is : null");
    }
   }  
}