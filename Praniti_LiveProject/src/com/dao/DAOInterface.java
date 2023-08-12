package com.dao;

import com.bean.User;


public interface DAOInterface 
{
	public void insertUser(User u);
	public User retriveUser(String name);

}
