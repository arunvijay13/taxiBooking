package com.booking;

import java.util.Scanner;

public class App {
    private static final Scanner sc = new Scanner(System.in);
    private static final Booking book = new Booking();

    public static void main(String[] args) {

        int choice;
        boolean quit = false;

        System.out.println("********** welcome ************");
        System.out.println("For booking please enter press 0");
        System.out.println("For showing booking history details press 1");
        System.out.println("For canceling please press 2");

        while(!quit){
            System.out.println("enter the choice");
            choice = sc.nextInt();
            sc.nextLine();

            switch(choice){
                case 0:
                    bookingTaxi();
                    break;
                case 1:
                    book.showDetails();
                    break;
                case 2:
                    quit = true;
                    System.out.println("Thankyou for using taxi application");
                    break;
            }




        }

    }

    public static void bookingTaxi(){
        char pickupPoint;
        char dropPoint;
        int pickupTime;

        System.out.println("enter the pickup point");
        pickupPoint =  sc.next().charAt(0);
        System.out.println("enter the dropup point");
        dropPoint = sc.next().charAt(0);
        System.out.println("enter the pickup time");
        pickupTime = sc.nextInt();
        sc.nextLine();

        book.bookTaxi(pickupPoint,dropPoint,pickupTime);

    }

}
