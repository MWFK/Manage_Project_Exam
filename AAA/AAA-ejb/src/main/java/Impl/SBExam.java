package Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import Entities.Project;
import Entities.Sprint;
import Entities.User;

/**
 * Session Bean implementation class SBExam
 */
@Stateless
@LocalBean
public class SBExam implements SBExamRemote, SBExamLocal {

	/**
	 * Default constructor.
	 */

	@PersistenceContext
	EntityManager em;

	public SBExam() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addUser(User user) {
		em.persist(user);

	}

	@Override
	public void addProject(Project project) {
		em.persist(project);

	}

	@Override
	public void assignProjectToUser(int projectId, int userId) {
		Project p = new Project();
		User u = new User();

		u = em.find(User.class, userId);
		p = em.find(Project.class, projectId);
		List<Project> ll = new ArrayList<>();
		ll.add(p);
		u.setListeProjets(ll);
		em.merge(u);
		System.out.println("merged from SB");

	}

	@Override
	public List<Project> getAllProjects() {
		return em.createQuery("from Project").getResultList();
	}

	@Override
	public List<Project> getProjectsByUser(int idUser) {
		User u = new User();
		u = em.find(User.class, idUser);
		return u.getListeProjets();
	}

	@Override
	public void addSprintAndAssignToProject(String description, Date startDate, int idProject) {
		
		/*Sprint sp = new Sprint();
		sp.setDescription(description);
		sp.setStartDate(startDate);
		
		Project p = new Project();
		p=em.find(Project.class, idProject);
		
		List<Sprint> listeSprints = new ArrayList<>();
		listeSprints.add(sp);
		p.setListeSprints(listeSprints);
		
		em.persist(p);
		System.out.println("merged from SB");*/
		
		
		
		Sprint sp = new Sprint();
		sp.setDescription(description);
		sp.setStartDate(startDate);
		Project p = new Project();
		p=em.find(Project.class, idProject);
	sp.setProject(p);
	em.persist(sp);
	System.out.println("merged from SB");
		
		
		
		
		
	}

	@Override
	public User login(String email, String password) {
		try {
			Query query = em.createQuery("select e from User e where e.email=:l and e.pwd=:p");
			query.setParameter("l", email).setParameter("p", password);
			return (User) query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

}
