package com.pgaccomodation.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pgaccomodation.DTO.OwnerDto;
import com.pgaccomodation.DTO.PGResponseDto;
import com.pgaccomodation.Service.PGPlaceService;
import com.pgaccomodation.model.Owner;
import com.pgaccomodation.model.PGPlace;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/pg")
public class PGPlaceController {

    @Autowired
    private PGPlaceService pgPlaceService;

    @GetMapping("/city/{cityName}")
    @Operation(summary = "GET AVAILABLE PG's BY CITY")
    public List<PGResponseDto> getPGsByCity(@PathVariable String cityName) {
        return pgPlaceService.getAvailablePGsByCity(cityName);
    }

    @GetMapping("/locality/{locality}")
    @Operation(summary = "GET AVAILABLE PG's BY LOCALITY")
    public List<PGResponseDto> getPGsByLocality(@PathVariable String locality) {
        return pgPlaceService.getAvailablePGsByLocality(locality);
    }

    @GetMapping("/details/{id}")
    @Operation(summary = "GET PG DETAILS BY PG ID")
    public PGResponseDto getPGDetails(@PathVariable Long id) {
        return pgPlaceService.getPGDetails(id); 
    }


    @GetMapping("/owner/{id}")
    @Operation(summary = "GET OWNER DETAILS BY OWNER ID")
    public OwnerDto getOwnerDetails(@PathVariable Long id) {
        return pgPlaceService.getOwnerDetails(id);
    }

   

    

    
}
