package com.example.carapp.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String modelName;
    private String type;

    // Costruttore vuoto necessario
    public Car() {}

    // Costruttore utile
    public Car(String modelName, String type) {
        this.modelName = modelName;
        this.type = type;
    }
}