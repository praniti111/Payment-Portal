package com.servicesImpl;

import java.sql.Connection;
import java.util.DuplicateFormatFlagsException;

import com.DAOImpl.DAOImplClass;
import com.bean.User;
import com.exceptions.InvalidInputException;
import com.services.LoginServices;
import com.validation.InputValidation;


public class LoginServicesImpl implements LoginServices{
	
	User u;
	Connection con;
	DAOImplClass dao = new DAOImplClass();
	
	public void setConnection(Connection con)
	{
		this.con = con;
		dao.provideConnection(con);
	}
	
	public boolean signUp(String username, String password, String sqn)throws InvalidInputException {
		if(InputValidation.validateUserName(username)) {
			User u1=null;
			User u2=null;
			Boolean outcome = false;
			
			u1=dao.retriveUser(username);
			if(u1.getUsername().equalsIgnoreCase(username))
			{
				outcome= false;
			}
			else
			{
				u2 = new User(username,password,sqn);
			    dao.insertUser(u2);
			    outcome=true;
			}
			return outcome;
					
	    }
		return false;
	}

	public boolean signIn(String username, String password)throws InvalidInputException {
		if(InputValidation.validateUserName(username)) {
			User u=null;
			Boolean outcome = false;
			
			u=dao.retriveUser(username);
			if(u.getUsername().equalsIgnoreCase(username)&& u.getPassword().equals(password))
			{
				outcome= true;
			}
			else
			{
				outcome= false;
			}	
			return outcome;
		}
		return false;
	}

	

}
