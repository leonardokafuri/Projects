import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class JVacationRental extends JFrame implements ItemListener
{
   JCheckBox Parkside = new JCheckBox("Parkside" , false);
   JCheckBox Poolside = new JCheckBox("Poolside" , false);
   JCheckBox Lakeside = new JCheckBox("Lakeside" , false);// checkboxes for side selection
   
   JCheckBox onebed = new JCheckBox("1 bedroom" , false);
   JCheckBox twobed = new JCheckBox("2 bedroom" , false);
   JCheckBox threebed = new JCheckBox("3 bedroom" , false); // checkboxes for bedrooms selection
   
   JCheckBox NoMeal = new JCheckBox("No Meal" , false);
   JCheckBox Meal = new JCheckBox("Meal included" , false);// checkboxes for meal selection
   
   
   JTextField Price = new JTextField(10);// TextField that will display the price
   
   
   ButtonGroup side = new ButtonGroup(); 
   ButtonGroup bed = new ButtonGroup();
   ButtonGroup meal = new ButtonGroup(); // creating button groups for sides, bedrooms and meal  
   
   public JVacationRental()
   {
      super("Vacation Rentals"); // tile for the JFrame 
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// if user presses X exit the application
      setLayout(new FlowLayout());
      
      Parkside.addItemListener(this);
      Poolside.addItemListener(this);
      Lakeside.addItemListener(this);
      onebed.addItemListener(this);
      twobed.addItemListener(this);
      threebed.addItemListener(this);
      NoMeal.addItemListener(this);
      Meal.addItemListener(this); // adding all checkboxes with ItemListeners
      
      add(Parkside);
      add(Poolside);
      add(Lakeside);
      add(onebed);
      add(twobed);
      add(threebed);
      add(NoMeal);
      add(Meal);
      add(Price); // adding checkboxes and textfield to the frame 
      
      side.add(Parkside);
      side.add(Poolside);
      side.add(Lakeside);// adding the sides to a button group
      
      
      bed.add(onebed);
      bed.add(twobed);
      bed.add(threebed); // adding the type of bedrooms to a button group 
      
      meal.add(NoMeal);
      meal.add(Meal); // adding the meal type to a button group 
      
     }
   @Override
   public void itemStateChanged(ItemEvent check)
   {
      Object source = check.getItem();
      int LocPrice;// holds the location price 
      int BedPrice; //holds the bedroom price
      int mealPrice = 200; // meal price will add 200 dollars to the rental 
      if(source == onebed)
      {
         if(Parkside.isSelected())// if parkside is selected when the user clicks on one bedroom 
         { 
           LocPrice = 600; // set the location price to 600 
            String total = "$" + LocPrice;
            Price.setText(total); // print on the textfield the total price  
            if(Meal.isSelected())// if user also selects meal add 200 to value and print the value again on textfield 
            {
               LocPrice = LocPrice + mealPrice;
               String totalWithMeal = "$" + LocPrice;
               Price.setText(totalWithMeal);  // used the same logic for the other types of location just chaging the price for each
            }
         }else if(Poolside.isSelected())
         { 
            LocPrice = 750;
            String total = "$" + LocPrice;
            Price.setText(total);
            if(Meal.isSelected())
            {
               LocPrice = LocPrice + mealPrice;
               String totalWithMeal = "$" + LocPrice;
               Price.setText(totalWithMeal); 
            }  
         }else if(Lakeside.isSelected())
         { 
            LocPrice = 825;
            String total = "$" + LocPrice;
            Price.setText(total); 
            if(Meal.isSelected())
            {
               LocPrice = LocPrice + mealPrice;
               String totalWithMeal = "$" + LocPrice;
               Price.setText(totalWithMeal); 
            } 
         }      
      }
       else if(source == twobed)
      {
         if(Parkside.isSelected())
         { 
           LocPrice = 600 +75;// if users selects two bedrooms add 75 to the regular rental price 
            String total1 = "$" + LocPrice; // and I used the again the same logic for each location 
            Price.setText(total1);
            if(Meal.isSelected())
            {
               LocPrice = LocPrice + mealPrice;
               String totalWithMeal = "$" + LocPrice;
               Price.setText(totalWithMeal); 
            }  
         }else if(Poolside.isSelected())
         { 
            LocPrice = 750 + 75;
            String total = "$" + LocPrice;
            Price.setText(total); 
            if(Meal.isSelected())
            {
               LocPrice = LocPrice + mealPrice;
               String totalWithMeal = "$" + LocPrice;
               Price.setText(totalWithMeal); 
            } 
         }else if(Lakeside.isSelected())
         { 
            LocPrice = 825 + 75;
            String total = "$" + LocPrice;
            Price.setText(total); 
            if(Meal.isSelected())
            {
               LocPrice = LocPrice + mealPrice;
               String totalWithMeal = "$" + LocPrice;
               Price.setText(totalWithMeal); 
            } 
         }      
      }
      else if(source == threebed)
      {
         if(Parkside.isSelected())
         { 
           LocPrice = 600 +150; // if user selcts 3 bedrooms adds 75 on top of the 1st 75. which means it would cost 150 more than an 1bedroom
            String total1 = "$" + LocPrice;// and again used the same logic to define the values of for each location 
            Price.setText(total1); 
            if(Meal.isSelected())
            {
               LocPrice = LocPrice + mealPrice;
               String totalWithMeal = "$" + LocPrice;
               Price.setText(totalWithMeal); 
            } 
         }else if(Poolside.isSelected())
         { 
            LocPrice = 750 + 150;
            String total = "$" + LocPrice;
            Price.setText(total); 
            if(Meal.isSelected())
            {
               LocPrice = LocPrice + mealPrice;
               String totalWithMeal = "$" + LocPrice;
               Price.setText(totalWithMeal); 
            } 
         }else if(Lakeside.isSelected())
         { 
            LocPrice = 825 + 150;
            String total = "$" + LocPrice;
            Price.setText(total); 
            if(Meal.isSelected())
            {
               LocPrice = LocPrice + mealPrice;
               String totalWithMeal = "$" + LocPrice;
               Price.setText(totalWithMeal); 
            } 
         }      
      }   
     
   }
   public static void main (String [] args)
   {
      final int w = 750;
      final int h = 120;
      JVacationRental frame = new JVacationRental(); // creating an object for the frame so it can be loaded
      frame.setSize(w,h);
      frame.setVisible(true); // always make sure the frame is visible 
   
   }

}