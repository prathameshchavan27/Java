package com.customer.core;

import java.time.LocalDate;

public class Customer {
	private static int idCounter = 100;
	private int customerId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private double registrationAmount;
	private LocalDate dob;
	private ServicePlan plan;
	

	public Customer(String firstName, String lastName, String email, String password,
			double registrationAmount, LocalDate dob, ServicePlan plan) {
		super();
		this.customerId = ++idCounter;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.registrationAmount = registrationAmount;
		this.dob = dob;
		this.plan = plan;
	}
	
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", password=" + password + ", registrationAmount=" + registrationAmount + ", dob=" + dob
				+ ", plan=" + plan + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		return this.email.equals(((Customer)obj).email);
	}
	
	@Override
	public int hashCode() {
		return email.hashCode();
	}

	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}
	
}
