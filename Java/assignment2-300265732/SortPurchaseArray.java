import java.util.*;
class SortPurchaseArray
{
 public static void main (String[] args)
 {
      NewPurchase [] newp = new NewPurchase [5]; //array of 5 objects of newPurchase  to hold values of invoices
      NewPurchase [] newp2 = new NewPurchase [5]; // array of 5 objects of newPurchase to hold values for sales amount
      Scanner input = new Scanner(System.in);
      
      int a; 
      double b;
   
     for(int i = 0; i < newp.length; i++)
    {
       System.out.print("Please enter you contract number  or -1 to stop >> ");
       a = input.nextInt();
       if ( a == -1) // sentinel value
          {
            break;
          }

       if (a >= 1000 && a <= 8000)
       {
         
         System.out.println("Your contract number is valid");
       }
        else 
       {
         a=0;// resets the value entered an only stores new value entered for the array
         System.out.print("Please enter a contract number between 1000 and 8000 or -1 to quit >>");
         a= input.nextInt(); // makes user input the correct value and it wont close the program if the wrong value is entered
        if ( a == -1) // sentinel value
          {
            break;
          }

         
       } 
          newp[i] = new NewPurchase(); 
          newp[i].setInvoice(a);

    }
    
     for(int p = 0; p < newp2.length; p++)
     {
      System.out.print("Please enter the sale amount or -1 to stop >> ");
      b = input.nextDouble();
      newp2[p] = new NewPurchase(); 
      if ( b == -1) // sentinel value
          {
            break;
          }

      if (b<0)
      {
         b=0;
         System.out.print("Please enter a positive sale amount  or -1 to stop >> ");
         b= input.nextDouble(); // makes user input the correct value and it wont close the program if the wrong value is entered
         newp2[p].setAmountSale(b);
      }
      else
       {
       newp2[p].setAmountSale(b);
       }
     }
     
     
     
    char sort;
    System.out.print("To be sorted by invoice number order type 'i' or type 's' to be sorted by sale amount order : ");
    sort = input.next().charAt(0); 
     if(sort == 'i')
     {//bubblesort the array
      for(int i = 1;i<newp.length; i++)
      {
        for (int j=0; j<newp.length-i; j++)
         {
            String ivc = Integer.toString(newp[j].getInvoice());// convert int into a string so it can be compared and sorted 
            String ivc1 = Integer.toString(newp[j+1].getInvoice());
            if (ivc.compareTo(ivc1) >0)
            {
               NewPurchase k=newp[j];// Making j as an element of the array
               newp[j]= newp[j+1];
               newp[j+1] = k;

            }
         }
  
      }
      
      for (int w=0; w<newp.length; w++)
          {//print the array sorted
              System.out.println("The invoice number is >> " + newp[w].getInvoice());
          }


      // System.out.println ("The invoice number is >> " + newp[i].getInvoice());
      //System.out.println ("The Sale amount is >> " + newp2[u].getAmountSale());
      
     }else if (sort == 's')
     {//bubblesort the array
     int e;
     for(int u = 0; u<newp2.length; u++)
      {
         for (e=0; e<newp2.length-1; e++)
         {
            String amts = Double.toString(newp2[e].getAmountSale()); // convert double into a string so it can be compared and sorted 
            String amts2 = Double.toString(newp2[e+1].getAmountSale());
          if (amts.compareTo(amts2) >0)
            {
               NewPurchase h=newp2[e];// Making h as an element of the array
               newp2[e]= newp2[e+1];
               newp2[e+1] = h;
            }
         }
         
      }
      
      for (int d=0; d<newp2.length; d++)
          {
            //print the array sorted
              System.out.println("The sale amount is  number is >> $" + newp2[d].getAmountSale());
          }

     
     }else 
     {
      System.out.print("Please enter 'i' or 's'");
      sort = input.next().charAt(0);
     }

       
 }

}