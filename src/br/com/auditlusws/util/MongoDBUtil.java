package br.com.auditlusws.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoDatabase;

public class MongoDBUtil {
	
	private static MongoDatabase dbFactory;
	
	private static String mongoUser = "admin";
	private static String mongoPassword = "angulus";
	
	  private static MongoDatabase buildDBFactory(Properties prop) {
	        try {
	        	/**** Connect to MongoDB ****/
	        	// Since 2.10.0, uses MongoClient
	        	
	        	String host = prop.getProperty("prop.host");
	        	int port = Integer.parseInt(prop.getProperty("prop.port"));
	        	
	        	String mongoDB = prop.getProperty("prop.db");
	        	
	        	
	        	List<ServerAddress> seeds = new ArrayList<ServerAddress>();
	        	seeds.add( new ServerAddress(host, port ));
	        	List<MongoCredential> credentials = new ArrayList<MongoCredential>();
	        	credentials.add(
	        	    MongoCredential.createScramSha1Credential(
	        	    		mongoUser,
	        	    		mongoDB,
	        	    		mongoPassword.toCharArray()
	        	    )
	        	);
	        	
	        	@SuppressWarnings("resource")
				MongoClient mongo = new MongoClient( seeds, credentials );
	        	MongoDatabase db = mongo.getDatabase(mongoDB);
	        	
	            return db;
	        }
	        catch (Throwable ex) {
	            ex.printStackTrace();
	            throw new ExceptionInInitializerError(ex);
	        }
	    }
	     

     
    public static MongoDatabase getDBFactory(Properties prop) {
    	
        if(dbFactory == null){
        	dbFactory = buildDBFactory(prop);
        }
        
        return dbFactory;
    }

}
