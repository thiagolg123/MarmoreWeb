package br.com.marmoreweb.cadastrocliente;

import javax.inject.Inject;
import javax.persistence.PersistenceException;

import br.com.marmoreweb.interfaces.Service;
import br.com.marmoreweb.modelo.Cliente;

public class CadastroClienteService implements Service{

	@Inject
	private CadastroClienteDAO clienteDao;

	public void salvaCliente(Cliente cliente) throws PersistenceException {
		clienteDao.save(cliente);
	}
}
