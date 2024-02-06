package com.seyrek.NearbyPlaces.repositories;

import com.seyrek.NearbyPlaces.entities.MapRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MapRequestRepository extends JpaRepository<MapRequest, Integer> {
    MapRequest findByLongitudeAndLatitudeAndRadius(float longitude, float latitude, float radius);
}
