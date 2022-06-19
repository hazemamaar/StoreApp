package com.example.storeapp.model;

import java.util.HashMap;
import java.util.Map;

public class Rating {

    public Double rate;

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
