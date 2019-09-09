import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
class JBookQuote2 extends JFrame implements ActionListener
{ 
    JLabel quote1  = new JLabel("It takes a great deal of bravery to stand up to our enemies, but just as much to stand up to our friends");
    JLabel quote2  = new JLabel("If you want to know what a man is like, take a good look at how he treats his inferiors, not his equals"); 
    JButton Book1 = new JButton("Title for Book 1");
    JButton Book2 = new JButton("Title for Book 2"); //Creating a button for each Book Title 
    JLabel  BookName = new JLabel("  ");         
   public JBookQuote2()
   {
      super("Book Quote2");  
      setLayout(new FlowLayout());   
      add(quote1);
      add(Book1);
      add(quote2);
      add(Book2); //Adding buttons to the frame right after each quote
      Book1.addActionListener(this);
      Book2.addActionListener(this);
      add(BookName); // add a Label at the bottom of the quotes that will display the book name
      
   }
    @Override
   public void actionPerformed(ActionEvent e)
   {
      Object source = e.getSource();
      if(source == Book1)
      {
         BookName.setText("Harry Potter and the Sorcerer's Stone"); // if user selects the 1 button dislpay on the label the 1st title
      
      }else if(source == Book2)
      {
         BookName.setText("Harry Potter and the Goblet of Fire"); // display 2nd title on the label 
      }
   
   }
   public static void main( String [] args)
   {
    JBookQuote2 frame = new JBookQuote2();
     frame.setSize(750,250);
     frame.setVisible(true);
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

}