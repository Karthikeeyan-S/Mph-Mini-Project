package com.pgaccomodation.Service.Impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pgaccomodation.Service.CityService;
import com.pgaccomodation.exception.ResourceNotFoundException;
import com.pgaccomodation.model.City;
import com.pgaccomodation.repository.CityRepository;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public City addCity(City city) {
        return cityRepository.save(city);
    }

    @Override
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    @Override
    public City getCityById(Long cityId) {
        return cityRepository.findById(cityId)
                .orElseThrow(() -> new ResourceNotFoundException("City not found with ID: " + cityId));
    }

    @Override
    public void deleteCity(Long cityId) {
        cityRepository.deleteById(cityId);
    }
}
