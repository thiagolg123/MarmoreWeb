package br.com.marmoreweb.cadastrocliente;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

import br.com.marmoreweb.abstracts.MBean;
import br.com.marmoreweb.modelo.Cliente;

@Named("listaCliBean")
@RequestScoped
public class ListaClientesBean extends MBean {

	private static final long serialVersionUID = 2497637795508666157L;

	// TODO Fazer o service
	@Inject
	private CadastroClienteDAO clienteDao;

	private List<Cliente> listaClientes = new ArrayList<Cliente>();

	public List<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	@PostConstruct
	public void popClientes() { // TODO paginate
		listaClientes = clienteDao.findAll();
	}

	public void apagaCliente(long id) {
		clienteDao.delete(id);
		popClientes();
	}

	public void openModalEditCliente() {
		Map<String, Object> options = new HashMap<String, Object>();
		options.put("resizable", false);
		options.put("draggable", false);
		options.put("modal", true);

		setSessionAttr("clienteId", getRequestAttr("clienteId"));

		RequestContext.getCurrentInstance().openDialog("editClient", options,
				null);
	}

	public void onEditSucess(SelectEvent event) {
		Cliente cliente = (Cliente) event.getObject();

		addMessageWithoutId(setFacesMessageWithSeverity(
				FacesMessage.SEVERITY_INFO, "Cliente: " + cliente.getNome()
				+ " salvo"));
	}
}
