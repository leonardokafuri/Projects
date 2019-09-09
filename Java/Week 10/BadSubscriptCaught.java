import java.util.Scanner;
public class BadSubscriptCaught
{
    public static void main (String[] args)
   {
      int [] students = { 100,101,102,103,104,105,106,107};
      int x;
      Scanner input = new Scanner(System.in);
      try
         {
           System.out.print("Enter an index >> ");
           x= input.nextInt();
          System.out.print(students[x]);
         }catch(ArrayIndexOutOfBoundsException mistake)
         {
            System.out.println("invalid index value");
         }


   
   
   }
   
   
}