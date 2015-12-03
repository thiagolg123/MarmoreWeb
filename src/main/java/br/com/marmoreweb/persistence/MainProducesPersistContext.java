package br.com.marmoreweb.persistence;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.marmoreweb.persistence.interfaces.MainPersistContext;

@RequestScoped
public class MainProducesPersistContext {
	@Produces
	@MainPersistContext
	@PersistenceContext(name = "MarmoreWebPU")
	private EntityManager em;
}
