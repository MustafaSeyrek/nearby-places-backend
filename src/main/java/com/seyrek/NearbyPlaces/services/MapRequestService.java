package com.seyrek.NearbyPlaces.services;

import com.seyrek.NearbyPlaces.entities.MapRequest;
import com.seyrek.NearbyPlaces.repositories.MapRequestRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MapRequestService {
    private final MapRequestRepository mapRequestRepository;
    private final MapResponseService mapResponseService;

    public List<MapRequest> getAllMapRequests() {
        return mapRequestRepository.findAll();
    }

    public MapRequest createMapRequest(MapRequest mapRequest) {
        //exist => return old: new
        return mapRequestRepository.save(mapRequest);
    }

    public MapRequest getMapRequestById(int id) {
        return mapRequestRepository.findById(id).orElse(null);
    }

    public MapRequest getMapRequestWithParameters(float longitude, float latitude, float radius){
        return mapRequestRepository.findByLongitudeAndLatitudeAndRadius(longitude, latitude, radius);
    }
}
