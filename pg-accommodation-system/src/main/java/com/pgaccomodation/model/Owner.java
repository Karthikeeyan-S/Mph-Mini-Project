package com.pgaccomodation.model;
 
import jakarta.persistence.*;
 
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
 
@Entity
@Table(name = "Owner")
public class Owner {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ownerId;
 
    private String name;
 
    private String email;
 
    private String mobile;
 
    private int age;
 
    @OneToMany(mappedBy = "owner", cascade =CascadeType.ALL)
    private List<PGPlace> pg;
 
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
 
	public String getEmail() {
		return email;
	}
 
	public void setEmail(String email) {
		this.email = email;
	}
 
	public String getmobile() {
		return mobile;
	}
 
	public void setmobile(String mobile) {
		this.mobile = mobile;
	}
 
	public int getAge() {
		return age;
	}
 
	public void setAge(int age) {
		this.age = age;
	}
 
	public List<PGPlace> getPg() {
		return pg;
	}
 
	public void setPg(List<PGPlace> pg) {
		this.pg = pg;
	}
 
	public Owner(Long ownerId, String name, String email, String mobile, int age, List<PGPlace> pg) {
		this.ownerId = ownerId;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.age = age;
		this.pg = pg;
	}
 
	public Owner() {
		// TODO Auto-generated constructor stub
	}
    
    
 
}
 