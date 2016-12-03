package com.questdot.retrofitrxjavaexample;


import java.util.ArrayList;
import java.util.List;


/**
 * Created by HP on 24/9/2016.
 */



public class DoorResponse {

    private Integer id;
    private String name;
    private Double price;
    private List<String> tags = new ArrayList<String>();



    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Double getPrice() {
        return price;
    }


    public void setPrice(Double price) {
        this.price = price;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

}



