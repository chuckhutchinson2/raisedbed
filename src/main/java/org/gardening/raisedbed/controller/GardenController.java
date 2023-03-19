package org.gardening.raisedbed.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.gardening.raisedbed.model.Plant;
import org.gardening.raisedbed.model.PlantType;
import org.gardening.raisedbed.model.SoilPh;
import org.gardening.raisedbed.model.SunExposure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// http://localhost:8080/swagger-ui.html
@Slf4j
@RestController
@RequestMapping("/api/v1/garden")
public class GardenController {
    public GardenController() {
    }

    @PostMapping("/plant")
    @Operation (
            tags = { "Garden"},
            summary = "Plant a plant in a raised bed",
            description = "")
    ResponseEntity<Plant> plant (@RequestBody String plantName) {

        Plant plant = new Plant();
        plant.setBotanicalName(plantName);
        plant.setType(PlantType.Fruit);
        plant.setHardinessZone(1);
        plant.setSunExposure(SunExposure.Full);
        plant.setSoilPh(SoilPh.Neutral);

        log.debug("plant {}", plant);

        return new ResponseEntity<> (plant, HttpStatus.OK);
    }
}
