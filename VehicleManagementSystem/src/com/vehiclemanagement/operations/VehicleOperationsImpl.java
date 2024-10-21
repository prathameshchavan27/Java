package com.vehiclemanagement.operations;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.vehiclemanagement.core.Color;
import com.vehiclemanagement.core.Vehicle;
import com.vehiclemanagement.custom_exceptions.VehicleException;

import static com.vehiclemanagement.validations.VehicleValidations.*;

public class VehicleOperationsImpl implements VehicleOperations {
	
	private Map<Integer, Vehicle> vehicles;
	
	public VehicleOperationsImpl() {
		vehicles = new HashMap<>();
		Vehicle v1 = new Vehicle(1, 80000, 0, Color.RED, LocalDate.parse("2024-09-09"));
		Vehicle v2 = new Vehicle(2, 80000, 0, Color.RED, LocalDate.parse("2024-09-09"));
		Vehicle v3 = new Vehicle(3, 80000, 0, Color.GREY, LocalDate.parse("2024-09-09"));
		vehicles.put(1,v1);
		vehicles.put(2,v2);
		vehicles.put(3,v3);
	}
	
	@Override
	public void addVehicle(int chasisNo,double price, double discount,String color,String manufacturedDate) throws VehicleException {
		Color c = Color.valueOf(color.toUpperCase());
		validateDuplicate(chasisNo,vehicles);
		validatePrice(price);
		LocalDate date = validateManufacturedDate(manufacturedDate);
		vehicles.put(chasisNo, new Vehicle(chasisNo, price, discount,c, date));
		System.out.println("Added vehicle");
	}
	
	@Override
	public Vehicle getVehicleByChasisNo(int chasisNo) throws VehicleException {
		Vehicle v = vehicles.get(chasisNo);
		if(v==null)
			throw new VehicleException("Vehicle not found");
		return v;
	}
	
	@Override
	public void applyDiscount(String color,double discount) throws VehicleException{
		for(Vehicle v: vehicles.values()) {
			if(v.getColor().name().equals(color.toUpperCase())) {
				v.setPrice(v.getPrice()-v.getPrice()*(discount/100));
				v.setDiscount(discount);
				System.out.println(v);
			}
		}
	}
	
	@Override
	public void purchaseVehicle(int chasisNo,String address) throws VehicleException {
		Vehicle v = getVehicleByChasisNo(chasisNo);
		if(v==null || v.getDeliveryAddress()!=null)
			throw new VehicleException("Vehicle Sold");			
		System.out.println("Successful purchase\n"+v);
		
	}
	
	@Override
	public void displayAllVehicle() {
		for(Vehicle v: vehicles.values()) {
			System.out.println(v);;
		}
	}
}
