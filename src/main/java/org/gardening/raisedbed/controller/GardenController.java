package org.gardening.raisedbed.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    ResponseEntity plant (@RequestBody String plantName) {
        return new ResponseEntity<> (plantName, HttpStatus.OK);
    }
}
