package com.pgaccomodation.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.pgaccomodation.model.PGPlace;

import java.util.List;
import java.util.Optional;

public interface PGPlaceRepository extends JpaRepository<PGPlace, Long> {

    // Retrieve available PGs by city
    List<PGPlace> findByCity_NameAndAvailabilityStatusTrue(String name);

    // Retrieve available PGs by locality name
    List<PGPlace> findByLocality_NameAndAvailabilityStatusTrue(String localityName);

    // Retrieve PG by registration number (optional)
    PGPlace findByRegistrationNumber(String registrationNumber);
}