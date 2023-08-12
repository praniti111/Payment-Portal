package com.services;

import java.sql.Connection;

import com.exceptions.InvalidInputException;


public interface LoginServices 
{
	boolean signUp(String username,String password,String sqn) throws InvalidInputException;
	boolean signIn(String username,String password) throws InvalidInputException;
	

}
