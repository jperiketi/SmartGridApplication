//package com.example.Meter.Management.Service.model;
//
//import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.mapping.Document;
//
//import java.time.LocalDateTime;
//
//@Document(collection = "meters")
//public class Meter {
//
//    @Id
//    private String id;
//    private String meterId;
//    private double reading;
//    private LocalDateTime timestamp;
//
//    // Constructors, Getters, and Setters
//}


package com.example.Meter.Management.Service.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "meters")
public class Meter {

    @Id
    private String id;
    private String meterId;
    private double reading;
    private LocalDateTime timestamp;

    // Default constructor
    public Meter() {}

    // Parameterized constructor
    public Meter(String meterId, double reading, LocalDateTime timestamp) {
        this.meterId = meterId;
        this.reading = reading;
        this.timestamp = timestamp;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMeterId() {
        return meterId;
    }

    public void setMeterId(String meterId) {
        this.meterId = meterId;
    }

    public double getReading() {
        return reading;
    }

    public void setReading(double reading) {
        this.reading = reading;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
