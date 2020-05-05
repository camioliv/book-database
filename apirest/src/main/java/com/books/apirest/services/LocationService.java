package com.books.apirest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.books.apirest.models.Location;
import com.books.apirest.repository.LocationRepository;


public class LocationService {
	@Autowired
	private LocationRepository locationRepository;
	
	public List<Location> findLocation(String name){
		if (name == null||name.isEmpty()){
			return locationRepository.findAll();
		}else {
			name = name.toLowerCase();
			return locationRepository.findByName(name);
		}
	}	
}
