package util;

import model.Color;
import model.Garment;
import model.GarmentType;
import model.Size;
import rest.GarmentDTO;

import java.math.BigDecimal;

public class GarmentUtil {
    public static Garment getGarment(GarmentDTO g) {
        return new Garment(g.getId(),
                Size.valueOf(Integer.valueOf(g.getSize())),
                BigDecimal.valueOf(g.getPrice()),
                Color.valueOf(g.getColor().toUpperCase()),
                GarmentType.valueOf(g.getType().toUpperCase()),
                g.getDescription());
    }

    public static GarmentDTO getGarmentDTO(Garment g) {
        return new GarmentDTO(g.getId(),
                String.valueOf(g.getSize().getSizeValue()),
                g.getPrice().doubleValue(),
                g.getColor().name().toLowerCase(),
                g.getType().name().toLowerCase(),
                g.getDescription());
    }
}
