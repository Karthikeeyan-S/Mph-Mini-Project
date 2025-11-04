package com.pgaccomodation.Service.Impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pgaccomodation.Service.LocalityService;
import com.pgaccomodation.exception.ResourceNotFoundException;
import com.pgaccomodation.model.Locality;
import com.pgaccomodation.repository.LocalityRepository;

@Service
public class LocalityServiceImpl implements LocalityService {

    @Autowired
    private LocalityRepository localityRepository;

    @Override
    public Locality addLocality(Locality locality) {
        return localityRepository.save(locality);
    }

    @Override
    public List<Locality> getAllLocalities() {
        return localityRepository.findAll();
    }

    @Override
    public Locality getLocalityById(Long localityId) {
        return localityRepository.findById(localityId)
                .orElseThrow(() -> new ResourceNotFoundException("Locality not found with ID: " + localityId));
    }

    @Override
    public void deleteLocality(Long localityId) {
        localityRepository.deleteById(localityId);
    }
}
