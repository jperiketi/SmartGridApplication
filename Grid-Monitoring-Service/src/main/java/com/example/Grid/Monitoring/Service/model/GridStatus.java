package com.example.Grid.Monitoring.Service.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "gridStatus")
public class GridStatus {

    @Id
    private String id;
    private double voltage;
    private double powerFlow;
    private String status;  // can be 'healthy', 'warning', 'failure'
    private LocalDateTime timestamp;

    // Constructors
    public GridStatus() {}

    public GridStatus(double voltage, double powerFlow, String status, LocalDateTime timestamp) {
        this.voltage = voltage;
        this.powerFlow = powerFlow;
        this.status = status;
        this.timestamp = timestamp;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getVoltage() {
        return voltage;
    }

    public void setVoltage(double voltage) {
        this.voltage = voltage;
    }

    public double getPowerFlow() {
        return powerFlow;
    }

    public void setPowerFlow(double powerFlow) {
        this.powerFlow = powerFlow;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}