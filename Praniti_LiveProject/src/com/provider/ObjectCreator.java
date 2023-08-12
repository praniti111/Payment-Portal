package com.provider;

import java.io.FileInputStream;

import java.util.Properties;

import com.services.LoginServices;
import com.servicesImpl.LoginServicesImpl;

public class ObjectCreator {
	
	public static LoginServicesImpl createObject()
	{
		return new LoginServicesImpl();
	}
	

}
