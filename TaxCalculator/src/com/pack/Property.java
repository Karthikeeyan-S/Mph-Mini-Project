package com.pack;
 
public class Property {
	public int getId() {
		return id;
	}
 
	public void setId(int id) {
		this.id = id;
	}
 
	private int id;
    private double baseValue;
    private double builtUpArea;
    private double age;
    private char location;
    private double propertyTax;
 
    // Default constructor
    public Property() {
    }
 
    // Parameterized constructor
    public Property(double baseValue, double builtUpArea, double age, char location, double propertyTax) {
        this.baseValue = baseValue;
        this.builtUpArea = builtUpArea;
        this.age = age;
        this.location = location;
        this.propertyTax = propertyTax;
    }
 
    // Getters and Setters
    public double getBaseValue() {
        return baseValue;
    }
 
    public void setBaseValue(double baseValue) {
        this.baseValue = baseValue;
    }
 
    public double getBuiltUpArea() {
        return builtUpArea;
    }
 
    public void setBuiltUpArea(double builtUpArea) {
        this.builtUpArea = builtUpArea;
    }
 
    public double getAge() {
        return age;
    }
 
    public void setAge(double age) {
        this.age = age;
    }
 
    public char getLocation() {
        return location;
    }
 
    public void setLocation(char location) {
        this.location = location;
    }
 
    public double getPropertyTax() {
        return propertyTax;
    }
 
    public void setPropertyTax(double propertyTax) {
        this.propertyTax = propertyTax;
    }
 
    // toString method
    @Override
    public String toString() {
        return "Property{" +
                "baseValue=" + baseValue +
                ", builtUpArea=" + builtUpArea +
                ", age=" + age +
                ", location=" + location +
                ", propertyTax=" + propertyTax +
                '}';
    }
}