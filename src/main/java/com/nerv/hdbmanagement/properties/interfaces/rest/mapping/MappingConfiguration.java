package com.nerv.hdbmanagement.properties.interfaces.rest.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("propertyMappingConfiguration")
public class MappingConfiguration {
    @Bean
    PropertyMapper propertyMapper(){ return new PropertyMapper(); }
}
