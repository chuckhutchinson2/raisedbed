package org.gardening.raisedbed.io;

import lombok.extern.slf4j.Slf4j;
import org.gardening.raisedbed.model.Plant;
import org.junit.Test;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ActiveProfiles("test")
@Slf4j
public class JsonUtilsTest {

    @Test
    public void testReadBadJsonFile() {
        RuntimeException runtimeException = assertThrows(RuntimeException.class, () -> {
           JsonUtils.read("plants/badapple.json", Plant.class);
        });

        assertEquals(com.fasterxml.jackson.databind.exc.MismatchedInputException.class,runtimeException.getCause().getClass() );
    }

    @Test
    public void testReadPlant() {
        Plant plant = JsonUtils.read("plants/apple.json", Plant.class);

        assertNotNull(plant);

        log.info("Plant {}", plant);
    }

    @Test
    public void testReadPlants() {
        List<Plant> plants = JsonUtils.readList("plants/plants.json", Plant.class);
        assertNotNull(plants);

        log.info("Plants {}", plants);
    }

    @Test
    public void testReadBadReadPlantsJsonFile() {
        RuntimeException runtimeException = assertThrows(RuntimeException.class, () -> {
            JsonUtils.readList("plants/apple.json", Plant.class);
        });

        assertEquals(com.fasterxml.jackson.databind.exc.MismatchedInputException.class,runtimeException.getCause().getClass() );
    }

}
