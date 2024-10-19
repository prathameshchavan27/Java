package com.customer.core;

public enum ServicePlan {
	SILVER(1000),GOLD(2000),DIAMOND(5000),PLATINUM(10000);
	private double amount;
	ServicePlan(double amount){
		this.amount = amount;
	}
	
	public double getAmount() {
		return amount;
	}

	@Override
	public String toString() {
		return name().toLowerCase()+ " amount: "+amount;
	}	
}	
