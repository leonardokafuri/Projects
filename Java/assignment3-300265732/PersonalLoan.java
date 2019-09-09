public class PersonalLoan extends Loan
{
   @Override
   public void setrate (double r)
   {
     double frate;
     frate = r * 100 + 2;
     rate = frate;
   } 
   
}