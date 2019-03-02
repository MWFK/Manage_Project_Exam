package managedBeans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import Entities.Project;
import Impl.SBExamRemote;

@ManagedBean
public class FoncBean {
	
	@EJB
	SBExamRemote SBExamRemote;
	
	private List<Project> listeProjects = new ArrayList<>();

	public SBExamRemote getSBExamRemote() {
		return SBExamRemote;
	}

	public void setSBExamRemote(SBExamRemote sBExamRemote) {
		SBExamRemote = sBExamRemote;
	}

	public List<Project> getListeProjects() {
		listeProjects = SBExamRemote.getAllProjects();
		return listeProjects;
	}

	public void setListeProjects(List<Project> listeProjects) {
		this.listeProjects = listeProjects;
	}
	
	
	
	
	

}
