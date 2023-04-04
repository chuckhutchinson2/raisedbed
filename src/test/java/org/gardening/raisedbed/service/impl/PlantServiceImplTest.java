package org.gardening.raisedbed.service.impl;

import org.gardening.raisedbed.model.Plant;
import org.gardening.raisedbed.model.PlantType;
import org.gardening.raisedbed.repository.PlantRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ActiveProfiles("test")
@RunWith(MockitoJUnitRunner.class)
public class PlantServiceImplTest {

    @Autowired
    @InjectMocks
    PlantServiceImpl plantService;

    @Mock
    PlantRepository plantRepository;

    @Test
    public void testGetPlants() {
        PlantType type = PlantType.Trees;
        List<Plant> trees = new ArrayList<>();
        when(plantRepository.getPlants(type)).thenReturn(trees);
        plantService.getPlants(type);
        verify(plantRepository).getPlants(type);
    }

    @Test
    public void testPlant() {
        Plant plant = new Plant();
        plant.setBotanicalName("apple");
        plant.setType(PlantType.Fruits);
        doNothing().when(plantRepository).plant(plant, plant.getType());
        plantService.plant(plant);
        verify(plantRepository).plant(plant, plant.getType());
    }
}
