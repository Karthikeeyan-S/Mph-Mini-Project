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

import com.pgaccomodation.Service.LocalityService;
import com.pgaccomodation.model.Locality;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/locality")
public class LocalityController {

    @Autowired
    private LocalityService localityService;

    @PostMapping("/add")
    @Operation(summary = "POST DETAILS OF LOCALITY")
    public Locality addLocality(@RequestBody Locality locality) {
        return localityService.addLocality(locality);
    }

    @GetMapping("/all")
    @Operation(summary = "GET DETAILS OF ALL LOCALITIES")
    public List<Locality> getAllLocalities() {
        return localityService.getAllLocalities();
    }

    @GetMapping("/{id}")
    @Operation(summary = "GET DETAILS OF BY LOCALITY ID")
    public Locality getLocalityById(@PathVariable Long id) {
       return localityService.getLocalityById(id);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "DELETE DETAILS OF LOCALITY BY LOCALITY ID")
    public String deleteLocality(@PathVariable Long id) {
        localityService.deleteLocality(id);
        return "Locality deleted successfully";
    }
}
