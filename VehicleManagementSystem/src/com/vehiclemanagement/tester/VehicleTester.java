package com.vehiclemanagement.tester;

import java.util.Scanner;

import com.vehiclemanagement.operations.VehicleOperationsImpl;

public class VehicleTester {
	public static void main(String[] args) {
		boolean exit = false;
		VehicleOperationsImpl vops = new VehicleOperationsImpl();
		try(Scanner sc = new Scanner(System.in)){
			System.out.println("1. Add Vehicle\n2. Display All Vehicles\n"
					+ "3. Display vehicle by chasisNo\n4. Apply discount\n"
					+ "5. Purchase Vehicle\nEnter choice\n");
			while(!exit) {	
				try {
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter chasisno, price, discount, color, manufactured date");
						vops.addVehicle(sc.nextInt(), sc.nextDouble(), sc.nextDouble(), sc.next(), sc.next());
						break;
					case 2:
						System.out.println("Display all vehicles");
						vops.displayAllVehicle();
						break;
					case 3:
						System.out.println("Vehicle details");
						System.out.println(vops.getVehicleByChasisNo(sc.nextInt()));
						break;
					case 4:
						System.out.println("Enter color, discount");
						vops.applyDiscount(sc.next(), sc.nextDouble());
						break;
					case 5:
						System.out.println("Enter chasis no");
						int c = sc.nextInt();
						System.out.println("Enter delivery address");
						vops.purchaseVehicle(c,sc.next());
						break;
					case 0:
						exit = true;
						break;
					}
				}catch (Exception e) {
					// TODO: handle exception
					System.out.println(e);
					sc.nextLine();
				}
			}
		}
	}
}
