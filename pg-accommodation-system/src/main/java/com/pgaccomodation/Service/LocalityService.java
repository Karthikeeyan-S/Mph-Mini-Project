package com.pgaccomodation.Service;


import java.util.List;

import com.pgaccomodation.model.Locality;

public interface LocalityService {
	public Locality addLocality(Locality locality);
	public List<Locality> getAllLocalities();
	public Locality getLocalityById(Long localityId);
	public void deleteLocality(Long localityId);
}
