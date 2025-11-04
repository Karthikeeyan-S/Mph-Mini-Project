package com.pgaccomodation.Service.Impl;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pgaccomodation.DTO.*;
import com.pgaccomodation.Service.PGPlaceService;
import com.pgaccomodation.exception.ResourceNotFoundException;
import com.pgaccomodation.model.*;
import com.pgaccomodation.model.PGPlace;
import com.pgaccomodation.repository.*;

@Service
public class PGPlaceServiceImpl implements PGPlaceService {


	@Override
	public PGResponseDto convertToDto(PGPlace pg) {
	    PGResponseDto dto = new PGResponseDto();
	    dto.setPgId(pg.getPgId());
	    dto.setRegistrationNumber(pg.getRegistrationNumber());
	    dto.setRentAmount(pg.getRentAmount());
	    dto.setBuiltUpArea(pg.getBuiltUpArea());
	    dto.setAvailabilityStatus(pg.getAvailabilityStatus());
	    dto.setCity(pg.getCity() != null ? pg.getCity().getName() : "Unknown");
	    dto.setLocality(pg.getLocality() != null ? pg.getLocality().getName() : "Unknown");
	    dto.setOwnerName(pg.getOwner() != null ? pg.getOwner().getName() : "Unknown");
	    dto.setOwnerId(pg.getOwner() != null ? pg.getOwner().getOwnerId() : null);

  

	    return dto;
	}
    @Autowired
    private PGPlaceRepository pgPlaceRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private LocalityRepository localityRepository;

    @Autowired
    private OwnerRepository ownerRepository;

    @Override
    public PGResponseDto addPGPlace(PGPlace pgPlace) {
        City city = cityRepository.findById(pgPlace.getCity().getCityId())
            .orElseThrow(() -> new ResourceNotFoundException("City not found"));

        Locality locality = localityRepository.findById(pgPlace.getLocality().getLocalityId())
            .orElseThrow(() -> new ResourceNotFoundException("Locality not found"));

        Owner owner = ownerRepository.findById(pgPlace.getOwner().getOwnerId())
            .orElseThrow(() -> new ResourceNotFoundException("Owner not found"));

        pgPlace.setCity(city);
        pgPlace.setLocality(locality);
        pgPlace.setOwner(owner);


        PGPlace savedPGPlace = pgPlaceRepository.save(pgPlace);

        // Convert to PGResponseDto
	    PGResponseDto responseDto = new PGResponseDto();
	    responseDto.setPgId(savedPGPlace.getPgId());
	    responseDto.setRegistrationNumber(savedPGPlace.getRegistrationNumber());
	    responseDto.setBuiltUpArea(savedPGPlace.getBuiltUpArea());
	    responseDto.setRentAmount(savedPGPlace.getRentAmount());
	    responseDto.setAvailabilityStatus(savedPGPlace.getAvailabilityStatus());
	    responseDto.setVisitorCount(savedPGPlace.getVisitorCount());
	    responseDto.setCity(savedPGPlace.getCity().getName());
	    responseDto.setLocality(savedPGPlace.getLocality().getName());
	    responseDto.setOwnerName(savedPGPlace.getOwner().getName());

	    return responseDto;

    }


    @Override
    public List<PGResponseDto> getAvailablePGsByCity(String cityName) {
    	List<PGPlace> pgs = pgPlaceRepository.findByCity_NameAndAvailabilityStatusTrue(cityName);
    	 
        if (pgs.isEmpty()) {
            throw new ResourceNotFoundException("No PGs available in city: " + cityName);
        }
     
        return pgs.stream()
                  .map(this::convertToDto)
                  .toList();
        }

    
    @Override
    public List<PGResponseDto> getAvailablePGsByLocality(String localityName) {
        return pgPlaceRepository.findByLocality_NameAndAvailabilityStatusTrue(localityName)
                .stream()
                .map(this::convertToDto)
                .toList();
    }


	@Override
	public PGResponseDto getPGDetails(Long pgId) {
	    PGPlace pgPlace = pgPlaceRepository.findById(pgId)
	        .orElseThrow(() -> new ResourceNotFoundException("PG Place not found with ID: " + pgId));
	
	    return convertToDto(pgPlace);
	}
	
	
	
	@Override
	public OwnerDto getOwnerDetails(Long pgId) {
	    PGPlace pg = pgPlaceRepository.findById(pgId)
	        .orElseThrow(() -> new ResourceNotFoundException("PG Place not found with ID: " + pgId));
	
	    Owner owner = pg.getOwner();
	
	    OwnerDto dto = new OwnerDto();
	    dto.setOwnerId(owner.getOwnerId());
	    dto.setName(owner.getName());
	    dto.setmobile(owner.getmobile());
	    return dto;
	}
	
	
	
	@Override
	public PGResponseDto updateAvailability(Long pgId, boolean status) {
	    PGPlace pg = pgPlaceRepository.findById(pgId)
	        .orElseThrow(() -> new ResourceNotFoundException("PG Place not found with ID: " + pgId));
	
	    pg.setAvailabilityStatus(status);
	    PGPlace updated = pgPlaceRepository.save(pg);
	
	    return convertToDto(updated);
	}
	
	
	
	@Override
	public PGResponseDto editPGPlace(PGPlace pgPlace) {
	    PGPlace existing = pgPlaceRepository.findById(pgPlace.getPgId())
	        .orElseThrow(() -> new ResourceNotFoundException("PG Place not found with ID: " + pgPlace.getPgId()));
	    existing.setRegistrationNumber(pgPlace.getRegistrationNumber());
	    existing.setBuiltUpArea(pgPlace.getBuiltUpArea());
	    existing.setRentAmount(pgPlace.getRentAmount());
	    existing.setAvailabilityStatus(pgPlace.getAvailabilityStatus());
	    existing.setVisitorCount(pgPlace.getVisitorCount());
	    existing.setCity(cityRepository.findById(pgPlace.getCity().getCityId())
	        .orElseThrow(() -> new ResourceNotFoundException("City not found")));
	    existing.setLocality(localityRepository.findById(pgPlace.getLocality().getLocalityId())
	        .orElseThrow(() -> new ResourceNotFoundException("Locality not found")));
	    existing.setOwner(ownerRepository.findById(pgPlace.getOwner().getOwnerId())
	        .orElseThrow(() -> new ResourceNotFoundException("Owner not found")));
	
	    PGPlace updated = pgPlaceRepository.save(existing);
	    return convertToDto(updated);
	}


    @Override
    public void deletePGPlace(Long pgId) {
        pgPlaceRepository.deleteById(pgId);
    }
}


