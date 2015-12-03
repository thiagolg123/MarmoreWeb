package br.com.marmoreweb.cadastrocliente;

import java.io.Serializable;
import java.util.List;

import br.com.marmoreweb.modelo.Cheque;
import br.com.marmoreweb.modelo.Orcamento;

/**
 * @author thiago
 * 
 *         Usar DTO somente para listar coisas
 */
public class ClienteDTO implements Serializable {

	private static final long serialVersionUID = -3365610839275279380L;

	private long id;
	private String cpf;
	private String nome;
	private String endereco;
	private String telefone;
	private List<Cheque> cheques;
	private List<Orcamento> orcamentos;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public List<Cheque> getCheques() {
		return cheques;
	}

	public void setCheques(List<Cheque> cheques) {
		this.cheques = cheques;
	}

	public List<Orcamento> getOrcamentos() {
		return orcamentos;
	}

	public void setOrcamentos(List<Orcamento> orcamentos) {
		this.orcamentos = orcamentos;
	}
}
