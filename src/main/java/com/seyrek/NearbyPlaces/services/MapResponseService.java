package com.seyrek.NearbyPlaces.services;

import com.seyrek.NearbyPlaces.entities.MapRequest;
import com.seyrek.NearbyPlaces.entities.MapResponse;
import com.seyrek.NearbyPlaces.repositories.MapResponseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@AllArgsConstructor
@Service
public class MapResponseService {
    private final MapResponseRepository mapResponseRepository;
    public List<MapResponse> getAllMapResponses() {
        return mapResponseRepository.findAll();
    }

    public MapResponse getMapResponseById(int id) {
        return mapResponseRepository.findById(id).orElse(null);
    }

    public MapResponse createMapResponse(MapRequest mapRequest) {
        MapResponse old = getMapResponseByMapRequestId(mapRequest.getId());
        if (old != null) {
            return old;
        }

        RestTemplate restTemplate = new RestTemplate();
        String url = "https://nominatim.openstreetmap.org/reverse?format=jsonv2&lat=" + mapRequest.getLatitude() + "&" + "lon=" + mapRequest.getLongitude();
        String res = String.valueOf(restTemplate.getForEntity(url, String.class));
        MapResponse toSave = new MapResponse();
        toSave.setMapRequest(mapRequest);
        toSave.setJsonResponse(res);
        return mapResponseRepository.save(toSave);
    }

    public MapResponse getMapResponseByMapRequestId(int mapRequestId) {
        return mapResponseRepository.findByMapRequestId(mapRequestId);
    }
}
