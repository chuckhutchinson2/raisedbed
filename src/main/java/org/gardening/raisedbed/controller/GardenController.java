package org.gardening.raisedbed.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.gardening.raisedbed.model.Plant;
import org.gardening.raisedbed.model.PlantType;
import org.gardening.raisedbed.model.SoilPh;
import org.gardening.raisedbed.model.SunExposure;
import org.gardening.raisedbed.service.PlantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// http://localhost:8080/swagger-ui.html
@Slf4j
@RestController
@RequestMapping("/api/v1/garden")
public class GardenController {
    private PlantService plantService;
    public GardenController(PlantService plantService) {
        this.plantService = plantService;
    }

    @GetMapping("/plants/{plantType}")
    ResponseEntity<List<Plant>> getPlants(@PathVariable PlantType plantType) {
        List<Plant> plants = plantService.getPlants(plantType);
        log.info("The plants being returned is Plants {}", plants);
        return new ResponseEntity<>(plants, HttpStatus.OK);
    }

    @PostMapping("/plant")
    @Operation (
            tags = { "Garden"},
            summary = "Plant a plant in a raised bed",
            description = "hello world")
    ResponseEntity<Plant> plant (@RequestBody Plant plant) {

        log.debug("plant {}", plant);

        plantService.plant(plant);

        return new ResponseEntity<> (plant, HttpStatus.OK);
    }
}
