package com.nerv.hdbmanagement.properties.domain.service;

import com.nerv.hdbmanagement.properties.domain.model.Property;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.http.ResponseEntity;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface PropertyService {
    Property create(Property property);
    List<Property> getAll();
    Property getById(Long propertyId);
    Property update(Long propertyId, Property property);
    ResponseEntity<?> delete(Long propertyId);
    void seed() throws IOException, CsvValidationException;
}
