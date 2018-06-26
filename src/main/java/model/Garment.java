package model;

import java.math.BigDecimal;


public class Garment {
    private int id;
    private Size size;
    private BigDecimal price;
    private Color color;
    private GarmentType type;
    private String description;

    public Garment() {
    }

    public Garment(int id, Size size, BigDecimal price, Color color, GarmentType type, String description) {
        this.id = id;
        this.size = size;
        this.price = price;
        this.color = color;
        this.type = type;
        this.description = description;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public GarmentType getType() {
        return type;
    }

    public void setType(GarmentType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
