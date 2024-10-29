package com.example.Meter.Management.Service.controller;

import com.example.Meter.Management.Service.model.Meter;
import com.example.Meter.Management.Service.repository.MeterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

        import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/meters")
public class MeterController {

    @Autowired
    private MeterRepository meterRepository;

    @Autowired
    private KafkaTemplate<String, Meter> kafkaTemplate;

    private static final String TOPIC = "meter-readings-topic";

//    @PostMapping("/{id}/readings")
//    public Meter addReading(@PathVariable String id, @RequestBody double reading) {
//        Meter meter = new Meter(id, reading, LocalDateTime.now());
//        meterRepository.save(meter);
//        kafkaTemplate.send(TOPIC, meter);
//        return meter;
//    }

    @PostMapping("/{id}/readings")
    public Meter addReading(@PathVariable String id, @RequestBody ReadingRequest request) {
        Meter meter = new Meter(id, request.getReading(), LocalDateTime.now());
        meterRepository.save(meter);
        kafkaTemplate.send(TOPIC, meter);
        return meter;
    }

    @GetMapping("/{id}/readings")
    public List<Meter> getReadings(@PathVariable String id) {
        return meterRepository.findByMeterId(id);
    }
}

