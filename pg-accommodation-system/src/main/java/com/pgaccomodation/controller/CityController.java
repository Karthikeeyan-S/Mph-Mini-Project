package com.pgaccomodation.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pgaccomodation.Service.CityService;
import com.pgaccomodation.model.City;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityService cityService;

    @PostMapping("/add")
    @Operation(summary = "ADD DETAILS OF CITY")
    public City addCity(@RequestBody City city) {
        return cityService.addCity(city);
    }

    @GetMapping("/all")
    @Operation(summary = "GET ALL CITY DETAILS")
    public List<City> getAllCities() {
        return cityService.getAllCities();
    }

    @GetMapping("/{id}")
    @Operation(summary = "GET DETAILS OF CITY BY ID")
    public City getCityById(@PathVariable Long id) {
        return cityService.getCityById(id);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "DELETE DETAILS OF CITY BY ID")
    public String deleteCity(@PathVariable Long id) {
        cityService.deleteCity(id);
        return "City deleted successfully";
    }
}
