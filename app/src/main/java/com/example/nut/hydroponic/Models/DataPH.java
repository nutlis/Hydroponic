package com.example.nut.hydroponic.Models;

/**
 * Created by nut on 22/12/2560.
 */

public class DataPH {
    private int phsensor;
    private int distance;

    public DataPH(int phsensor, int distance) {
        this.phsensor = phsensor;
        this.distance = distance;
    }

    public int getPhsensor() {
        return phsensor;
    }

    public void setPhsensor(int phsensor) {
        this.phsensor = phsensor;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
