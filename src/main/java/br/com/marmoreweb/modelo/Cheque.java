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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb_cheque")
public class Cheque implements Serializable {

	private static final long serialVersionUID = -665004120840635843L;

	@Id
	@GeneratedValue
	@Column(name = "id_cheque")
	private long idCheque;

	private int numero;
	private String banco;
	private double valor;

	@Temporal(TemporalType.DATE)
	private Date dataVencimento;

	@Enumerated(EnumType.STRING)
	private StatusCheque statusCheque;

	@ManyToOne
	private Cliente clienteCheque;

	@OneToOne
	private InstituicaoBancaria nomeBanco;

	@ManyToOne
	private ReceptorCheque receptor;

	
	
	
	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public StatusCheque getStatusCheque() {
		return statusCheque;
	}

	public void setStatusCheque(StatusCheque statusCheque) {
		this.statusCheque = statusCheque;
	}

	public Cliente getClienteCheque() {
		return clienteCheque;
	}

	public void setClienteCheque(Cliente clienteCheque) {
		this.clienteCheque = clienteCheque;
	}

	public InstituicaoBancaria getNomeBanco() {
		return nomeBanco;
	}

	public void setNomeBanco(InstituicaoBancaria nomeBanco) {
		this.nomeBanco = nomeBanco;
	}

	public ReceptorCheque getReceptor() {
		return receptor;
	}

	public void setReceptor(ReceptorCheque receptor) {
		this.receptor = receptor;
	}

	public long getIdCheque() {
		return idCheque;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

}
