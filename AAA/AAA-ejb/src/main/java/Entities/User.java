package Entities;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity

public class User implements Serializable {

	private int id;
	private String email;
	private String pwd;
	private String fName;
	private String lName;
	private Role role;
	private static final long serialVersionUID = 1L;

	private List<Project> listeProjets;

	public User() {
		super();
	}
	
	

	public User(String email, String pwd, String fName, String lName, Role role) {
		super();
		this.email = email;
		this.pwd = pwd;
		this.fName = fName;
		this.lName = lName;
		this.role = role;
	}



	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public void setListeProjets(List<Project> listeProjets) {
		this.listeProjets = listeProjets;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	@Enumerated(EnumType.STRING)
	public Role getRole() {
		return this.role;
	}

	@ManyToMany(fetch=FetchType.EAGER)
	public List<Project> getListeProjets() {
		return listeProjets;
	}

}
