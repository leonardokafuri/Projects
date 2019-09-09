public class OrderMessages 
{
   String[] OrderMessages = {"Message is : Item does not exist", " Message is : Quantity is too high" , " Message is : Item number is too high" , "Message is: Item number is too low", " Message is : Quantity is too low" };
   private int ItemNum; 
   private double quantity;
   double price, total;
public OrderMessages(int ItemNum, double quantity) throws OrderException
 {
      this.ItemNum= ItemNum;
      this.quantity=quantity;
      if(ItemNum > 9999)
      {
         throw (new OrderException(OrderMessages[2]));
      }
      else if(ItemNum < 0)
      {
         throw (new OrderException(OrderMessages[3]));
      }
      else if(quantity >12)
      {
       throw (new OrderException(OrderMessages[1]));
      } else if(quantity < 1)
      {
         throw (new OrderException(OrderMessages[4]));
      }else if(ItemNum==111)
      {
          price=0.89;
          total = price * quantity;
          System.out.println("Order OK. Total is $" + total);
          System.out.println(" " + "(" + quantity + " at $" + price + "each)");

      }else if(ItemNum==222)
      {
            price=1.47;
            total = price * quantity;
            System.out.println("Order OK. Total is $" + total);
            System.out.println(" " + "(" + quantity + " at $" + price + "each)");
       }else if(ItemNum==333)
       {
            price=2.43;
            total = price * quantity;
            System.out.println("Order OK. Total is $" + total);
            System.out.println(" " + "(" + quantity + " at $" + price + "each)");
       }else if(ItemNum==444)
       {
            price=5.99;
            total = price * quantity;
            System.out.println("Order OK. Total is $" + total);
            System.out.println(" " + "(" + quantity + " at $" + price + "each)");
        }else
        {
            throw (new OrderException(OrderMessages[0]));
        }
   
  }
}