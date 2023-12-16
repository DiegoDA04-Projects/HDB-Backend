package com.nerv.hdbmanagement.properties.application.service;

import com.nerv.hdbmanagement.properties.domain.model.Property;
import com.nerv.hdbmanagement.properties.domain.service.PropertyService;
import com.nerv.hdbmanagement.properties.infrastructure.persistence.jpa.repositories.PropertyRepository;
import com.nerv.hdbmanagement.shared.domain.exception.ResourceNotFoundException;
import com.nerv.hdbmanagement.shared.domain.exception.ResourceValidationException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class PropertyServiceImpl implements PropertyService {

    private static final String ENTITY = "Property";
    private final PropertyRepository propertyRepository;
    private final Validator validator;

    public PropertyServiceImpl(PropertyRepository propertyRepository, Validator validator) {
        this.propertyRepository = propertyRepository;
        this.validator = validator;
    }

    @Override
    public Property create(Property property) {

        Set<ConstraintViolation<Property>> violations = validator.validate(property);

        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return propertyRepository.save(property);
    }

    @Override
    public List<Property> getAll() {
        return propertyRepository.findAll();
    }

    @Override
    public Property getById(Long propertyId) {
        return propertyRepository.findById(propertyId).orElseThrow(() -> new ResourceNotFoundException(ENTITY, propertyId));
    }

    @Override
    public Property update(Long propertyId, Property property) {

        Set<ConstraintViolation<Property>> violations = validator.validate(property);

        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return propertyRepository.findById(propertyId).map(propertyToUpdate ->
                        propertyRepository.save(
                                propertyToUpdate.withBlockNumber(propertyToUpdate.getBlockNumber())
                                        .withYearCompleted(propertyToUpdate.getYearCompleted())
                                        .withTown(propertyToUpdate.getTown())
                                        .withStreet(propertyToUpdate.getStreet())
                                        .withNumberStudioApartmentSoldFlats(propertyToUpdate.getNumberStudioApartmentSoldFlats())
                                        .withMultiStoreyCarParkTag(propertyToUpdate.getMultiStoreyCarParkTag())
                                        .withMiscellaneous(propertyToUpdate.getMiscellaneous())
                                        .withCommercialPropertyTag(propertyToUpdate.getCommercialPropertyTag())
                                        .withMarketAndHawkerTag(propertyToUpdate.getMarketAndHawkerTag())
                                        .withMaximumFloorLevel(propertyToUpdate.getMaximumFloorLevel())
                                        .withNumberExecutiveSoldFlats(propertyToUpdate.getNumberExecutiveSoldFlats())
                                        .withNumberMultiGenerationSoldFlats(propertyToUpdate.getNumberMultiGenerationSoldFlats())
                                        .withResidentialPropertyTag(propertyToUpdate.getResidentialPropertyTag())
                                        .withPrecinctPavilionTag(propertyToUpdate.getPrecinctPavilionTag())
                                        .withNumberTwoRoomSoldFlats(propertyToUpdate.getNumberTwoRoomSoldFlats())
                                        .withNumberThreeRoomSoldFlats(propertyToUpdate.getNumberThreeRoomSoldFlats())
                                        .withNumberFourRoomSoldFlats(propertyToUpdate.getNumberFourRoomSoldFlats())
                                        .withNumberFiveRoomSoldFlats(propertyToUpdate.getNumberFiveRoomSoldFlats())
                                        .withNumberOneRoomSoldFlats(propertyToUpdate.getNumberOneRoomSoldFlats())
                                        .withNumberOneRoomRentalFlats(propertyToUpdate.getNumberOneRoomRentalFlats())
                                        .withNumberTwoRoomRentalFlats(propertyToUpdate.getNumberTwoRoomRentalFlats())
                                        .withNumberThreeRoomRentalFlats(propertyToUpdate.getNumberThreeRoomRentalFlats())
                                        .withNumberOtherRoomRentalFlats(propertyToUpdate.getNumberOtherRoomRentalFlats())
                ))
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, propertyId));

    }

    @Override
    public ResponseEntity<?> delete(Long propertyId) {
        return propertyRepository.findById(propertyId).map(property -> {
                    propertyRepository.delete(property);
                    return ResponseEntity.ok().build();})
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, propertyId));
    }
}
