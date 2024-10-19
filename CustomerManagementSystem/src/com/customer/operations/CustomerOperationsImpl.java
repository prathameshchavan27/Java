package com.customer.operations;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import com.customer.core.Customer;
import com.customer.core.ServicePlan;
import com.customer.custom_exceptions.CustomerExeption;
import static com.customer.validations.CustomerValidations.*;

public class CustomerOperationsImpl implements CustomerOperations{
	Map<String,Customer> customers;
	
	public CustomerOperationsImpl() {
		customers = new HashMap<>();
		Customer c = new Customer("Prathamesh", "Chavan", "prathamesh@gmail.com", "123456", 10000,LocalDate.parse("2002-07-27"),ServicePlan.PLATINUM);
		customers.put(c.getEmail(),c);
	}

	@Override
	public void signUp(String firstName, String lastName, String email, String password,
			double registrationAmount, String dob, String plan) throws CustomerExeption{
		LocalDate date = LocalDate.parse(dob);
		ServicePlan pl = ServicePlan.valueOf(plan.toUpperCase());
		String validEmail = validateEmail(email);
		double regAmount = validateRegisterAmount(registrationAmount,pl);
		validateDuplicate(validEmail, customers);
		customers.put(validEmail,new Customer(firstName, lastName, validEmail, password, regAmount, date, pl));
		System.out.println("Registered Successfully");
	}
	
	public Customer getCustomerByEmail(String email) throws CustomerExeption {
		Customer c = customers.get(email);
		if(c==null)
			throw new CustomerExeption("Invalid email address");
		return c;
	}
	
	@Override
	public void signIn(String email,String password) throws CustomerExeption {
		String validEmail = validateEmail(email);
		Customer c = getCustomerByEmail(validEmail);
		if(c.getPassword().equals(password)) {
			System.out.println("Login successful");
		}else
			throw new CustomerExeption("Wrong password");
	}
	
	@Override
	public void changePassword(String email,String oldPassword,String newPassword) throws CustomerExeption{
		String validEmail = validateEmail(email);
		Customer c = getCustomerByEmail(validEmail);
		if(c.getPassword().equals(oldPassword) && validatePassword(oldPassword,newPassword)) {
			c.setPassword(newPassword);
			System.out.println("Password Changed successfully");
		}else
			throw new CustomerExeption("Something went wrong");
	}
	
	@Override
	public void unsubscribeCustomer(String email) throws CustomerExeption{
		String validEmail = validateEmail(email);
		Customer c = customers.remove(validEmail);
		if(c!=null)
			System.out.println("Unsubscribed plan");
		else
			throw new CustomerExeption("Invalid email address");
	}
	
	@Override
	public void displayAllCustomer() {
		for(Customer c: customers.values()) {
			System.out.println(c);
		}
	}
}
