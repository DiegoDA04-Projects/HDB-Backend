package com.nerv.hdbmanagement.properties.domain.service;

import com.nerv.hdbmanagement.properties.domain.model.Property;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.List;

public interface PropertyService {
    Property create(Property property);
    List<Property> getAll();
    Page<Property> getAll(Pageable pageable);
    Property getById(Long propertyId);
    Property update(Long propertyId, Property property);
    ResponseEntity<?> delete(Long propertyId);
    void seed() throws IOException, CsvValidationException;
}
