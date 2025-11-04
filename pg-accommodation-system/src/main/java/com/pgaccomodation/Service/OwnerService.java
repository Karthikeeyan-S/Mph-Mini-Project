package com.pgaccomodation.Service;
 
import java.util.List;
import java.util.Optional;

import com.pgaccomodation.DTO.OwnerDto;
import com.pgaccomodation.DTO.PGResponseDto;
import com.pgaccomodation.model.Owner;
import com.pgaccomodation.model.PGPlace;
 
public interface OwnerService {
 

	    String registerOwner(Owner owner);
	    OwnerDto getByOwnerId(long ownerId);
	    List<PGResponseDto> getPgbyOwnerId(long ownerId); 
}