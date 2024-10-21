package com.vehiclemanagement.validations;

import java.time.LocalDate;
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
	public static LocalDate validateManufacturedDate(String date) throws VehicleException{
		LocalDate d = LocalDate.parse(date);
		if(d.isBefore(LocalDate.parse("2024-04-01")) || d.isAfter(LocalDate.parse("2025-03-31"))) {
			throw new VehicleException("Manufacturing date must be in current financial year");
		}
		return d;
	}
}
