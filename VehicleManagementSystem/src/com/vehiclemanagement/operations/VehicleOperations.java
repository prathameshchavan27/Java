package com.vehiclemanagement.operations;

import com.vehiclemanagement.core.Vehicle;
import com.vehiclemanagement.custom_exceptions.VehicleException;

public interface VehicleOperations {
	public void addVehicle(int chasisNo, double price, double discount,String color, String manufacturedDate)
			throws VehicleException;
	
	public Vehicle getVehicleByChasisNo(int chasisNo) throws VehicleException;
	
	public void applyDiscount(String color,double discount) throws VehicleException;
	
	void displayAllVehicle();


	void purchaseVehicle(int chasisNo, String address) throws VehicleException;
	
	
}
