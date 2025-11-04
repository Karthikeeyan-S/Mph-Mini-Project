package com.pgaccomodation.controller;

import java.util.List;
import java.util.Optional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

import com.pgaccomodation.DTO.OwnerDto;
import com.pgaccomodation.DTO.PGResponseDto;
import com.pgaccomodation.Service.OwnerService;
import com.pgaccomodation.Service.PGPlaceService;
import com.pgaccomodation.model.Owner;
import com.pgaccomodation.model.PGPlace;

import io.swagger.v3.oas.annotations.Operation;
 
@RestController
@RequestMapping("/owner")
public class OwnerController {
	@Autowired
	OwnerService ownerService;
	
	@Autowired
	PGPlaceService pgPlaceService;
	
	
	@PostMapping("/register")
	@Operation(summary = "REGISTER FOR OWNER")
	public ResponseEntity<Owner> registerOwner(@RequestBody Owner owner){
		if(owner ==  null)
			return new ResponseEntity<>(owner,HttpStatus.NOT_ACCEPTABLE);
		else
			ownerService.registerOwner(owner);
			return new ResponseEntity<>(owner,HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	@Operation(summary = "GET OWNER DETAILS BY OWNER ID")
	public ResponseEntity<OwnerDto> fetchOwnerById(@PathVariable Long id) {
	    OwnerDto owner = ownerService.getByOwnerId(id);
	    return new ResponseEntity<>(owner, HttpStatus.OK);
	}
	
	@GetMapping("/places/{id}")
	@Operation(summary = "GET PG DETAILS BY OWNER ID")
	public ResponseEntity<List<PGResponseDto>> fetchPgByOwnerId(@PathVariable Long id) {
	    List<PGResponseDto> pgList = ownerService.getPgbyOwnerId(id);
	    return new ResponseEntity<>(pgList, HttpStatus.OK);
	}

	@PostMapping("/places/add")
	@Operation(summary = "POST PG DETAILS")
	public PGResponseDto addPGPlace(@RequestBody PGPlace pgPlace) {
	    PGResponseDto saved = pgPlaceService.addPGPlace(pgPlace);
	    return saved;
	}
	 
	@PutMapping("/places/update/{id}")
	@Operation(summary = "UPDATE AVAILABILITY STATUS OF PG") 
	public PGResponseDto updateAvailability(@PathVariable Long id, @RequestParam boolean status){
		return pgPlaceService.updateAvailability(id, status);
	}
	
	@PutMapping("/places/edit")
	@Operation(summary = "UPDATE DETAILS OF PG")
	public PGResponseDto editPGPlace(@RequestBody PGPlace pgPlace) {
		return pgPlaceService.editPGPlace(pgPlace);
	}

	@DeleteMapping("/places/delete/{id}")
	@Operation(summary = "DELETE DETAILS OF PG")
	public String deletePGPlace(@PathVariable Long id) {
		pgPlaceService.deletePGPlace(id);
		return "PG Place deleted successfully";
	}
	
}