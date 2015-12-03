package br.com.marmoreweb.login;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import br.com.marmoreweb.abstracts.CrudDao;
import br.com.marmoreweb.abstracts.TestNull;
import br.com.marmoreweb.modelo.User;

@Transactional
public class LoginDAO extends CrudDao<User> {

	@Override
	public void save(User user) {
		TestNull.test(user);
		this.getEntityManeger().persist(user);
	}

	@Override
	public User getById(long id) {
		return this.getEntityManeger().find(User.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAll() {
		Query queryList = this.getEntityManeger().createQuery(
				"SELECT user FROM USER user");

		return (List<User>) queryList.getResultList();
	}

	@Override
	public void delete(long id) {
		this.getEntityManeger().remove(
				this.getEntityManeger().getReference(User.class, id));
	}

	@Override
	public void update(User user) {
		this.save(user);
	}
}
