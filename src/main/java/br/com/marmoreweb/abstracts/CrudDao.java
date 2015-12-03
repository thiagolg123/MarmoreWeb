package br.com.marmoreweb.abstracts;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import br.com.marmoreweb.interfaces.DAO;
import br.com.marmoreweb.persistence.interfaces.MainPersistContext;

/**
 * Contem as operacoes basicas para um CRUD e prove um EntityManeger;
 * 
 * @author Thiago Gonçalves
 *
 * @param <T>
 */

public abstract class CrudDao<T> implements DAO {

	@Inject
	@MainPersistContext
	private EntityManager entityManeger;

	/**
	 * Prove um entityManeger, para executar algo especifico, como uma Query,
	 * por exemplo;
	 * 
	 * @return EntityManeger;
	 */
	public EntityManager getEntityManeger() throws RuntimeException {
		return entityManeger;
	}

	public abstract void save(T type) throws PersistenceException;

	public abstract T getById(long id) throws PersistenceException;

	public abstract List<T> findAll() throws PersistenceException;

	public abstract void delete(long id) throws PersistenceException;

	public abstract void update(T type) throws PersistenceException;
}
