package managedBeans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import Entities.Role;
import Entities.User;
import Impl.SBExamRemote;

@ManagedBean(name = "identity")
@SessionScoped
public class UserBean {
	// inject here the user ejb

	@EJB
	private SBExamRemote examenSBRemote;

	// it dependes on the entity
	private User u = new User();

	private String checkCredentials = "Login or password are wrong";

	private boolean isLogged = false;

	// variable to each role
	private Boolean loggedInAsClientOrProductOwner = false;
	private Boolean loggedInAsDeveloperOrScrumMaster = false;

	// maybe we will use it later ( for drop down list )
	private static List<User> listeUtilisateurs = new ArrayList<>();

	public String doLogin() {

		String navigateTo = "";
		User userLoggedIn = examenSBRemote.login(u.getEmail(), u.getPwd());
		System.out.println("user not found");
		if (userLoggedIn == null) {
			FacesContext.getCurrentInstance().addMessage("email", new FacesMessage("bad credentials"));
			//FacesContext.getCurrentInstance().addMessage("password", new FacesMessage("bad credentials"));
		} else {

			u = userLoggedIn;
			isLogged = true;

			if (userLoggedIn.getEmail().equals("")) {
				FacesContext.getCurrentInstance().addMessage("email", new FacesMessage("bad credentials"));
				FacesContext.getCurrentInstance().addMessage("password", new FacesMessage("bad credentials"));

			}
			if (userLoggedIn.getRole() == Role.CLIENT || userLoggedIn.getRole() == Role.PRODUCT_OWNER) {
				loggedInAsClientOrProductOwner = true;
				System.out.println("loggedInAsClientOrProductOwner");
				navigateTo = "/fonctionnel/projects?faces-redirect=true";
			}

			if (userLoggedIn.getRole() == Role.DEVELOPER || userLoggedIn.getRole() == Role.SCRUM_MASTER) {
				loggedInAsClientOrProductOwner = true;
				System.out.println("loggedInAsClientOrProductOwner");
				navigateTo = "/technique/affectedprojects?faces-redirect=true";
			}

			// else {
			// navigateTo = "/404?faces-redirect=true";
			// }
		}
		return navigateTo;

	}

	public String logout() {
		setLogged(false);
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login?faces-redirect=true";
	}

	public boolean isLogged() {
		return isLogged;
	}

	public void setLogged(boolean isLogged) {
		this.isLogged = isLogged;
	}

	public SBExamRemote getExamenSBRemote() {
		return examenSBRemote;
	}

	public void setExamenSBRemote(SBExamRemote examenSBRemote) {
		this.examenSBRemote = examenSBRemote;
	}

	public User getU() {
		return u;
	}

	public void setU(User u) {
		this.u = u;
	}

	public Boolean getLoggedInAsClientOrProductOwner() {
		return loggedInAsClientOrProductOwner;
	}

	public void setLoggedInAsClientOrProductOwner(Boolean loggedInAsClientOrProductOwner) {
		this.loggedInAsClientOrProductOwner = loggedInAsClientOrProductOwner;
	}

	public Boolean getLoggedInAsDeveloperOrScrumMaster() {
		return loggedInAsDeveloperOrScrumMaster;
	}

	public void setLoggedInAsDeveloperOrScrumMaster(Boolean loggedInAsDeveloperOrScrumMaster) {
		this.loggedInAsDeveloperOrScrumMaster = loggedInAsDeveloperOrScrumMaster;
	}

	public static List<User> getListeUtilisateurs() {
		return listeUtilisateurs;
	}

	public static void setListeUtilisateurs(List<User> listeUtilisateurs) {
		UserBean.listeUtilisateurs = listeUtilisateurs;
	}

	public String getCheckCredentials() {
		return checkCredentials;
	}

	public void setCheckCredentials(String checkCredentials) {
		this.checkCredentials = checkCredentials;
	}

	// getters + setters

}
