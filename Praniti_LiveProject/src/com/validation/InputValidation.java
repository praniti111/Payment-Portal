package com.validation;

public class InputValidation 
{
	public static boolean validateUserName(String username) {
		if(username!=null && username!="")
			return true;
		else
			return false;
	}
	
	public static boolean validatePassword(String password) {
		if(password!=null && password.length()>=8)
			return true;
		else
			return false;
	}
	
    public static boolean validateSqn(String sqn) {
    	if(sqn!=null && sqn!="")
    		return true;
    	else
    		return false;
    }

}
