package br.com.marmoreweb.cadastrocliente;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import br.com.marmoreweb.abstracts.MBean;
import br.com.marmoreweb.modelo.Cliente;

@Named("editCli")
@RequestScoped
public class EditClienteBean extends MBean {

	private static final long serialVersionUID = -895254894597897032L;

	@Inject
	private EditClientService editClientService;

	private Cliente clienteToEdit;
	private long clienteId;

	public Cliente getClienteToEdit() {
		return clienteToEdit;
	}

	public void setClienteToEdit(Cliente clienteToEdit) {
		this.clienteToEdit = clienteToEdit;
	}

	@PostConstruct
	public void initEditClient() {
		clienteId = Long.parseLong((String) getSessionAttr("clienteId"));
		clienteToEdit = editClientService.getClientToEdit(clienteId);
	}

	public void saveEditClient(Cliente cliente) {
		editClientService.updateCliente(cliente);
		RequestContext.getCurrentInstance().closeDialog(cliente);
	}
}
