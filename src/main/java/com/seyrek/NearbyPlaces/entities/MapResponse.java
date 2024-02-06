package com.seyrek.NearbyPlaces.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Data
@Entity
public class MapResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @OneToOne
    @JoinColumn(name = "mapRequestId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    MapRequest mapRequest;

    String jsonResponse;
}
