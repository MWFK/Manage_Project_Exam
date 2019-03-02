package Examens;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import Impl.SBExamRemote;

public class Q3 {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		String jndi = "AAA-ear/AAA-ejb/SBExam!Impl.SBExamRemote";
		//UserManagmentRemote userManagmentRemote = (UserManagmentRemote) context.lookup(jndi);
		SBExamRemote SBExamRemote = (SBExamRemote) context.lookup(jndi);
		SBExamRemote.assignProjectToUser(1, 1);
		SBExamRemote.assignProjectToUser(1, 2);
		System.out.println("projects assigned");
		
	}

}
