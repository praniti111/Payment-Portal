package com.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.bean.User;
import com.dao.DAOInterface;


public class DAOImplClass implements DAOInterface
{
	Connection con;
	PreparedStatement pst;
    ResultSet rs;
    User un = null;

	public void provideConnection(Connection con)
	{
		this.con = con;
	}
	
	public void insertUser(User u){
		
		try
		{
			String name = u.getUsername();
			String pass = u.getPassword();
			String sqn = u.getSqn();
	
			pst = con.prepareStatement("insert into signup_table values(?,?,?)");
			pst.setString(1, name);
			pst.setString(2, pass);
			pst.setString(3, sqn);
				
			pst.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}


	public User retriveUser(String name) {
		String u =null;
		String p=null;
		String s=null;
		
		try
		{

		    pst = con.prepareStatement("select * from signup_table where username=?");
			pst.setString(1,name);
			
			rs = pst.executeQuery();
		    if(rs.next())
		    {
		    	 u=rs.getString("username");			
		    	 p=rs.getString("password");
		    	 s=rs.getString("sqn");		
		    }
		    else
		    {
		    	 u="";
		    	 p="";
		    	 s="";
		    	
		    }
		    un = new User(u,p,s);
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return un;
	}
	

}
