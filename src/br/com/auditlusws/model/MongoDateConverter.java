package br.com.auditlusws.model;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;



class MongoDateConverter extends JsonDeserializer<Date> {
    private static final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

  
	@Override
	public Date deserialize(com.fasterxml.jackson.core.JsonParser jp,
			DeserializationContext arg1) throws IOException,
			JsonProcessingException {
		// TODO Auto-generated method stub
		JsonNode node = jp.readValueAsTree();
        try {
            return formatter.parse(node.get("$date").asText());
        } catch (ParseException e) {
            return null;
        }
	}
}