package Examens;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import Entities.Project;
import Impl.SBExamRemote;

public class Q2 {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		String jndi = "AAA-ear/AAA-ejb/SBExam!Impl.SBExamRemote";

		// UserManagmentRemote userManagmentRemote = (UserManagmentRemote)
		// context.lookup(jndi);

		SBExamRemote SBExamRemote = (SBExamRemote) context.lookup(jndi);
		
		Project proj1 = new Project("MAP", "Gestion de mandats, assignantions et Projets");
		Project proj2 = new Project("OTDAV", "Gestion des oeuvres");
		SBExamRemote.addProject(proj1);
		SBExamRemote.addProject(proj2);
		System.out.println("project added");
		
	}

}
