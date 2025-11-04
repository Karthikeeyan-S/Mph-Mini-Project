package com.pgaccomodation.repository;
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
import com.pgaccomodation.model.Owner;
 
@Repository
public interface OwnerRepository extends JpaRepository<Owner,Long> {
}