package com.example.nut.hydroponic.Models;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

public class DataPH {
    private double phsensor;
    private int distance;
    private String date;

    public DataPH() {
    }

    public DataPH(double phsensor, int distance, String date) {
        this.phsensor = phsensor;
        this.distance = distance;
        this.date = date;
    }

    public double getPhsensor() {
        return phsensor;
    }

    public void setPhsensor(double phsensor) {
        this.phsensor = phsensor;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getDate() { return date; }

    public void setDate(String date) { this.date = date; }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("phsensor", phsensor);
        result.put("distance", distance);
        result.put("date", date);

        return result;
    }
}
