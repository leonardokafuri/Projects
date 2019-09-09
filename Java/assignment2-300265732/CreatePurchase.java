import java.util.*;
class CreatePurchase
{
        
     public static void PromptUserInfo()
    {
      Purchase pchs = new Purchase(); // declare purchase as an obj
    
      int x =0; // x has to be between 1000 and 8000 
      Scanner input = new Scanner(System.in); // enter user data
      System.out.print("Please enter you contract number >> ");
      x = input.nextInt();
      pchs.setInvoice(x);
      if (x >= 1000 && x <= 8000)
      {
         System.out.println("Your contract number is valid");
         
      }
      else 
      {
         System.out.print("Please enter a contract number between 1000 and 8000 >>");
          x = input.nextInt(); // makes user input the correct value and it wont close the program if the wrong value is entered         
      }      
     
      
      double y = 0; 
      System.out.print("Please enter the sale amount >> ");
      y = input.nextDouble();
      if (y<0)
      {
         y =0;
         System.out.print("Please enter a positive sale amount >> ");
         y = input.nextDouble(); // makes user input the correct value and it wont close the program if the wrong value is entered
         pchs.setAmountSale(y);
      }
      else
       {
       pchs.setAmountSale(y);
       }
      
       pchs.displaySalesInfo(x,y);
      
    }
    
   public static void main (String[] args)
   {
         PromptUserInfo();
   }
    

}