package com.nerv.hdbmanagement.properties.infrastructure.persistence.jpa.repositories;

import com.nerv.hdbmanagement.properties.domain.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {
}
