package com.vehiclemanagement.validations;

import java.util.Map;

import com.vehiclemanagement.core.Vehicle;
import com.vehiclemanagement.custom_exceptions.VehicleException;

public class VehicleValidations {
	public static void validateDuplicate(int chasisNo,Map<Integer, Vehicle> vehicles) throws VehicleException{
		Vehicle c = vehicles.get(chasisNo);
		if(c!=null && c.getChasisNo()==chasisNo) {
			throw new VehicleException("Car already exists");
		}
	}
	
	public static void validatePrice(double price) throws VehicleException{
		if(price<10000 || price>100000) {
			throw new VehicleException("Enter price in range 10000 - 100000");
		}
	}
}
