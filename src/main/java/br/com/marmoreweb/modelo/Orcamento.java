package br.com.marmoreweb.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb_orcamento")
public class Orcamento implements Serializable {

	private static final long serialVersionUID = 1065942722675161901L;

	@Id
	@GeneratedValue
	@Column(name = "id_orcamento")
	private long idOrcamento;

	@ManyToOne
	private Cliente clienteOrcamento;

	private String descricao;
	private double valor;
	
	@Temporal(TemporalType.DATE)
	private Date dataDaCompra;
	
	@Enumerated(EnumType.STRING)
	private StatusOrcamento statusOrcamento;

	
	public Date getDataDaCompra() {
		return dataDaCompra;
	}

	public void setDataDaCompra(Date dataDaCompra) {
		this.dataDaCompra = dataDaCompra;
	}

	public StatusOrcamento getStatusOrcamento() {
		return statusOrcamento;
	}

	public void setStatusOrcamento(StatusOrcamento statusOrcamento) {
		this.statusOrcamento = statusOrcamento;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public long getIdOrcamento() {
		return idOrcamento;
	}

	public Cliente getClienteOrcamento() {
		return clienteOrcamento;
	}

	public void setClienteOrcamento(Cliente clienteOrcamento) {
		this.clienteOrcamento = clienteOrcamento;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
