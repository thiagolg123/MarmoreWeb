package br.com.marmoreweb.homeadm;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.marmoreweb.abstracts.MBean;
import br.com.marmoreweb.login.LoginDAO;
import br.com.marmoreweb.modelo.User;

@Named("homeAdm")
@ViewScoped
public class HomeAdmBean extends MBean {

	private static final long serialVersionUID = 1L;

	@Inject
	LoginDAO loginDao;

	private final Logger logger = LoggerFactory.getLogger(HomeAdmBean.class);
	private String nomeAdmLogado;
	private final String queryNomeLogado = "select u from User u Where u.login= :login";
	private String emailLogado;

	public String getNomeAdmLogado() {
		return this.nomeAdmLogado;
	}

	public void setNomeAdmLogado(String nomeAdmLogado) {
		logger.error("testando log");
		emailLogado = this.getRequest().getUserPrincipal().getName();

		if (nomeAdmLogado == null) {
			Query query = loginDao.getEntityManeger().createQuery(
					queryNomeLogado);
			query.setParameter("login", emailLogado);

			User user = (User) query.getSingleResult();
			nomeAdmLogado = user.getNome();
		}
		this.nomeAdmLogado = nomeAdmLogado;
	}

	public String telaDeCadastro() {
		return "/pages/protected/adm/cadastro_cliente.xhtml?faces-redirect=true";
	}

	public String telaDeLista() {
		return "/pages/protected/adm/lista_clientes.xhtml?faces-redirect=true";
	}
}
