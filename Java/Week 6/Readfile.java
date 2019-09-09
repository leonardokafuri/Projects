import java.nio.file.*;
import java.io.*;
public class Readfile
{

   public static void main(String[] args)
   {
      Path file = Paths.get("E:\\Java\\2\\Week 6\\test.txt");
      InputStream input = null;
      try 
      {
         input = Files.newInputStream(file);
         BufferedReader reader = new BufferedReader(new InputStreamReader(input));
         String s = null;
         s = reader.readLine();
         System.out.println(s);
         input.close();
       }
       catch (IOException e)
       {
          System.out.println(e);
       }
   }

}