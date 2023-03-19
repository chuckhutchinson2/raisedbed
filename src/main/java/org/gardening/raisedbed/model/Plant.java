package org.gardening.raisedbed.model;

import lombok.Data;

@Data
public class Plant {
    private String botanicalName;
    private PlantType type;
    private SunExposure sunExposure;
    private SoilPh soilPh;
    private int hardinessZone;
}
