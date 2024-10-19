package com.customer.validations;

import java.util.Map;

import com.customer.core.Customer;
import com.customer.core.ServicePlan;
import com.customer.custom_exceptions.CustomerExeption;

public class CustomerValidations {
	
	public static String validateEmail(String email) throws CustomerExeption{
		if(email.matches("^[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.(com|net|org)$")==false) {
			throw new CustomerExeption("Invalid email address");
		}		
		return email;	
	}
	
	public static double validateRegisterAmount(double amount,ServicePlan plan) throws CustomerExeption{
		if(plan.getAmount()!=amount)
			throw new CustomerExeption("Registration amount must match the plan: "+plan);
		return amount;
	}
	
	public static boolean validatePassword(String oldPass, String newPass) throws CustomerExeption{
		if(oldPass.equals(newPass)) {
			throw new CustomerExeption("new password cannot be same as old one");
		}
		return true;
		
	}
	
	public static void validateDuplicate(String email,Map<String, Customer> customers) throws CustomerExeption{
		if(customers.containsKey(email))
			throw new CustomerExeption("Email already exists");
	}
}
