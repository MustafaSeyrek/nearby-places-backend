package com.seyrek.NearbyPlaces.repositories;

import com.seyrek.NearbyPlaces.entities.MapResponse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MapResponseRepository extends JpaRepository<MapResponse, Integer> {
    MapResponse findByMapRequestId(int mapRequestId);
}
