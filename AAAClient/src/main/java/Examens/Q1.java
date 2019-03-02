package Examens;

import java.net.SocketTimeoutException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import Entities.Role;
import Entities.User;
import Impl.SBExamRemote;

public class Q1 {
	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		String jndi = "AAA-ear/AAA-ejb/SBExam!Impl.SBExamRemote";

		// UserManagmentRemote userManagmentRemote = (UserManagmentRemote)
		// context.lookup(jndi);

		SBExamRemote SBExamRemote = (SBExamRemote) context.lookup(jndi);
		User usr1 = new User("ab@esprit.tn", "dev", "Mohamed", "BOUHLEL", Role.DEVELOPER);
		User usr2 = new User("ka@neoxam.tn", "cli", "Kais", "ALLANI", Role.CLIENT);
		SBExamRemote.addUser(usr1);
		SBExamRemote.addUser(usr2);
		System.out.println("users added!");
		

	}

}
