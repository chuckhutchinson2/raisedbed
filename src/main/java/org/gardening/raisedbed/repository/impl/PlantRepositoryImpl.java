package org.gardening.raisedbed.repository.impl;

import org.gardening.raisedbed.io.JsonUtils;
import org.gardening.raisedbed.model.Plant;
import org.gardening.raisedbed.model.PlantType;
import org.gardening.raisedbed.repository.PlantRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class PlantRepositoryImpl implements PlantRepository {

    Map<PlantType, List<Plant>> garden = new HashMap<>();
    public PlantRepositoryImpl() {
        for(PlantType plantType : PlantType.values()) {
            garden.put(plantType, new ArrayList<>());
        }

        // preload some plants
        garden.put(PlantType.Fruit,loadPlants(PlantType.Fruit));
        garden.put(PlantType.Vegetable,loadPlants(PlantType.Vegetable));
        garden.put(PlantType.Herbs, loadPlants(PlantType.Herbs));
    }
    @Override
    public List<Plant> getPlants(PlantType type) {
        return garden.get(type);
    }

    @Override
    public void plant(Plant plant, PlantType type) {
        List<Plant> plants = garden.get(type);
        plants.add(plant);
    }

    List<Plant> loadPlants(PlantType type) {
        String path = String.format("plants/%s/plants.json", type.name());
        return JsonUtils.readList(path, Plant.class);
    }
}