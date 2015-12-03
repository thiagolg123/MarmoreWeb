package br.com.marmoreweb.homepublic;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.marmoreweb.login.LoginDAO;

@Named
@RequestScoped
public class HomeBean {

	@Inject
	LoginDAO loginDao;

	private String name;

	// TEstando CDI
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String redirectToADM() {
		return "pages/protected/adm/welcomeAdm.jsf?faces-redirect=true";
	}

	public String redirectToUser() {
		return "pages/protected/user/welcomeUser.jsf?faces-redirect=true";

	}
}
