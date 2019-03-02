package Entities;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Projet
 *
 */
@Entity

public class Project implements Serializable {

	
	private int id;
	private String title;
	private String description;
	private static final long serialVersionUID = 1L;
	
	
	
	private List<User> listeUsers;
	
	
	private List<Sprint> listeSprints;
	

	@Override
	public String toString() {
		return "Project [id=" + id + ", title=" + title + ", description=" + description + "]";
	}


	public Project() {
		super();
	}   
	
	
	public Project(String title, String description) {
		super();
		this.title = title;
		this.description = description;
	}


	@Id    
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@ManyToMany(mappedBy="listeProjets")
	public List<User> getListeUsers() {
		return listeUsers;
	}
	public void setListeUsers(List<User> listeUsers) {
		this.listeUsers = listeUsers;
	}
	
	@OneToMany(cascade=CascadeType.PERSIST,mappedBy="project")
	public List<Sprint> getListeSprints() {
		return listeSprints;
	}
	public void setListeSprints(List<Sprint> listeSprints) {
		this.listeSprints = listeSprints;
	}
   
}
