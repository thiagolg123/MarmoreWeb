package br.com.marmoreweb.cadastrocliente;

import javax.inject.Inject;
import javax.persistence.PersistenceException;

import br.com.marmoreweb.modelo.Cliente;

public class EditClientService {
	@Inject
	private CadastroClienteDAO clienteDao;

	public Cliente getClientToEdit(long clienteId) throws PersistenceException {
		return clienteDao.getById(clienteId);
	}

	public void updateCliente(Cliente cliente) throws PersistenceException {
		clienteDao.update(cliente);
	}
}
