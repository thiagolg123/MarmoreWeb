package br.com.marmoreweb.abstracts;

import java.io.Serializable;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 * Algumas coisas genericas que a maioria dos MBeans usarão; </br>(DRY)
 * 
 * @author Thiago Gonçalves
 *
 */
public class MBean implements Serializable {

	private static final long serialVersionUID = -8356443402515769876L;

	/**
	 * @return O request facesContext.
	 */
	public HttpServletRequest getRequest() {
		return (HttpServletRequest) FacesContext.getCurrentInstance()
				.getExternalContext().getRequest();
	}

	/**
	 * @return currentInstance do facesContext.
	 */
	public FacesContext getFacesInstance() {
		return FacesContext.getCurrentInstance();
	}

	/**
	 * Set uma message.
	 * 
	 * @param message
	 * @return facesMessage
	 */
	public FacesMessage setFacesMessage(String message) {
		return new FacesMessage(message);
	}

	/**
	 * Add messagem para o contexto do faces sem childId.
	 * 
	 * @param message
	 */
	public void addMessageWithoutId(FacesMessage message) {
		getFacesInstance().addMessage(null, message);
	}

	/**
	 * Add messagem para o contexto do faces com childId.
	 * 
	 * @param clientId
	 * @param message
	 */
	public void addMessageWithId(String childId, FacesMessage message) {
		getFacesInstance().addMessage(childId, message);
	}

	/**
	 * Set um message com severity.
	 * 
	 * @param severity
	 * @param message
	 * @return Msg com severity.
	 */
	public FacesMessage setFacesMessageWithSeverity(Severity severity,
			String message) {
		return new FacesMessage(severity, message, null);
	}

	/**
	 * Set um atributo na sessão.
	 * 
	 * @param key
	 * @param value
	 */
	public void setSessionAttr(String key, Object value) {
		getFacesInstance().getExternalContext().getSessionMap().put(key, value);
	}

	/**
	 * Get um atributo da sessão.
	 * 
	 * @param key
	 * @return Objeto da sessão.
	 */
	public Object getSessionAttr(String key) {
		return getFacesInstance().getExternalContext().getSessionMap().get(key);
	}

	/**
	 * Get um parameter da request conforme key passado.
	 * 
	 * @param key
	 * @return String (para Cast)
	 */
	public String getRequestAttr(String key) {
		return getFacesInstance().getExternalContext().getRequestParameterMap()
				.get(key);
	}

	/**
	 * Get o Map<String, String> da request.
	 * 
	 * @param key
	 * @return Map dos parameters do request
	 */
	public Map<String, String> getRequestParamMap() {
		return getFacesInstance().getExternalContext().getRequestParameterMap();
	}
}
