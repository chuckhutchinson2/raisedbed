package org.gardening.raisedbed.repository.impl;

import org.gardening.raisedbed.model.PlantType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.Assert.assertNotNull;

@ActiveProfiles("test")
@RunWith(MockitoJUnitRunner.class)
public class PlantRepositoryImplTest {
    @Autowired
    @InjectMocks
    PlantRepositoryImpl plantRepository;

    @Test
    public void testGetPlants() {
        assertNotNull(plantRepository.getPlants(PlantType.Vegetables));
    }
}
