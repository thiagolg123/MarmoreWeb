package br.com.marmoreweb.login;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Query;

import br.com.marmoreweb.abstracts.MBean;
import br.com.marmoreweb.modelo.Roles;
import br.com.marmoreweb.modelo.User;

@Named
@ApplicationScoped
public class LoginBean extends MBean {

	private static final long serialVersionUID = 1L;

	@Inject
	private LoginDAO loginDao;

	private final String query403 = "select u from User u Where u.login= :login";

	/**
	 * invalida o login na sessao
	 * 
	 * @return to home
	 */
	public String exitLogin() {
		this.getRequest().getSession().invalidate();

		return "/index.jsf?faces-redirect=true";
	}

	/**
	 * Exit conforme a role do usuario
	 * 
	 * @return
	 */
	public String exit403() {
		return manageReturn403();
	}

	/**
	 * Verifica roles para voltar a pagina correta conforme a role do usuario
	 * logado
	 * 
	 * @return
	 */
	public String manageReturn403() {
		String retorno = "";

		String nomeUserLogado = this.getRequest().getUserPrincipal().getName();

		Query query = loginDao.getEntityManeger().createQuery(query403);
		query.setParameter("login", nomeUserLogado);

		User user = (User) query.getSingleResult();

		if (user.getRole().equals(Roles.ADMIN)) {
			retorno = "pages/protected/adm/welcomeAdm.jsf?faces-redirect=true";
		}
		if (user.getRole().equals(Roles.USER)) {
			retorno = "pages/protected/user/welcomeUser.jsf?faces-redirect=true";
		}

		return retorno;
	}
}
