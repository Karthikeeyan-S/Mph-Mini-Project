package com.pgaccomodation.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.pgaccomodation.model.City;

public interface CityRepository extends JpaRepository<City, Long> {
}
