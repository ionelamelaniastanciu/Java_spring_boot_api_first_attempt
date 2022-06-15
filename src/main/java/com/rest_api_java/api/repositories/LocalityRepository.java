package com.rest_api_java.api.repositories;

import com.rest_api_java.api.model.Locality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalityRepository extends JpaRepository<Locality, Integer> {
}
