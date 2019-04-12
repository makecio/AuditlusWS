package br.com.auditlusws.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class Auditoria implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 3075169844240388236L;
	
	private String _id; 
	private String descricao; 
	private int localizacao; 
	private int audio; 
	private int midia; 
	
	@JsonDeserialize(using = MongoDateConverter.class)
	private Date data;
	
	private List<AuditoriaXCapitulos> lsCapitulos;
	
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getLocalizacao() {
		return localizacao;
	}
	public void setLocalizacao(int localizacao) {
		this.localizacao = localizacao;
	}
	public int getAudio() {
		return audio;
	}
	public void setAudio(int audio) {
		this.audio = audio;
	}
	public int getMidia() {
		return midia;
	}
	public void setMidia(int midia) {
		this.midia = midia;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public List<AuditoriaXCapitulos> getLsCapitulos() {
		return lsCapitulos;
	}
	public void setLsCapitulos(List<AuditoriaXCapitulos> lsCapitulos) {
		this.lsCapitulos = lsCapitulos;
	}
	
	
	
	
	
}
