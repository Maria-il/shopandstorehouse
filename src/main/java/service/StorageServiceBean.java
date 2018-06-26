package service;

import model.Garment;
import model.Shop;
import model.Storehouse;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Stateless
@Named("storageService")
public class StorageServiceBean {
    @Inject
    IdGenerator generator;

    @Inject
    private Shop shop;

    @Inject
    private Storehouse storehouse;

    public Garment findById(int id) {
        Map<Integer, Garment> all = new LinkedHashMap<>(shop.getGarments());
        all.putAll(storehouse.getGarments());
        return all.get(id);
    }

    public void update(Garment garment) {
        if (shop.getGarments().containsKey(garment.getId())) {
            shop.getGarments().put(garment.getId(), garment);
        }

        if (storehouse.getGarments().containsKey(garment.getId())) {
            storehouse.getGarments().put(garment.getId(), garment);
        }
    }

    public void delete(int garmentId) {
        if (shop.getGarments().containsKey(garmentId)) {
            shop.getGarments().remove(garmentId);
        }

        if (storehouse.getGarments().containsKey(garmentId)) {
            storehouse.getGarments().remove(garmentId);
        }
    }

    public List<Garment> getShopGarments() {
        return new ArrayList<>(shop.getGarments().values());
    }

    public List<Garment> getStorehouseGarments() {
        return new ArrayList<>(storehouse.getGarments().values());
    }

    public void moveToShop(int id) {
        if (storehouse.getGarments().containsKey(id)) {
            shop.getGarments().put(id, storehouse.getGarments().get(id));
            storehouse.getGarments().remove(id);
        }
    }

    public void moveToStorehouse(int id) {
        if (shop.getGarments().containsKey(id)) {
            storehouse.getGarments().put(id, shop.getGarments().get(id));
            shop.getGarments().remove(id);
        }
    }

    public void addToStorehouse(Garment garment) {
        garment.setId(generator.getNext());
        storehouse.getGarments().put(garment.getId(), garment);
    }

    public void addToShop(Garment garment) {
        garment.setId(generator.getNext());
        shop.getGarments().put(garment.getId(), garment);
    }
}
