package model;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class Storage implements Serializable {
    protected Map<Integer, Garment> garments = new LinkedHashMap<>();

    public Map<Integer, Garment> getGarments() {
        return garments;
    }

    public void setGarments(Map<Integer, Garment> garments) {
        this.garments = garments;
    }
}
