package com.pack;

import java.util.List;

public class ConsoleTable {
    private static final String LINEP = "==================================================================================";
    private static final String LINEV = "===================================================================================================================";

    // ---------- Property Table ----------
    private static final String PROPERTY_FORMAT = "%5s %15s %15s %12s %10s %15s%n";

    public static void printPropertyTable(List<Property> properties) {
        System.out.println(LINEP);
        System.out.printf(PROPERTY_FORMAT, "ID", "BUILD-UP AREA", "BASE AREA", "AGE(YRS)", "IN CITY", "PROPERTY TAX");
        System.out.println(LINEP);
        for (Property p : properties) {
            System.out.printf(PROPERTY_FORMAT, 
                    p.getId(), 
                    p.getBaseValue(), 
                    p.getBuiltUpArea(), 
                    p.getAge(), 
                    p.getLocation(), 
                    p.getPropertyTax());
        }
        System.out.println(LINEP);
    }

    // ---------- Vehicle Table ----------
    private static final String VEHICLE_FORMAT = "%15s %15s %15s %15s %15s %15s %15s%n";

    public static void printVehicleTable(List<Vehicle> vehicles) {
        System.out.println(LINEV);
        System.out.printf(VEHICLE_FORMAT,
                "REG NO.", "BRAND", "MAX VELOCITY", "SEATS", "TYPE", "PURCHASE COST", "VEHICLE TAX");
        System.out.println(LINEV);
        for (Vehicle v : vehicles) {
            System.out.printf(VEHICLE_FORMAT,
                    v.getRegistrationNumber(),
                    v.getBrand(),
                    v.getMaxSpeed(),
                    v.getMaxCapacity(),
                    v.getType(),
                    v.getPurchaseCost(),
                    v.getVehicleTax());
        }
        System.out.println(LINEV);
    }
    
    public static void printSummaryTable(int propertyCount, double totalPropertyTax,
            int vehicleCount, double totalVehicleTax) {

		// Compute totals
		int totalItems = propertyCount + vehicleCount;
		double totalTax = totalPropertyTax + totalVehicleTax;
		
		String LINE = "+-------------------------------------------------------------------------------------------+";
		String FORMAT = "| %8s %15s %15s %20s %15s |%n";
		
		System.out.println(LINE);
		System.out.printf("| %8s %15s %15s %20s %15s             |%n", "SR. NO.", "PARTICULAR", "QUANTITY", "", "TAX");
		System.out.println(LINE);
		
		System.out.printf("| %8d %15s %15d %20s %15.2f             |%n", 1, "PROPERTIES", propertyCount, "", totalPropertyTax);
		System.out.printf("| %8d %15s %15d %20s %15.2f             |%n", 2, "VEHICLES", vehicleCount, "", totalVehicleTax);
		 
		System.out.println(LINE);
		System.out.printf("| %8s %15s %15d %20s %15.2f             |%n", "TOTAL", "----------", totalItems, "", totalTax);
		System.out.println(LINE);
}
}
