import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class ImportJson {
	
	public static void main (String[] args)
	{
		// Turn off log message
				Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
				mongoLogger.setLevel(Level.SEVERE);
				
				//Create a MongoDB connection URI
				String dbURI="mongodb://test:csis3300@35.247.6.64:27017/testDB"; // the ip address will change every time we run the server 
				
				//create a MongoDB client 
				MongoClient mongo = new MongoClient(new MongoClientURI(dbURI));
				
				// Access the database 
				MongoDatabase db = mongo.getDatabase("testDB");
				
				//retrieve the collection 
				MongoCollection<Document> collection = db.getCollection("inventory");
				
		//create a string to store the content reading from the file 
		String content = null;
		try
		{
			content = new String(Files.readAllBytes(Paths.get("src/inventory.txt")));
			
		}catch (IOException e)
		{
			e.printStackTrace();
		}
		
		String [] lines = content.split(System.getProperty("line.separator"));
		List<Document> documents = new ArrayList<Document>();
		
		//add each records to documents list
		for(String line:lines)
		{
			documents.add(Document.parse(line));
		}
		
		collection.insertMany(documents);
		
		MongoCursor<Document> cursor = collection.find().iterator();
		
		try {
			while(cursor.hasNext())
			{
				System.out.println(cursor.next().toJson());
			}
			
		}finally {
			cursor.close();
		}
		
		//close 
		mongo.close();

	}
	

}
