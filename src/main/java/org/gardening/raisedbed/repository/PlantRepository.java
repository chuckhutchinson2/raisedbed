package org.gardening.raisedbed.repository;

import org.gardening.raisedbed.model.Plant;
import org.gardening.raisedbed.model.PlantType;

import java.util.List;

public interface PlantRepository {
    List<Plant> getPlants(PlantType type);

    void plant(Plant plant, PlantType type);
}
