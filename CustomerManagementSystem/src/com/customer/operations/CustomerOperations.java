package com.customer.operations;

import java.time.LocalDate;

import com.customer.core.ServicePlan;
import com.customer.custom_exceptions.CustomerExeption;

public interface CustomerOperations {
	public void signUp(String firstName, String lastName, String email, String password,
			double registrationAmount, String dob, String plan) throws CustomerExeption;
	public void signIn(String email,String passord) throws CustomerExeption;
	public void changePassword(String email,String oldPassword,String newPassword) throws CustomerExeption;
	public void unsubscribeCustomer(String email) throws CustomerExeption;
	public void displayAllCustomer();
}
