package com.nerv.hdbmanagement.properties.interfaces.rest;

import com.nerv.hdbmanagement.properties.domain.service.PropertyService;
import com.nerv.hdbmanagement.properties.interfaces.rest.mapping.PropertyMapper;
import com.nerv.hdbmanagement.properties.interfaces.rest.resources.CreatePropertyResource;
import com.nerv.hdbmanagement.properties.interfaces.rest.resources.PropertyResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/properties")
public class PropertiesController {

    private final PropertyService propertyService;
    private final PropertyMapper mapper;

    public PropertiesController(PropertyService propertyService, PropertyMapper mapper) {
        this.propertyService = propertyService;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<Page<PropertyResource>> getAllProperties(@RequestParam(defaultValue = "0") int page,
                                                                   @RequestParam(defaultValue = "10") int size) {

        return new ResponseEntity<>(mapper.modelListPage(propertyService.getAll(PageRequest.of(page, size))), HttpStatus.OK);
    }

    @GetMapping("{propertyId}")
    public ResponseEntity<PropertyResource> getPropertyById(@PathVariable Long propertyId) {
        return new ResponseEntity<>(mapper.toResource(propertyService.getById(propertyId)), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<PropertyResource> createProperty(@RequestBody CreatePropertyResource resource) {
        return new ResponseEntity<>(mapper.toResource(propertyService.create(mapper.toModel(resource))), HttpStatus.CREATED);
    }

    @PutMapping("{propertyId}")
    public ResponseEntity<PropertyResource> updateProperty(@PathVariable Long propertyId, @RequestBody CreatePropertyResource resource) {
        return new ResponseEntity<>(mapper.toResource(propertyService.update(propertyId, mapper.toModel(resource))), HttpStatus.OK);
    }

    @DeleteMapping("{propertyId}")
    public ResponseEntity<?> deleteProperty(@PathVariable Long propertyId) {
        return propertyService.delete(propertyId);
    }
}
