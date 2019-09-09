public class CustomerAccount
{
   private int acctNum; 
   private double balance;
   public static double HIGH_CREDIT_LIMIT = 2000.00;
   public CustomerAccount(int num, double bal) throws HighBlanceException
   {  
      acctNum= num;
      balance = bal;
      if(balance>HIGH_CREDIT_LIMIT)
      throw(new HighBlanceException());
      
      
   }

}