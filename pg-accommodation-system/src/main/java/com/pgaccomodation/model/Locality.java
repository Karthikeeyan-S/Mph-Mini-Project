package com.pgaccomodation.model;

import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Locality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long localityId;

    private String name;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;
    
    @OneToMany(mappedBy = "locality", cascade = CascadeType.ALL)
    private List<PGPlace> pgPlaces;

	public Long getLocalityId() {
		return localityId;
	}

	public void setLocalityId(Long localityId) {
		this.localityId = localityId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public List<PGPlace> getPgPlaces() {
		return pgPlaces;
	}

	public void setPgPlaces(List<PGPlace> pgPlaces) {
		this.pgPlaces = pgPlaces;
	}

	public Locality() {
		// TODO Auto-generated constructor stub
	}

	public Locality(Long localityId, String name, City city, List<PGPlace> pgPlaces) {
		this.localityId = localityId;
		this.name = name;
		this.city = city;
		this.pgPlaces = pgPlaces;
	}

	
}
