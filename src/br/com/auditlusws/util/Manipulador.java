package br.com.auditlusws.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletContext;
import org.apache.log4j.Logger;


public class Manipulador {


	final static Logger logger = Logger.getLogger(Manipulador.class);
	
	public static Properties getProp(ServletContext context) throws IOException {
		
		logger.info("Leitura do arquivo de propriedades");
		
		String realPath = context.getRealPath("/WEB-INF/param.properties");
		 
		Properties props = new Properties();
				
		props.load(new FileInputStream(new File(realPath)));
		
		return props;

	}


}