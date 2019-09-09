import javax.swing.*;
public class CreateLoans
{
   public static void main (String[] args)
   {
      Loan[] newloan = new Loan [5];
      double primerate; // prime interest rate 
      String input;
      input=JOptionPane.showInputDialog(null,"Welcome to Sanchez Construction\nEnter the current prime interet reate as a decimal number");
      primerate = Double.parseDouble(input);
      String acttype, acctNum, name, loanAmount,term;
      for(int x=0; x<newloan.length; x++)
      {
         
         acttype=JOptionPane.showInputDialog(null, "Is this a (1) bussiness loan or (2) Personal Loan?");
         int a = Integer.parseInt(acttype);
         if(a ==1)
         {
            newloan[x] = new BusinessLoan();
            newloan[x].setrate(primerate);
         }else if(a == 2)
         {
            newloan[x] = new PersonalLoan();
            newloan[x].setrate(primerate);
         }
         acctNum=JOptionPane.showInputDialog(null, "Enter account number");
         int b = Integer.parseInt(acctNum);
         name=JOptionPane.showInputDialog(null,"Enter name");
         loanAmount = JOptionPane.showInputDialog(null, "Enter Loan amount");
         double c = Double.parseDouble(loanAmount);
         term =JOptionPane.showInputDialog(null,"Enter term");
         int d = Integer.parseInt(term);
         newloan[x].Loan(b,name,c,d);
         
      }
      
      
     // display all the information once all data is entered 
        JFrame frame = new JFrame("Message");
        JOptionPane.showMessageDialog(frame, new JList(newloan));
           
      
   
   }


}