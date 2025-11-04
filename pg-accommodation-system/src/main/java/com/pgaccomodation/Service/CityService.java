package com.pgaccomodation.Service;


import java.util.List;

import com.pgaccomodation.model.City;

public interface CityService {
	public City addCity(City city);
	public List<City> getAllCities();
	public City getCityById(Long cityId);
	public void deleteCity(Long cityId);
}

