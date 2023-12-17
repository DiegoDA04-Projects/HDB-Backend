package com.nerv.hdbmanagement.properties.infrastructure.initializer;

import com.nerv.hdbmanagement.properties.domain.service.PropertyService;
import com.opencsv.exceptions.CsvValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.sql.Timestamp;

@Component
public class DatabaseSeedingConfig {
    private static final Logger logger = LoggerFactory.getLogger(DatabaseSeedingConfig.class);

    private final PropertyService propertyService;
    public DatabaseSeedingConfig(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @EventListener
    public void onApplicationReady(ApplicationReadyEvent event) throws CsvValidationException, IOException {
        String name = event.getApplicationContext().getId();
        if(propertyService.getAll().isEmpty()) {
            logger.info("Starting Database Seeding Process for {} at {}", name, new Timestamp(System.currentTimeMillis()));
            propertyService.seed();
            logger.info("Finished Database Seeding Process for {} at {}", name, new Timestamp(System.currentTimeMillis()));
        }
    }
}
