package br.com.auditlusws.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.bson.Document;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;

import br.com.auditlusws.model.Auditoria;
import br.com.auditlusws.util.Manipulador;
import br.com.auditlusws.util.MongoDBUtil;

public class AuditoriaDAO {
	
	private MongoDatabase db;
	
	private static Properties prop;
	
	final static Logger logger = Logger.getLogger(AuditoriaDAO.class);
			
	public AuditoriaDAO(ServletContext context) {
	
		try {
			
			if(prop == null){
				db = MongoDBUtil.getDBFactory(Manipulador.getProp(context));
			}
			
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
		
	}

	public List<Auditoria> buscaAuditorias(){
		
    	logger.info("buscaAuditorias");
    	
    	List<Auditoria> lsAudit = new ArrayList<Auditoria>();
		 
		 	try {

		 		MongoCollection<Document> table = db.getCollection("auditoria");
	        	
		 		//Document findQuery = new Document("_id" , new Document("$eq","m2cvoMCHoSwgiBRBm"));
		 		
		 		MongoCursor<Document> cursor = table.find().iterator();
		 		try {
		 		    while (cursor.hasNext()) {
		 		    	
		 		    	Auditoria audit = getPOJOFromMongoDocument(cursor.next(), Auditoria.class);
		 		    			
		 		    	lsAudit.add(audit);
		 		    }
		 		} finally {
		 		    cursor.close();
		 		}
	        	
	        }
	        catch (Exception e) {
	        	logger.error(e.getMessage());
	        }
	         
	        return lsAudit;
	    
	    }
	 
	public <T> T getPOJOFromMongoDocument(Document resourceDocument, Class<T> clazz) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
        String serialize = JSON.serialize(resourceDocument);
        
        return objectMapper.readValue(serialize, clazz);
	}
}
