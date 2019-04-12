package br.com.auditlusws.business;

import java.util.List;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

import br.com.auditlusws.dao.AuditoriaDAO;
import br.com.auditlusws.dao.AuditoriaXCapitulosDAO;
import br.com.auditlusws.model.Auditoria;

public class AuditoriaBusiness {
	
   final static Logger logger = Logger.getLogger(AuditoriaBusiness.class);
	 
   private static AuditoriaBusiness instance;
     
   public static AuditoriaBusiness getBancoInstance(){
	     if(instance==null)
	         instance = new AuditoriaBusiness();
	     return instance;
	 }   


	public String buscaAuditorias(Auditoria audit, ServletContext context) {
		// TODO Auto-generated method stub
		AuditoriaDAO auditDAO = new AuditoriaDAO(context);
		AuditoriaXCapitulosDAO auditxcapitDAO = new AuditoriaXCapitulosDAO(context);
		
		List<Auditoria> lsAudit = auditDAO.buscaAuditorias();
		
		for(Auditoria a: lsAudit){
			a.setLsCapitulos(auditxcapitDAO.buscaAuditoriasXCapitulos(a.get_id()));
		}
		
		return new Gson().toJson(lsAudit);
		
	}
	
	

}
