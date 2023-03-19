package org.gardening.raisedbed.service;

import org.gardening.raisedbed.model.Plant;
import org.gardening.raisedbed.model.PlantType;

import java.util.List;

public interface PlantService {
    List<Plant> getPlants(PlantType type);

    void plant(Plant plant);
}
