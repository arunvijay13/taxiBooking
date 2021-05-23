package com.booking;

public class History implements Comparable<History> {
    private int id;
    private int cusId;
    private int pickTime;
    private int dropTime;
    private String taxiNo;
    private char pickPoint;
    private char dropPoint;
    private double fare;


    // setMethods
    public void setId(int id) {
        this.id = id;
    }

    public void setCusId(int cusId) {
        this.cusId = cusId;
    }

    public void setPickTime(int pickTime) {
        this.pickTime = pickTime;
    }

    public void setDropTime(int dropTime) {
        this.dropTime = dropTime;
    }

    public void setTaxiNo(String taxiNo) {
        this.taxiNo = taxiNo;
    }

    public void setPickPoint(char pickPoint) {
        this.pickPoint = pickPoint;
    }

    public void setDropPoint(char dropPoint) {
        this.dropPoint = dropPoint;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }


    // getMethods
    public int getId() {
        return id;
    }

    public int getCusId() {
        return cusId;
    }

    public int getPickTime() {
        return pickTime;
    }

    public int getDropTime() {
        return dropTime;
    }

    public String getTaxiNo() {
        return taxiNo;
    }

    public char getPickPoint() {
        return pickPoint;
    }

    public char getDropPoint() {
        return dropPoint;
    }

    public double getFare() {
        return fare;
    }



    @Override
    public int compareTo(History obj2) {
        return Integer.compare(this.getTaxiNo().compareToIgnoreCase(obj2.getTaxiNo()), 0);
    }
}
