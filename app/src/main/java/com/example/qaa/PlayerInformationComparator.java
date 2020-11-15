package com.example.qaa;

import java.io.Serializable;

public class PlayerInformationComparator implements Serializable {

    private String userName;

    private Integer level;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getNumberOfPoints() {
        return level;
    }

    public void setNumberOfPoints(Integer numberOfPoints) {
        this.level = numberOfPoints;
    }


}