public abstract class Loan implements LoanConstants
{
   private int LoanNumber;
   private  String CustomerLName; 
   private  double amountLoan;
   protected double rate;
   private int term;
   
   //constructor that requires all types of data except rate 
   public void Loan(int LoanNumber, String CustomerLName, double amountLoan, int term)
   {
      this.LoanNumber = LoanNumber;
      this.CustomerLName = CustomerLName;
      this.amountLoan= amountLoan;
      this.term=term;
      if(amountLoan > MaxLoanAmount)
      {
         System.out.println("We do not offer Loans grater than 100,000");
      }
      else if(term == 3)
      {
         this.term = MediumTerm;
      }
      else if(term ==5)
      {
         this.term = LongTerm;
      }
      else
      {
         this.term = ShortTerm;
      }
   }

   public abstract void setrate(double r);


   public String toString()
   {
      return "Loan#"+ LoanNumber + " Name: " + CustomerLName + " $" + amountLoan + " for " + term + " year(s)" + " at " + rate + "% interest" ; 
   }

}