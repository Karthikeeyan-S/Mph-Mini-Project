package com.pgaccomodation.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pgaccomodation.model.Locality;

public interface LocalityRepository extends JpaRepository<Locality, Long> {
}

