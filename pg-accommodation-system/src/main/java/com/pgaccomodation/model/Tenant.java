package com.pgaccomodation.model;

import jakarta.persistence.*;

@Entity
public class Tenant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tenantId;
 
    private String name;
    private int age;
    private String contactNo;
 
    @OneToOne
    @JoinColumn(name = "pg_id")
    private PGPlace pg; // Nullable if tenant doesn't have a PG

	public Long getTenantId() {
		return tenantId;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public PGPlace getPg() {
		return pg;
	}

	public void setPg(PGPlace pg) {
		this.pg = pg;
	}

	public Tenant(Long tenantId, String name, int age, String contactNo, PGPlace pg) {
		this.tenantId = tenantId;
		this.name = name;
		this.age = age;
		this.contactNo = contactNo;
		this.pg = pg;
	}

	public Tenant() {
		// TODO Auto-generated constructor stub
	}
 
    // Getters and setters
    
}