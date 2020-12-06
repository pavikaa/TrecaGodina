package com.example.orwma_lv8_pavicic;

public class Product {
    private String brand;
    private String name;
    private String description;
    private Float price;
    private Float rating;
    private String image_link;

    public Float getPrice() {
        return price;
    }

    public Float getRating() {
        return rating;
    }

    public String getBrand() {
        return brand;
    }

    public String getImage_link() {
        return image_link;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public void setImage_link(String image_link) {
        this.image_link = image_link;
    }
}
