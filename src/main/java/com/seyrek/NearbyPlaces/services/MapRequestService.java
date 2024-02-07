package com.seyrek.NearbyPlaces.services;

import com.seyrek.NearbyPlaces.entities.MapRequest;
import com.seyrek.NearbyPlaces.entities.MapResponse;
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

    public MapResponse createMapRequest(MapRequest mapRequest) {
        MapRequest old = getMapRequestWithParameters(mapRequest.getLatitude(), mapRequest.getLongitude(),  mapRequest.getRadius());
        if (old != null) {
            return mapResponseService.createMapResponse(old);
        }
        MapRequest newReq = mapRequestRepository.save(mapRequest);
        return mapResponseService.createMapResponse(newReq);
    }

    public MapRequest getMapRequestById(int id) {
        return mapRequestRepository.findById(id).orElse(null);
    }

    public MapRequest getMapRequestWithParameters(double latitude, double longitude,  double radius) {
        return mapRequestRepository.findByLatitudeAndLongitudeAndRadius(latitude, longitude, radius);
    }
}
