package com.seyrek.NearbyPlaces.controllers;

import com.seyrek.NearbyPlaces.entities.MapRequest;
import com.seyrek.NearbyPlaces.entities.MapResponse;
import com.seyrek.NearbyPlaces.services.MapRequestService;
import com.seyrek.NearbyPlaces.services.MapResponseService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@AllArgsConstructor
@RequestMapping("/api/map")
public class MapController {
    private final MapRequestService mapRequestService;
    private final MapResponseService mapResponseService;

    @GetMapping("/responses")
    public ResponseEntity<List<MapResponse>> getAllResponses() {
        return new ResponseEntity<>(mapResponseService.getAllMapResponses(), OK);
    }

    @GetMapping("/requests")
    public ResponseEntity<List<MapRequest>> getAllRequests() {
        return new ResponseEntity<>(mapRequestService.getAllMapRequests(), OK);
    }

    @PostMapping
    public ResponseEntity<MapResponse> createNewRequest(@RequestBody MapRequest mapRequest) {
        return new ResponseEntity<>(mapRequestService.createMapRequest(mapRequest), OK);
    }

    @GetMapping("/test")
    public ResponseEntity<MapRequest> test(@RequestBody MapRequest m){
        return new ResponseEntity<>(mapRequestService.getMapRequestWithParameters(m.getLongitude(), m.getLatitude(), m.getRadius()), OK);
    }
}
