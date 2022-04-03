package com.example.adp_39_eccomerce.Models;

public class Product {
    private Integer id;
    private String title;
    private Integer price;
    private String description;
    private String Category;
    private String Image;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public void setImage(String image) {
        Image = image;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return Category;
    }

    public String getImage() {
        return Image;
    }
}

