package br.com.auditlusws.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class AuditoriaXCapitulos implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 3075169844240388236L;
	
	private String _id; 
	private String auditoria_id; 
	private String capitulo_id; 
	
	@JsonDeserialize(using = MongoDateConverter.class)
	private Date data;

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getAuditoria_id() {
		return auditoria_id;
	}

	public void setAuditoria_id(String auditoria_id) {
		this.auditoria_id = auditoria_id;
	}

	public String getCapitulo_id() {
		return capitulo_id;
	}

	public void setCapitulo_id(String capitulo_id) {
		this.capitulo_id = capitulo_id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	
	
}
