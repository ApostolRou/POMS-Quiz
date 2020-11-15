package com.example.qaa;

import java.io.Serializable;

public class PlayerInformation implements Serializable {

    private String name;

    private Integer numberOfPoints;

    public PlayerInformation(String userName, Integer numberOfPoints) {
        this.name = userName;
        this.numberOfPoints = numberOfPoints;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Integer getNumberOfPoints() {
        return numberOfPoints;
    }

    public void setNumberOfPoints(Integer numberOfPoints) {
        this.numberOfPoints = numberOfPoints;
    }


}