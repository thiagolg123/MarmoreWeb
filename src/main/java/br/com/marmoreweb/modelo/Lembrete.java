package br.com.marmoreweb.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_lembrete")
public class Lembrete {

	@Id
	@GeneratedValue
	@Column(name="id_lembrete")
	private long id;
	
	@Column(name="descricao_lembrete")
	private String descricao;

	
	
	public long getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
