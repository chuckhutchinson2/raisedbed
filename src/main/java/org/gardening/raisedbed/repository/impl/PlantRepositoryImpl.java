package org.gardening.raisedbed.repository.impl;

import org.gardening.raisedbed.model.Plant;
import org.gardening.raisedbed.repository.PlantRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PlantRepositoryImpl implements PlantRepository {
    @Override
    public List<Plant> getPlants() {
        return null;
    }
}
