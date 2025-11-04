package com.pgaccomodation.Service.Impl;
 
import java.util.List;
import java.util.Optional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pgaccomodation.DTO.OwnerDto;
import com.pgaccomodation.DTO.PGResponseDto;
import com.pgaccomodation.Service.OwnerService;
import com.pgaccomodation.Service.PGPlaceService;
import com.pgaccomodation.model.Owner;
import com.pgaccomodation.model.PGPlace;
import com.pgaccomodation.repository.OwnerRepository;
 
@Service
public class OwnerServiceImpl implements OwnerService {
 
	public class DtoConverter {
	    public static PGResponseDto convertToDto(PGPlace pg) {
	        PGResponseDto dto = new PGResponseDto();
	        dto.setPgId(pg.getPgId());
	        dto.setRegistrationNumber(pg.getRegistrationNumber());
	        dto.setBuiltUpArea(pg.getBuiltUpArea());
	        dto.setRentAmount(pg.getRentAmount());
	        dto.setAvailabilityStatus(pg.getAvailabilityStatus());
	        dto.setVisitorCount(pg.getVisitorCount());
	        dto.setCity(pg.getCity().getName());
	        dto.setLocality(pg.getLocality().getName());
	        dto.setOwnerName(pg.getOwner().getName());
	        dto.setOwnerId(pg.getOwner().getOwnerId());
	        return dto;
	    }
	}
	@Autowired
	OwnerRepository ownerRepo;
	@Autowired
	private PGPlaceService pgPlaceService;
	@Override
	public String registerOwner(Owner owner) {
		ownerRepo.save(owner);
		return "Registration Successful!";
	}
 

@Override
public OwnerDto getByOwnerId(long ownerId) {
    Owner owner = ownerRepo.findById(ownerId)
        .orElseThrow(() -> new RuntimeException("Owner not found with id : " + ownerId));

    OwnerDto dto = new OwnerDto();
    dto.setOwnerId(owner.getOwnerId());
    dto.setName(owner.getName());
    dto.setmobile(owner.getmobile());
    return dto;
}

 
@Override
public List<PGResponseDto> getPgbyOwnerId(long ownerId) {
	Owner owner = ownerRepo.findById(ownerId)
		    .orElseThrow(() -> new RuntimeException("Owner not found with id : " + ownerId));


return owner.getPg().stream()
    .map(DtoConverter::convertToDto) 
    .toList();
 
}
}