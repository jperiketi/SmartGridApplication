//package com.example.Grid.Monitoring.Service.controller;
//
//public class GridController {
//}


package com.example.Grid.Monitoring.Service.controller;

import com.example.Grid.Monitoring.Service.model.GridStatus;
import com.example.Grid.Monitoring.Service.repository.GridStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

        import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/grid")
public class GridController {

    @Autowired
    private GridStatusRepository gridStatusRepository;

    @Autowired
    private KafkaTemplate<String, GridStatus> kafkaTemplate;

    private static final String TOPIC = "grid-alert-topic";

    // Get all grid statuses
    @GetMapping("/status")
    public List<GridStatus> getAllGridStatus() {
        return gridStatusRepository.findAll();
    }

    // Add or update grid status
    @PostMapping("/status")
    public GridStatus updateGridStatus(@RequestBody GridStatus gridStatus) {
        gridStatus.setTimestamp(LocalDateTime.now());

        // Save to MongoDB
        GridStatus savedStatus = gridStatusRepository.save(gridStatus);

        // Publish to Kafka if status is warning or failure
        if ("warning".equalsIgnoreCase(gridStatus.getStatus()) || "failure".equalsIgnoreCase(gridStatus.getStatus())) {
            kafkaTemplate.send(TOPIC, gridStatus);
        }

        return savedStatus;
    }
}