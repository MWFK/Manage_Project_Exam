package managedBeans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import Entities.Project;
import Impl.SBExamRemote;

@ManagedBean
public class TechBean {

	
	@EJB
	SBExamRemote SBExamRemote;
	
	@ManagedProperty(value = "#{identity}")
	UserBean userBean;
	
	private List<Project> listeProjects = new ArrayList<>();

	public List<Project> getListeProjects() {
		listeProjects=SBExamRemote.getProjectsByUser(userBean.getU().getId());
		return listeProjects;
	}

	public void setListeProjects(List<Project> listeProjects) {
	
		this.listeProjects = listeProjects;
	}

	public SBExamRemote getSBExamRemote() {
		return SBExamRemote;
	}

	public void setSBExamRemote(SBExamRemote sBExamRemote) {
		SBExamRemote = sBExamRemote;
	}

	public UserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}
	
	
}
