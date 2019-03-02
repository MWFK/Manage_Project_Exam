package Examens;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import Impl.SBExamRemote;

public class Q5 {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
	
		String jndi = "AAA-ear/AAA-ejb/SBExam!Impl.SBExamRemote";
		//UserManagmentRemote userManagmentRemote = (UserManagmentRemote) context.lookup(jndi);
		SBExamRemote SBExamRemote = (SBExamRemote) context.lookup(jndi);
		System.out.println( SBExamRemote.getProjectsByUser(1));;
		

	}

}
