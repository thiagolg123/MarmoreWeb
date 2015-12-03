package br.com.marmoreweb.cadastrocliente;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.PersistenceException;

import br.com.marmoreweb.abstracts.MBean;
import br.com.marmoreweb.modelo.Cliente;

@Named("cadastroCliente")
@RequestScoped
public class CadastroClienteBean extends MBean {

	private static final long serialVersionUID = 4941454376853684651L;

	@Inject
	private CadastroClienteService clienteService;

	private Cliente cliente = new Cliente();

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void salvaCliente() {
		try {
			clienteService.salvaCliente(cliente);
			this.getFacesInstance().addMessage(null,
					this.setFacesMessage("Cadastro Salvo"));
		} catch (PersistenceException e) {
			this.getFacesInstance().addMessage(
					null,
					this.setFacesMessageWithSeverity(
							FacesMessage.SEVERITY_ERROR,
							"Erro ao tentar salvar Cliente"));
		}
	}
}