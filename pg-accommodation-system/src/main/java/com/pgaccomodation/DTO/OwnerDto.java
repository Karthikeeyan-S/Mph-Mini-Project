package com.pgaccomodation.DTO;


public class OwnerDto {
    public Long getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getmobile() {
		return mobile;
	}
	public void setmobile(String mobile) {
		this.mobile = mobile;
	}
	private Long ownerId;
    private String name;
    private String mobile;
    // Add other fields as needed
}
