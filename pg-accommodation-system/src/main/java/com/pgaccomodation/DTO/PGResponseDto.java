package com.pgaccomodation.DTO;
 
public class PGResponseDto {
	
	private Long pgId;
	
	private Double builtUpArea;
	
	private int visitorCount;
	
	
	public int getVisitorCount() {
		return visitorCount;
	}

	public void setVisitorCount(int visitorCount) {
		this.visitorCount = visitorCount;
	}

	private Double rentAmount;
	
	private boolean availabilityStatus;
	private String registrationNumber;
	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	private String city;
	
	private String locality;
	
	private Long ownerId;
	
	private String ownerName;
 
	public Long getPgId() {
		return pgId;
	}
 
	public void setPgId(Long pgId) {
		this.pgId = pgId;
	}
 
	public Double getBuiltUpArea() {
		return builtUpArea;
	}
 
	public void setBuiltUpArea(Double builtUpArea) {
		this.builtUpArea = builtUpArea;
	}
 
	public Double getRentAmount() {
		return rentAmount;
	}
 
	public void setRentAmount(Double rentAmount) {
		this.rentAmount = rentAmount;
	}
 
	public boolean isAvailabilityStatus() {
		return availabilityStatus;
	}
 
	public void setAvailabilityStatus(boolean availabilityStatus) {
		this.availabilityStatus = availabilityStatus;
	}
 
	public String getCity() {
		return city;
	}
 
	public void setCity(String city) {
		this.city = city;
	}
 
	public String getLocality() {
		return locality;
	}
 
	public void setLocality(String locality) {
		this.locality = locality;
	}
 
	public Long getOwnerId() {
		return ownerId;
	}
 
	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}
 
	public String getOwnerName() {
		return ownerName;
	}
 
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
 
	public PGResponseDto(Long pgId, Double builtUpArea, Double rentAmount, boolean availabilityStatus, String city,
			String locality, long ownerId, String ownerName) {
		this.pgId = pgId;
		this.builtUpArea = builtUpArea;
		this.rentAmount = rentAmount;
		this.availabilityStatus = availabilityStatus;
		this.city = city;
		this.locality = locality;
		this.ownerId = ownerId;
		this.ownerName = ownerName;
	}
 
	public PGResponseDto() {
 
	}
	
	
	
}