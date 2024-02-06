package com.seyrek.NearbyPlaces.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class MapRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    float longitude;
    float latitude;
    float radius;
}
