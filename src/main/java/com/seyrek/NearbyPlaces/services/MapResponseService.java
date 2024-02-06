package com.seyrek.NearbyPlaces.services;

import com.seyrek.NearbyPlaces.entities.MapResponse;
import com.seyrek.NearbyPlaces.repositories.MapResponseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@AllArgsConstructor
@Service
public class MapResponseService {
    private final MapResponseRepository mapResponseRepository;
    private final MapRequestService mapRequestService;

    public Stream<MapResponse> getAllMapResponses(){
        return mapResponseRepository.findAll().stream();
    }

    public MapResponse getMapResponseById(int id){
        return mapResponseRepository.findById(id).orElse(null);
    }

    public MapResponse createMapResponse(int mapRequestId){
        return null;
    }
}
