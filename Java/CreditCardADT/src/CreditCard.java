/*
 * Name: Leonardo Kafuri
 * Student ID: 300265732
 * Assignment 2 Chapter 4 question 6
 */
import java.util.Scanner;
import java.util.Random;
class ADTCreditCard
{
	private String CustomerName;
	private int act;
	private String duedate;
	private int rewards;
	private double actBal; // setting string and int to hold the values for the account  
	Scanner scan = new Scanner(System.in);
	int menu =0;//menu selection
	
	public String getCustomerName() //get for customer name
	{
		return CustomerName;
	}
	
	public int getAct() // get for account number
	{
		return act;
	}
	
	public String getDueDate() // get for due date
	{
		return duedate;
	}
	
	public int getRewards() // get for rewards
	{
		return rewards;
	}
	
	public double getActBal() // get for balance
	{
		return actBal;
	}
	
	public void SetCardInfo(String name, int act, String duedate, int rewards, double actBal ) // this function will generate the credit card info
	{
		this.CustomerName=name;
		this.act=act;
		this.duedate=duedate;
		this.rewards=rewards;
		this.actBal=actBal;
	}
	
	public void CardCharge(float amount) // this function will handle the charge of the credit card
	{
		actBal = actBal+amount; //for each charge get previous balance and add with the charge
		int points = (int) amount/2; // the customer will get half of the amount spent in points 
		rewards = rewards+points; // points added into the account
		System.out.println("You have been charged $" + amount + " and you got "+ points + " added into your account \n");

	}
	
	public void CashAdvance(float amount)//this function will handle the cash advance operations
	{
		actBal = actBal + amount; // for each cash advance, get previous balance and add the amount
		int points = (int) amount/3;//for each cash advance they will get 1/3 of the amount in points added to the account 
		rewards = rewards + points;
		System.out.println("You have made a cash advance of $" + amount + " and you got "+points+ " added into your account \n");
	}
	
	public void Payment(float amount) // this function will handle payment operations
	{
		actBal = actBal -amount;//if a payment is made into the account, make the balance of the account minus by how much was paid
		System.out.println("Your current Balance is $:" + actBal+ "\n");
	}
	
	public void interest()//this function will handle the interest into the balance 
	{
		double interestonBal = actBal*0.05; // no specific interest value was asked on the question so i made mine as 5%
		actBal=interestonBal+actBal;//have an interest of 5% on delayed payments 
		System.out.println("An interest of " + interestonBal +" was made into your balance \n");
	}
	
	public void statistics () // this function will handle the display of the account information 
	{
		System.out.println("Account Number: " + act);
		System.out.println("Customer Name: " + CustomerName);
		System.out.println("Rewards Points: " + rewards);
		System.out.println("Account Balance: $" + actBal);
		System.out.println("Due date: " + duedate);
		System.out.println();
		System.out.println("Rewards details: For every credit card charge you recive half of the amount on points,");
		System.out.println("while for every cash advancement you receive a third of the amount in points! \n");
		// i made up some rewards system for the credit card since it wasn't said how the point system was supposed to work
	}
	
	public void Menu() // this function will handle the menu display 
	{
		while(menu!=6) // having 6 as exiting the menu 
		{
			System.out.println("Menu: \n Charge(1)\n CashAdvance(2)\n Payment(3)\n Interst(4)\n Statistics(5)\n Exit Menu(6)");
			menu=scan.nextInt();
			
			switch(menu)// using a switch case to display menu options
			{
			case 1: // if selects charge 
				float amount;
				System.out.print("Enter amount to be charged :");
				amount=scan.nextFloat();
				CardCharge(amount); // charge amount on card
				break;
			case 2:// if selects cash advancement 
				float advanceAmount; 
				System.out.print("Enter amount  to cash Advance :");
				advanceAmount=scan.nextFloat();
				CashAdvance(advanceAmount);
				break;
			case 3: // if selects payment
				float pay;
				System.out.print("Enter amount to be payed :");
				pay=scan.nextFloat();
				Payment(pay);
				break;
			case 4: // if balance will have interest 
				interest();
				break;	
		   case 5: // show statistics of the account
				statistics();
				break;	
			}
		}
	}
}
public class CreditCard {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		ADTCreditCard run = new ADTCreditCard();//creating an credit card object
		System.out.println("Create an account");// ask for user details for creating an account
		System.out.print("Enter your name : ");
		String name = scan.nextLine();
		System.out.print("Enter Your preferred due date on the following format (DD/MM/YYYY) : ");
		String due = scan.nextLine();
		int actN = rand.nextInt(99999); //generating a random number for the account 
		run.SetCardInfo(name,actN,due,0,0); // creating the account
		run.Menu();//running the menu 
	}
}
