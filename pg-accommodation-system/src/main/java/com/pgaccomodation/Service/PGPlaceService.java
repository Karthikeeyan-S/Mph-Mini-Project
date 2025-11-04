package com.pgaccomodation.Service;

import java.util.List;
import java.util.Optional;

import com.pgaccomodation.DTO.OwnerDto;
import com.pgaccomodation.DTO.PGResponseDto;
import com.pgaccomodation.model.Owner;
import com.pgaccomodation.model.PGPlace;



public interface PGPlaceService {
	public PGResponseDto convertToDto(PGPlace pgPlace);
    public PGResponseDto addPGPlace(PGPlace pgPlace);
    public List<PGResponseDto> getAvailablePGsByCity(String cityName);
    public List<PGResponseDto> getAvailablePGsByLocality(String localityName);
    public PGResponseDto getPGDetails(Long pgId);
    public OwnerDto getOwnerDetails(Long pgId);
    public PGResponseDto updateAvailability(Long pgId, boolean status);
    public PGResponseDto editPGPlace(PGPlace pgPlace);
    public void deletePGPlace(Long pgId);
}

