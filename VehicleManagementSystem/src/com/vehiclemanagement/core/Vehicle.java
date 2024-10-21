package com.vehiclemanagement.core;

import java.time.LocalDate;

public class Vehicle {
	private int chasisNo;
	private double price;
	private double discount;
	private Color color;
	private LocalDate manufacturedDate;
	private String deliveryAddress;

	public Vehicle(int chasisNo, double price, double discount, Color color, LocalDate manufacturedDate) {
		super();
		this.chasisNo = chasisNo;
		this.price = price;
		this.discount = discount;
		this.color = color;
		this.manufacturedDate = manufacturedDate;
	}
	
	public Color getColor() {
		return color;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getChasisNo() {
		return chasisNo;
	}

	

	@Override
	public String toString() {
		return "Vehicle [chasisNo=" + chasisNo + ", price=" + price + ", discount=" + discount + ", color=" + color
				+ ", manufacturedDate=" + manufacturedDate + ", deliveryAddress=" + deliveryAddress + "]";
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
}
