package com.nerv.hdbmanagement.properties.application.service;

import com.nerv.hdbmanagement.properties.domain.model.Property;
import com.nerv.hdbmanagement.properties.domain.service.PropertyService;
import com.nerv.hdbmanagement.properties.infrastructure.persistence.jpa.repositories.PropertyRepository;
import com.nerv.hdbmanagement.shared.domain.exception.ResourceNotFoundException;
import com.nerv.hdbmanagement.shared.domain.exception.ResourceValidationException;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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
    public Page<Property> getAll(Pageable pageable) {
        return propertyRepository.findAll(pageable);
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

    @Override
    public void seed() throws IOException, CsvValidationException {

        CSVReader reader = new CSVReader(new FileReader("src/main/resources/data/HDBPropertyInformation.csv"));
        String[] line;
        reader.readNext();
        List<Property> properties = new ArrayList<>();
        while ((line = reader.readNext()) != null) {

            Property property = new Property();
            property.setBlockNumber(line[0]);
            property.setStreet(line[1]);
            property.setMaximumFloorLevel(Integer.parseInt(line[2]));
            property.setYearCompleted(Integer.parseInt(line[3]));
            property.setResidentialPropertyTag(line[4]);
            property.setCommercialPropertyTag(line[5]);
            property.setMarketAndHawkerTag(line[6]);
            property.setMiscellaneous(line[7]);
            property.setMultiStoreyCarParkTag(line[8]);
            property.setPrecinctPavilionTag(line[9]);
            property.setTown(line[10]);
            property.setTotalDwellingUnits(Integer.parseInt(line[11]));
            property.setNumberOneRoomSoldFlats(Integer.parseInt(line[12]));
            property.setNumberTwoRoomSoldFlats(Integer.parseInt(line[13]));
            property.setNumberThreeRoomSoldFlats(Integer.parseInt(line[14]));
            property.setNumberFourRoomSoldFlats(Integer.parseInt(line[15]));
            property.setNumberFiveRoomSoldFlats(Integer.parseInt(line[16]));
            property.setNumberExecutiveSoldFlats(Integer.parseInt(line[17]));
            property.setNumberMultiGenerationSoldFlats(Integer.parseInt(line[18]));
            property.setNumberStudioApartmentSoldFlats(Integer.parseInt(line[19]));
            property.setNumberOneRoomRentalFlats(Integer.parseInt(line[20]));
            property.setNumberTwoRoomRentalFlats(Integer.parseInt(line[21]));
            property.setNumberThreeRoomRentalFlats(Integer.parseInt(line[22]));
            property.setNumberOtherRoomRentalFlats(Integer.parseInt(line[23]));

            properties.add(property);
        }
        propertyRepository.saveAll(properties);
    }
}
