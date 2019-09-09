class Purchase 
{
   private int InvoiceNum;
   private double AmountSale;
   double SalesTax = 0.05;// sales tax is 5% 
   
    public int setInvoice(int ivcn) 
   {
      InvoiceNum = ivcn;
      return ivcn;
   
   } 
   
   public double setAmountSale (double amts)
   {
      AmountSale = amts; 
      double x; 
      x = amts * SalesTax;
      amts = amts + x; 
      System.out.println("Sales tax is : $" + x);
      return amts;
      
   
   }
   
    void displaySalesInfo(int a , double b)
   {
      System.out.println("The sale amount is >> $" + b );
      System.out.println("The invoice number is >> " + a );
   }
   
   
      

}