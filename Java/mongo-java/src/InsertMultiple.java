import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class InsertMultiple {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
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
		
		// the main part : insert multiple documents 
		//first create 2 documents 
		Document document2 = new Document("item","journal")
				 .append("qty", 25)
				 .append("size", new Document("h",14).append("w", 21).append("uom", "cm"))
				 .append("status", "A");
		
		Document document3 = new Document("item","mat")
				 .append("qty", 95)
				 .append("size", new Document("h",27.9).append("w", 35.5).append("uom", "cm"))
				 .append("status", "A");
		
		// create a document list to store multiple documents 
		
		List<Document> documents = new ArrayList<Document>();
		
		//Add the documents to the list 
		documents.add(document2);
		documents.add(document3);
		
		// Call the inserMany() method to insert 
		collection.insertMany(documents); //after you ran it once comment it out so it wont be adding repeated data 
		
		//display the documents in the collection 
		
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
