package com.booking;

import java.util.ArrayList;
import java.util.Collections;

public class Booking{

    private final ArrayList<Taxi> taxiList;
    private final ArrayList<Taxi> availableTaxi;
    private final ArrayList<History> bookingHistory;
    private final int TIME_IN_HOUR = 1;
    private final int CHARGE_RATE = 100;
    private final int KILOMETER = 15;

    public Booking() {
        taxiList = new ArrayList<>();
        availableTaxi = new ArrayList<>();
        bookingHistory = new ArrayList<>();
        populateTaxi();
    }

    private void populateTaxi() {
        int taxi = 4;
        while (taxi-- != 0) {
            taxiList.add(new Taxi());
        }
    }

    private Taxi findTaxi(char pickPoint){
        for(Taxi i:availableTaxi){
            i.setDifference(Math.abs((i.getCurrentPoint() - pickPoint)));
        }
        Collections.sort(availableTaxi);
        Taxi taxi = availableTaxi.get(0);
        clearAvailableTaxi(); // clear difference and available list
        return taxi;
    }

    private void setupTaxi(Taxi taxi,char pickPoint,char dropPoint,int pickTime){
        int distance = Math.abs(pickPoint-dropPoint);
        int totalDistance = distance * KILOMETER;
        int dropTime = pickTime + (TIME_IN_HOUR * distance) ;
        double calcFare = ((totalDistance - 5) * 10) +  CHARGE_RATE;

        taxi.setCurrentPoint(pickPoint);
        taxi.setPickupPlace(pickPoint);
        taxi.setDropupPlace(dropPoint);
        taxi.setPickupTime(pickTime);
        taxi.setDropupTime(dropTime);
        taxi.setFare(calcFare);
        taxi.setTotalEarning(calcFare);

        storeTaxi(taxi);
    }

    private void clearAvailableTaxi(){
        for(Taxi i:availableTaxi){
            i.setDifference(0);
        }
        availableTaxi.clear();
    }

    private void storeTaxi(Taxi taxi){
        History history = new History();

        history.setCusId(Taxi.getCusId());
        history.setId(Taxi.getUniqueId());
        history.setTaxiNo(taxi.getTaxiName());
        history.setPickPoint(taxi.getPickupPlace());
        history.setDropPoint(taxi.getDropupPlace());
        history.setPickTime(taxi.getPickupTime());
        history.setDropTime(taxi.getDropupTime());
        history.setFare(taxi.getFare());

        bookingHistory.add(history);
    }

    private boolean checkTaxi(int pickTime){
        for(Taxi i: taxiList){
            if(i.getDropupTime() <= pickTime){
                availableTaxi.add(i);
            }
        }
        return !availableTaxi.isEmpty();
    }

    public void bookTaxi(char pickPoint,char dropPoint,int pickTime){
        if(checkTaxi(pickTime)){
            Taxi taxi = findTaxi(pickPoint);
            setupTaxi(taxi,pickPoint,dropPoint,pickTime);
            System.out.println(taxi.getTaxiName() + " is allocated ");
        }else{
            System.out.println("Taxi not allocated");
        }
    }

    public void showDetails() {
        System.out.println("\n");
        System.out.println("****** Booking History details ******");
        System.out.println(" uniqueId  customerId  pick_point  drop_point  " +
                "pickUpTime  dropUpTime  fare ");

        Collections.sort(bookingHistory);

        for(Taxi i:taxiList){
            if(i.getFare() != 0){
                System.out.println(i.getTaxiName() + "  Total Earnings: " + i.getTotalEarning());
            }
            for(History j: bookingHistory){
                if(i.getTaxiName().equals(j.getTaxiNo())){
                    System.out.println(j.getId() + "  " + j.getCusId() + "  " + j.getPickPoint() + "  "
                            + j.getDropPoint() + "  " + j.getPickTime()+ "  " + j.getDropTime() + "  " + j.getFare());
                }
            }
        }

    }


}
