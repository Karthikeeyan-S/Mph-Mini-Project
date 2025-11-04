package com.pgaccomodation.model;

import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cityId;
    
    public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Locality> getLocalities() {
		return localities;
	}

	public void setLocalities(List<Locality> localities) {
		this.localities = localities;
	}

	public List<PGPlace> getPgPlaces() {
		return pgPlaces;
	}

	public void setPgPlaces(List<PGPlace> pgPlaces) {
		this.pgPlaces = pgPlaces;
	}

	private String name;

    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Locality> localities;
    
    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<PGPlace> pgPlaces;

    // Getters and Setters
}