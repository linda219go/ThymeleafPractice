package com.example.ThymeleafPractice.drone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DroneService {
    @Autowired
    DroneRepository droneRepository;

    public Drone saveDrone(Drone drone) {
        return droneRepository.saveAndFlush(drone);
    }

    public List<Drone> getAllDrones() {
        return droneRepository.findAll();
    }
}
