package br.com.auditlusws.resource;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

import org.apache.log4j.Logger;

import br.com.auditlusws.business.AuditoriaBusiness;
import br.com.auditlusws.model.Auditoria;

import com.google.gson.Gson;

@Path("/auditorias")
public class AuditoriaResources {
	
	final static Logger logger = Logger.getLogger(AuditoriaResources.class);
	 
    @Context
    ServletContext context;
	   
	@GET
	@Path("/disponiveis")
	@Produces("application/json")
	@Consumes("application/json")
	public String disponiveis() {
		
		logger.info("Nova requisição de auditoria!");
	
	    return AuditoriaBusiness.getBancoInstance().buscaAuditorias(null, context);
	}
	
	 
}
