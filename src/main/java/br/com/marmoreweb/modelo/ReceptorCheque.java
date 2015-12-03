package br.com.marmoreweb.modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_receptor_cheque")
public class ReceptorCheque {

	@Id
	@GeneratedValue
	@Column(name = "id_receptor")
	private long idReceptor;

	private String nome;
	private String telefone;
	private String endereco;

	@OneToMany(mappedBy = "receptor")
	private List<Cheque> chequesRecebidos;

	public long getIdReceptor() {
		return idReceptor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public List<Cheque> getChequesRecebidos() {
		return chequesRecebidos;
	}

	public void setChequesRecebidos(List<Cheque> chequesRecebidos) {
		this.chequesRecebidos = chequesRecebidos;
	}

}
