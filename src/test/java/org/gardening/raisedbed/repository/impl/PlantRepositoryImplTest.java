package org.gardening.raisedbed.repository.impl;

import org.gardening.raisedbed.model.PlantType;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.Assert.assertNotNull;

@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class PlantRepositoryImplTest {
    @Autowired
    @InjectMocks
    PlantRepositoryImpl plantRepository = new PlantRepositoryImpl();

    @Test
    public void testGetPlants() {
        assertNotNull(plantRepository.getPlants(PlantType.Vegetable));
    }
}
