
package br.com.marmoreweb.cadastrocliente;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import br.com.marmoreweb.abstracts.CrudDao;
import br.com.marmoreweb.modelo.Cliente;

@Transactional
public class CadastroClienteDAO extends CrudDao<Cliente> {

	@Override
	public void save(Cliente cliente) {
		this.getEntityManeger().persist(cliente);
		this.getEntityManeger().flush();
	}

	@Override
	public Cliente getById(long id) {
		return this.getEntityManeger().find(Cliente.class, id);
	}

	@Override
	public List<Cliente> findAll() {
		TypedQuery<Cliente> queryFindAll = this.getEntityManeger().createQuery(
				"SELECT c FROM Cliente c", Cliente.class);

		return queryFindAll.getResultList();
	}

	@Override
	public void delete(long id) {
		this.getEntityManeger().remove(
				this.getEntityManeger().getReference(Cliente.class, id));
	}

	@Override
	public void update(Cliente cliente) {
		this.getEntityManeger().merge(cliente);
	}
}
