
package com.example.storeapp.model;

import java.util.HashMap;
import java.util.Map;


public class ProductModel {


    private Integer id;

    private String title;

    private Double price;

    private String description;

    private String category;

    private String image;

    private Rating rating;



    public ProductModel() {
    }


    public ProductModel(Integer id, String title, Double price, String description, String category, String image, Rating rating) {
        super();
        this.id = id;
        this.title = title;
        this.price = price;
        this.description = description;
        this.category = category;
        this.image = image;
        this.rating = rating;
    }


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getCategory() {
        return category;
    }


    public void setCategory(String category) {
        this.category = category;
    }


    public String getImage() {
        return image;
    }


    public void setImage(String image) {
        this.image = image;
    }


    public Rating getRating() {
        return rating;
    }


    public void setRating(Rating rating) {
        this.rating = rating;
    }


}



class Rating {

    private Double rate;

    private Integer count;

    private Map<String, Object> additionalProperties = new HashMap<String, Object>();


    public Rating() {
    }

    public Rating(Double rate, Integer count) {
        super();
        this.rate = rate;
        this.count = count;
    }


    public Double getRate() {
        return rate;
    }


    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Integer getCount() {
        return count;
    }


    public void setCount(Integer count) {
        this.count = count;
    }


    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }


    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}