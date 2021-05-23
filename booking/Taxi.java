package com.booking;

public class Taxi implements Comparable<Taxi> {
    private char pickupPlace;
    private char dropupPlace;
    private char currentPoint;
    private int pickupTime;
    private int dropupTime;
    private int difference;
    private static int taxiNo = 1;
    private static int uniqueId = 1;
    private static int cusId = 1;
    private double fare;
    private double totalEarning;
    private final String taxiName;

    public Taxi() {
        this.currentPoint = 'A';
        this.pickupTime = 0;
        this.dropupTime = 0;
        this.fare = 0;
        this.totalEarning = 0;
        this.taxiName = "TAXI-" + taxiNo++;
    }

    // setter methods
    public void setPickupPlace(char pickupPlace) {
        this.pickupPlace = pickupPlace;
    }

    public void setDropupPlace(char dropupPlace) {
        this.dropupPlace = dropupPlace;
    }

    public void setCurrentPoint(char currentPoint) {
        this.currentPoint = currentPoint;
    }

    public void setPickupTime(int pickupTime) {
        this.pickupTime = pickupTime;
    }

    public void setDropupTime(int dropupTime) {
        this.dropupTime = dropupTime;
    }

    public void setDifference(int difference) {
        this.difference = difference;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    public void setTotalEarning(double totalEarning) {
        this.totalEarning += totalEarning;
    }

    // getter methods
    public char getPickupPlace() {
        return pickupPlace;
    }

    public char getDropupPlace() {
        return dropupPlace;
    }

    public char getCurrentPoint() {
        return currentPoint;
    }

    public int getPickupTime() {
        return pickupTime;
    }

    public int getDropupTime() {
        return dropupTime;
    }

    public static int getUniqueId() {
        return uniqueId++;
    }

    public static int getCusId() {
        return cusId++;
    }

    public int getDifference() {
        return difference;
    }

    public double getFare() {
        return fare;
    }

    public double getTotalEarning() {
        return totalEarning;
    }

    public String getTaxiName() {
        return taxiName;
    }

    @Override
    public int compareTo(Taxi taxi2) {
        if ((this.getDifference() > taxi2.getDifference()) ||
                (this.getTotalEarning() > taxi2.getTotalEarning())) {
            return 1;
        } else if ((this.getDifference() < taxi2.getDifference()) ||
                (this.getTotalEarning() < taxi2.getTotalEarning())) {
            return -1;
        } else {
            return 0;
        }
    }

}
