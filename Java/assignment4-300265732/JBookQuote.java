import javax.swing.*;
import java.awt.*;
class JBookQuote extends JFrame
{           
   public JBookQuote()
   {
      super("Book Quote"); // title 
      setLayout(new FlowLayout());   
      JLabel quote1  = new JLabel("It takes a great deal of bravery to stand up to our enemies, but just as much to stand up to our friends");
      JLabel quote2  = new JLabel("If you want to know what a man is like, take a good look at how he treats his inferiors, not his equals"); 
      add(quote1);// adding quote to the JFrame 
      add(quote2);
   }
  

   public static void main( String [] args)
   {
    JBookQuote frame = new JBookQuote();
     frame.setSize(800,250);
     frame.setVisible(true);// displaying the JFrame
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

}