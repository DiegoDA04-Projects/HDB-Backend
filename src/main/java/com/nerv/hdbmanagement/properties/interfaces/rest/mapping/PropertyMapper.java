package com.nerv.hdbmanagement.properties.interfaces.rest.mapping;

import com.nerv.hdbmanagement.properties.domain.model.Property;
import com.nerv.hdbmanagement.properties.interfaces.rest.resources.CreatePropertyResource;
import com.nerv.hdbmanagement.properties.interfaces.rest.resources.PropertyResource;
import com.nerv.hdbmanagement.properties.interfaces.rest.resources.UpdatePropertyResource;
import com.nerv.hdbmanagement.shared.application.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class PropertyMapper implements Serializable {

    @Autowired
    EnhancedModelMapper mapper;

    public PropertyResource toResource(Property model) {
        return mapper.map(model, PropertyResource.class);
    }

    public Property toModel(CreatePropertyResource resource) {
        return mapper.map(resource, Property.class);
    }

    public Property toModel(UpdatePropertyResource resource) {
        return mapper.map(resource, Property.class);
    }

    public Page<PropertyResource> modelListPage(List<Property> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, PropertyResource.class), pageable, modelList.size());
    }
}
