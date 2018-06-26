package rest;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class GarmentDTO {
    private int id;
    private String size;
    private double price;
    private String color;
    private String type;
    private String description;

    public GarmentDTO() {}

    public GarmentDTO(int id, String size, double price, String color, String type, String description) {
        this.id = id;
        this.size = size;
        this.price = price;
        this.color = color;
        this.type = type;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
