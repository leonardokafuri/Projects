import java.util.logging.Level;
import java.util.logging.Logger;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
public class createCollection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Turn off log message
		Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
		mongoLogger.setLevel(Level.SEVERE);
		
		// create a MongoDB connection URI 
		String dbURI = "mongodb://test:csis3300@35.247.6.64:27017/testDB";
		
		//create a MongoDB client
		MongoClient mongo = new MongoClient(new MongoClientURI(dbURI));
		
		// Access the database 
		MongoDatabase db = mongo.getDatabase("testDB");
		
		//create a collection 
		//db.createCollection("inventory"); //after is inserted once comment this out
		
		//retrieve the collection 
		MongoCollection<Document> collection = db.getCollection("inventory");
		
		//insert one document to the collection 
		Document document = new Document("item","canvas")
								 .append("qty", 100)
								 .append("size", new Document("h",28).append("w", 35.5).append("uom", "cm"))
								 .append("status", "A");
		
		collection.insertOne(document); // after inserted once comment this out to only display the data
		
		// Find the documents in the collection 
		MongoCursor<Document> cursor = collection.find().iterator();
		
		try {
			while(cursor.hasNext())
			{
				System.out.println(cursor.next().toJson());
			}
			
		}finally {
			cursor.close();
		}

	}

}
