package org.gardening.raisedbed.io;

import jdk.internal.org.objectweb.asm.TypeReference;
import lombok.extern.slf4j.Slf4j;
import org.gardening.raisedbed.model.Plant;
import org.junit.Test;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.Assert.assertNotNull;

@ActiveProfiles("test")
@Slf4j
public class JsonUtilsTest {
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
}
