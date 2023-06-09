package org.gardening.raisedbed.service.impl;

import org.gardening.raisedbed.model.Plant;
import org.gardening.raisedbed.model.PlantType;
import org.gardening.raisedbed.repository.PlantRepository;
import org.gardening.raisedbed.service.PlantService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PlantServiceImpl implements PlantService {
    private PlantRepository plantRepository;

    public PlantServiceImpl(PlantRepository plantRepository) {
        this.plantRepository = plantRepository;
    }

    @Override
    public List<Plant> getPlants(PlantType type) {
        return plantRepository.getPlants(type);
    }

    @Override
    public void plant(Plant plant) {
        plantRepository.plant(plant, plant.getType());
    }
}
