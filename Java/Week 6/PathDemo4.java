import java.nio.file.*;
import java.io.IOException;
public class PathDemo4
{
   public static void main(String[] args)
   {
      
      Path filePath =
         Paths.get("E:\\Java\\2\\Week 6\\PathDemo.class");
      try
      {
         Files.delete(filePath);
         System.out.println("File or directory is deleted");
      } 
      catch (NoSuchFileException e)
      {
         System.out.println("No such file or Directory");
      } 
      catch(DirectoryNotEmptyException e)
      {
         System.out.println("Directory is not empty");
      }  
      catch (SecurityException e)
      {
         System.out.println("No permission to delete");
      }  
      catch (IOException e)
      {
         System.out.println("IO Exception");
      }   

   }

}