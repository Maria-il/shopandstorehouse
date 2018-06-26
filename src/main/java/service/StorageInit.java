package service;

import model.Color;
import model.Garment;
import model.GarmentType;
import model.Size;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.math.BigDecimal;

@Singleton
@Startup
public class StorageInit {
    @Inject
    StorageServiceBean storageService;

    @PostConstruct
    public void init() {
        Garment garment = new Garment();
        garment.setColor(Color.BLACK);
        garment.setSize(Size.FIFTY);
        garment.setPrice(BigDecimal.valueOf(25.55));
        garment.setType(GarmentType.DRESS);
        garment.setDescription("Little black dress");
        storageService.addToShop(garment);

        garment = new Garment();
        garment.setColor(Color.BLUE);
        garment.setSize(Size.FORTY_FOUR);
        garment.setPrice(BigDecimal.valueOf(10));
        garment.setType(GarmentType.TROUSERS);
        garment.setDescription("Jeans 44");
        storageService.addToStorehouse(garment);
    }
}
