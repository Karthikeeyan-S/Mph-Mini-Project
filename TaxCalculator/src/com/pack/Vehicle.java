package com.pack;

public class Vehicle {
    
    private String registrationNumber;
    private String brand;
    private Integer maxSpeed;
    private Integer maxCapacity;
    private FuelType type;
    private int purchaseCost;
    private double vehicleTax;
	public int getId() {
		return id;
	}
 
	public void setId(int id) {
		this.id = id;
	}
 
	private int id;
 
    // Enum for fuel type
    public enum FuelType {
        PETROL, DIESEL, CNG, LPG
    }
 
    // Default constructor
    public Vehicle() {
    }
 
    // Parameterized constructor
    public Vehicle(String registrationNumber, String brand, Integer maxSpeed, Integer maxCapacity,
                   FuelType type, int purchaseCost, double vehicleTax) {
        this.registrationNumber = registrationNumber;
        this.brand = brand;
        this.maxSpeed = maxSpeed;
        this.maxCapacity = maxCapacity;
        this.type = type;
        this.purchaseCost = purchaseCost;
        this.vehicleTax = vehicleTax;
    }
 
    // Getters and Setters
 
    public String getRegistrationNumber() {
        return registrationNumber;
    }
 
    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }
 
    public String getBrand() {
        return brand;
    }
 
    public void setBrand(String brand) {
        this.brand = brand;
    }
 
    public Integer getMaxSpeed() {
        return maxSpeed;
    }
 
    public void setMaxSpeed(Integer maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
 
    public Integer getMaxCapacity() {
        return maxCapacity;
    }
 
    public void setMaxCapacity(Integer maxCapacity) {
        this.maxCapacity = maxCapacity;
    }
 
    public FuelType getType() {
        return type;
    }
 
    public void setType(FuelType type) {
        this.type = type;
    }
 
    public int getPurchaseCost() {
        return purchaseCost;
    }
 
    public void setPurchaseCost(int purchaseCost) {
        this.purchaseCost = purchaseCost;
    }
 
    public double getVehicleTax() {
        return vehicleTax;
    }
 
    public void setVehicleTax(double vehicleTax) {
        this.vehicleTax = vehicleTax;
    }
 
    // toString method (optional but useful for debugging)
    @Override
    public String toString() {
        return "Vehicle{" +
                "registrationNumber='" + registrationNumber + '\'' +
                ", brand='" + brand + '\'' +
                ", maxSpeed=" + maxSpeed +
                ", maxCapacity=" + maxCapacity +
                ", type=" + type +
                ", purchaseCost=" + purchaseCost +
                ", vehicleTax=" + vehicleTax +
                '}';
    }
}