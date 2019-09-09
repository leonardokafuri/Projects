import java.util.Scanner;
public class EnteringIntegers
{
   public static void main(String[]args)
   {
      int [] num = { 0,0,0,0,0,0};
      int x;
      Scanner input = new Scanner(System.in);
      for(x=0; x<num.length; x++)
      {
         try
         {
            System.out.print("Enter an interger >> ");
            num[x]= input.nextInt();
         
         }catch(Exception e)
         {
             System.out.println("exception occured");
         }
         input.nextLine();
     
      }
      System.out.print("The numbers are : ");
      for (x=0; x<num.length; x++)
      {  
         System.out.print(num[x]);
      }
   
   }
   


}