package org.gardening.raisedbed.service.impl;

import org.gardening.raisedbed.model.Plant;
import org.gardening.raisedbed.model.PlantType;
import org.gardening.raisedbed.repository.PlantRepository;
import org.gardening.raisedbed.repository.impl.PlantRepositoryImpl;
import org.junit.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
}
