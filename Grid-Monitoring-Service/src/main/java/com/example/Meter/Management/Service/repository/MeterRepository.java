package com.example.Meter.Management.Service.repository;

import com.example.Meter.Management.Service.model.Meter;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MeterRepository extends MongoRepository<Meter, String> {
    List<Meter> findByMeterId(String meterId);
}
