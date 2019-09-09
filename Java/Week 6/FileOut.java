import java.nio.file.*;
import java.io.*;
import static java.nio.file.StandardOpenOption.*;
public class FileOut
{
   public static void main(String[] args)
   {
      Path file = 
         Paths.get("E:\\Java\\2\\Week 6\\test.txt");
      String s = "Dadinho e o caralho meu nome agora e ze pequeno porra";
      byte [] data = s.getBytes();
      OutputStream output = null;
      try
      {
         output = new 
            BufferedOutputStream(Files.newOutputStream(file, CREATE));
         output.write(data);
         output.flush();
         output.close();
         System.out.println("File Updated");
      }
      catch(Exception e) 
      {
         System.out.println("Message: " + e);
      
      }
   
   }


}