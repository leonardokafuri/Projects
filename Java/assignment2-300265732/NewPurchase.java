class NewPurchase
{

   private int InvoiceNum;
   private double AmountSale;
   double SalesTax = 0.05;// sales tax is 5% 
   
    public void setInvoice(int ivcn) 
   {
      InvoiceNum = ivcn;
   
   } 
   
   public void setAmountSale (double amts)
   {
      AmountSale = amts; 
      // calculate the sales tax 
      double x; 
      x = amts * SalesTax;
      amts = amts + x; // add the sales tax with the amount to give a total price
   }
   
   
   public int getInvoice()
   {
      return InvoiceNum;
   }
   
   public double getAmountSale()
   {
      return AmountSale;
   }


   void displaySalesInfo(int a , double b)
   {
      System.out.println("The sale amount is >> " + b );
      System.out.println("The invoice number is >> " + a );
   }



}