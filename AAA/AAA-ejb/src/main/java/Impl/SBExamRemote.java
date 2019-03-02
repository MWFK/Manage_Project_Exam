package Impl;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import Entities.Project;
import Entities.User;

@Remote
public interface SBExamRemote {
	
	public void addUser(User user);
	public void addProject(Project project);
	
	public void assignProjectToUser(int projectId,int userId);
	public List<Project> getAllProjects();
	public List<Project> getProjectsByUser(int idUser);
	public void addSprintAndAssignToProject(String description,Date startDate,int idProject);
	public User login(String email,String password);

}
