import java.util.Scanner;
public class PriceListApplication
{
   public static void main(String[] args) {
   double[] price = {15.99, 27.88, 34.56, 45.89};
   int item;
      Scanner input = new Scanner(System.in);
      System.out.print("Enter item number >> ");
      item = input.nextInt();
      try
      {
         displayPrice(price, item);
      }
      catch(IndexOutOfBoundsException e)
      {
         System.out.println("Price is $0");
      }
   }
   public static void displayPrice(double [] price,int item) throws IndexOutOfBoundsException
   {
      System.out.println("The price is $" + price[item]);
   }
}
