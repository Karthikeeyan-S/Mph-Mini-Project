package com.pack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import com.pack.Vehicle.FuelType;

public class Main {
	static private HashMap<String, String> users = new HashMap<>();
	static HashMap<String, List<Property>> properties = new HashMap<>();
	static HashMap<String, List<Vehicle>> vehicles = new HashMap<>();

	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int vehicleId = 0;
			int propertyId = 0;
			users.put("karthi","karthi123");
			users.put("harsh","harsh123");
			users.put("haricharan","hari123");
			
			boolean logoutKey = true;
			
			while (true) {
				System.out.println("+----------------------------------------------------------------+");
				System.out.println("|		WELCOME TO TAX CALCULATION APP                   |");
				System.out.println("+----------------------------------------------------------------+");
				System.out.println("PLEASE LOGIN TO CONTINUE - ");
				
				System.out.print("USERNAME : ");
				String username = sc.next();
				System.out.print("PASSWORD : ");
				String password = sc.next();
				// Login function
				
				boolean loginAttempt = false;
				
				if(users.containsKey(username) && users.get(username).equals(password))
					loginAttempt = true;
				else
					loginAttempt = false;
				
				properties.put(username, new ArrayList<Property>());
				vehicles.put(username, new ArrayList<Vehicle>());
				boolean vflag = true;
				boolean pflag = true;
				while (loginAttempt) {
					vflag = true;
					pflag = true;
					System.out.println("1: PROPERTY TAX");
					System.out.println("2: VEHICLE TAX");
					System.out.println("3: TOTAL");
					System.out.print("4: EXIT");
					int choice = sc.nextInt();
					int innerChoice;
	 
					switch (choice) {
	 
					case 1: {
						while (pflag) {
							System.out.println("1: ADD PROPERTY DETAILS");
							System.out.println("2: CALCULATE PROPERTY TAX");
							System.out.println("3: DISPLAY ALL PROPERTIES");
							System.out.print("4: BACK TO MAIN MENU");
							innerChoice = sc.nextInt();
	 
							switch (innerChoice) {
							case 1: {
								Property p = new Property();
								p.setId(propertyId++);
								System.out.println("ENTER THE PROPERTY DETAILS");
								System.out.print("ENTER THE BASE VALUE OF LAND");
								p.setBaseValue(sc.nextDouble());
								System.out.print("ENTER THE BUILD UP AREA OF LAND");
								p.setBuiltUpArea(sc.nextDouble());
								System.out.print("ENTER THE AGE OF LAND");
								p.setAge(sc.nextDouble());
								System.out.print("LAND LOCATED YES Y OR NO N");
								p.setLocation(sc.next().charAt(0));
								properties.get(username).add(p);
								break;
	 
							}
							case 2: {
								displayProperties(username);
								System.out.print("ENTER THE PROPERTY ID TO CALCULATE TAX ");
								int id = sc.nextInt();
								Property p = properties.get(username).stream().filter((i) -> i.getId() == id).findAny()
										.get();
								p.setPropertyTax(calculatePropertyTax(p));
								System.out.println("PROPERTY TAX FOR ID " + id + "IS " + calculatePropertyTax(p));
								break;
	 
							}
							case 3: {
								displayProperties(username);
								break;
							}
							case 4: {
								pflag = false;
								break;
							}
							}
						}
						break;
					}
					case 2: {
						while (vflag) {
							System.out.println("1: ADD VEHICLE DETAILS");
							System.out.println("2: CALCULATE VEHICLE TAX");
							System.out.println("3: DISPLAY ALL VEHICLE");
							System.out.print("4: BACK TO MAIN MENU");
							innerChoice = sc.nextInt();
							switch (innerChoice) {
							case 1: {
	 
								Vehicle v = new Vehicle();
								v.setId(vehicleId++);
								System.out.print("ENTER THE VEHICLE REGISTERATION");
								v.setRegistrationNumber(sc.next());
								System.out.print("ENTER THE BRAND OF THE VEHICLE");
								v.setBrand(sc.next());
								System.out.print("ENTER THE MAXIMUM VELOCITY OF VEHICLE (KMPH)");
								v.setMaxSpeed(sc.nextInt());
								System.out.print("ENTER THE CAPACITY(NUMBER OF SEATS) IN VEHICLE");
								v.setMaxCapacity(sc.nextInt());
								System.out.println("CHOOSE THE TYPE OF VEHICLE");
								System.out.println("1: PETROL DRIVEN");
								System.out.println("2: DISEL DRIVEN");
								System.out.println("3: CNG/LPG");
								int vehicleChoice = sc.nextInt();
	 
								switch (vehicleChoice) {
								case 1: {
									v.setType(FuelType.PETROL);
									break;
	 
								}
								case 2: {
									v.setType(FuelType.DIESEL);
									break;
								}
								case 3: {
									v.setType(FuelType.CNG);
									break;
								}
									
								}
								System.out.print("ENTER THE PURCHASE COST OF VEHICLE ");
								v.setPurchaseCost(sc.nextInt());
								vehicles.get(username).add(v);
								break;
							}
							case 2: {
	 
								displayVehicle(username);
								System.out.print("ENTER THE REGISTRATION ID TO CALCULATE TAX ");
								String registrationNumber = sc.next();
								Vehicle v = vehicles.get(username).stream()
										.filter((i) -> i.getRegistrationNumber().equals(registrationNumber)).findAny().get();
								v.setVehicleTax(calculateVehicleTax(v));
								System.out.println("PROPERTY TAX FOR REGISTRATION NUMBER " + registrationNumber + "IS "
										+ calculateVehicleTax(v));
								break;
	 
							}
							case 3: {
								displayVehicle(username);
								break;
							}
							case 4: {
								vflag = false;
								break;
							}
							}
						}
					}
					// FROM CASE 3
					case 3:{
						displayTotal(username);
						break;
					}
					case 4:{
						loginAttempt=false;
						break;
					}
					}
				}
			}
		}
	 
		private static double calculateVehicleTax(Vehicle v) {
			/*
			 * Calculate the vehicle tax using the following formula: 1. Petrol-driven
			 * vehicles: Vehicle tax = velocity + capacity + 10% of purchase cost 2.
			 * Diesel-driven vehicles: Vehicle tax = velocity + capacity + 11% of purchase
			 * cost 3. CNG/LPG-driven vehicles: Vehicle tax = velocity + capacity + 12% of
			 * purchase cost
			 */
	 
			double tax = 0.0;
			double velocity = v.getMaxSpeed();
			double capacity = v.getMaxCapacity();
			double cost = v.getPurchaseCost();
	 
			switch (v.getType()) {
			case PETROL:
				tax = velocity + capacity + (0.10 * cost);
				break;
			case DIESEL:
				tax = velocity + capacity + (0.11 * cost);
				break;
			case CNG:
				tax = velocity + capacity + (0.12 * cost);
				break;
			default:
				System.out.println("Unknown fuel type!");
				break;
			}
	 
			return tax;
		}
	 
		private static void displayVehicle(String username) {
			// TODO Auto-generated method stub
			List<Vehicle> userVehicles = vehicles.get(username);
			ConsoleTable.printVehicleTable(userVehicles);
	 
		}
	 
		private static void displayProperties(String username) {
			// TODO Auto-generated method stub
			// Write Table Display Methods
			List<Property> userProperties = properties.get(username);
			ConsoleTable.printPropertyTable(userProperties);
	 
		}
	 
		private static Double calculatePropertyTax(Property p) {
			/*
			 * Calculate property tax using the following formula: 1. If property is in the
			 * main city: Property tax = (builtUpArea × age × baseValue) + (½ × builtUpArea)
			 * 2. If property is not in the city: Property tax = builtUpArea × age ×
			 * baseValue
			 *
			 * Assume: 'location' == 'M' means Main City
			 */
	 
			double tax;
			double builtUpArea = p.getBuiltUpArea();
			double age = p.getAge();
			double baseValue = p.getBaseValue();
			char location = Character.toUpperCase(p.getLocation());
	 
			if (location == 'Y') {
				tax = (builtUpArea * age * baseValue) + (0.5 * builtUpArea);
			} else {
				tax = builtUpArea * age * baseValue;
			}
	 
			return tax;
		}
		
		private static void displayTotal(String username) {
			 
			List<Property> userProps = properties.get(username);
			double totalTaxProperty=0;
			if (userProps != null) {
				for (Property prop : userProps) {
					totalTaxProperty += prop.getPropertyTax();
				}
			}	
			
			
			List<Vehicle> userVeh = vehicles.get(username);
			int totalTaxVehicle=0;
			if (userVeh != null) {
				for (Vehicle veh : userVeh) {
					totalTaxVehicle += veh.getVehicleTax();
				}
			}	
			
			ConsoleTable.printSummaryTable(userProps.size(), totalTaxProperty, userVeh.size(), totalTaxVehicle);
		}
	 
	}

	
	

