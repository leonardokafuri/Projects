public class BusinessLoan extends Loan
{
   @Override
   public void setrate (double r)
   {
     double frate;
     frate = r * 100 + 1;
     rate = frate;
   } 


}