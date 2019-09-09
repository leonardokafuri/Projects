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
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Projections.*;

public class MongoQuery {

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
		
		//display the documents in the collection based on some conditions 
		// do a query 
		//MongoCursor<Document> cursor = collection.find(Filters.gte("qty",75)).iterator();
		
		// we can also do projections 
		MongoCursor<Document> cursor =
					collection.find(Filters.gte("qty",75)).projection(fields(include("item","qty"), excludeId())).iterator();
		
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
