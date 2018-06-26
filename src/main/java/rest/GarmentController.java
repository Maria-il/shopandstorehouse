package rest;

import model.Garment;
import service.StorageServiceBean;
import util.GarmentUtil;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Path("/garments")
public class GarmentController {

    @EJB
    StorageServiceBean storageService;

    @GET
    @Path("find/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public GarmentDTO findById(@PathParam("id") String id) {
        Garment g = storageService.findById(Integer.parseInt(id));
        return GarmentUtil.getGarmentDTO(g);
    }

    @POST
    @Path("update")
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(GarmentDTO garmentDTO) {
        storageService.update(GarmentUtil.getGarment(garmentDTO));
    }

    @GET
    @Path("delete/{id}")
    public void delete(@PathParam("id") String id) {
        storageService.delete(Integer.valueOf(id));
    }


    @GET
    @Path("getshopgarments")
    @Produces({MediaType.APPLICATION_JSON})
    public List<GarmentDTO> getShopGarments() {
        List<Garment> list = storageService.getShopGarments();
        List<GarmentDTO> result = new ArrayList<>();
        list.stream().forEach(g -> result.add(GarmentUtil.getGarmentDTO(g)));
        return result;
    }

    @GET
    @Path("getstorehousegarments")
    @Produces({MediaType.APPLICATION_JSON})
    public List<GarmentDTO> getStorehouseGarments() {
        List<Garment> list = storageService.getStorehouseGarments();
        List<GarmentDTO> result = new ArrayList<>();
        list.stream().forEach(g -> result.add(GarmentUtil.getGarmentDTO(g)));
        return result;
    }

    @GET
    @Path("movetostorehouse/{id}")
    public void moveToStorehouse(@PathParam("id") String id) throws IOException {
        storageService.moveToStorehouse(Integer.valueOf(id));
    }

    @GET
    @Path("movetoshop/{id}")
    public void moveToShop(@PathParam("id") String id) throws IOException {
        storageService.moveToShop(Integer.valueOf(id));
    }

    @POST
    @Path("addtostorehouse")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public GarmentDTO addToStorehouse(GarmentDTO garmentDTO) throws IOException {
        storageService.addToStorehouse(GarmentUtil.getGarment(garmentDTO));
        return garmentDTO;
    }

    @POST
    @Path("addtoshop")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public GarmentDTO addToShop(GarmentDTO garmentDTO) throws IOException {
        storageService.addToShop(GarmentUtil.getGarment(garmentDTO));
        return garmentDTO;
    }
}
