package br.com.marmoreweb.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table(name="tb_recado")
public class Recado implements Serializable {

	private static final long serialVersionUID = -8718183066851740739L;

	@Id
	@GeneratedValue
	@Column(name="id_recado")
	private long idRecado;
	
	private String descricao;

	public long getIdRecado() {
		return idRecado;
	}

	public void setIdRecado(long idRecado) {
		this.idRecado = idRecado;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
