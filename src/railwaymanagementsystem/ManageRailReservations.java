

import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author casper
 */
public class ManageRailReservations {

    private static ArrayList<RailTrip> listOfRailtrips;
    private static ArrayList<Passenger> listOfRegistedPssengers = new ArrayList();
    private static final Scanner scn = new Scanner(System.in);

    public RailTrip findRailTripById(int railTripId) {
        for (int i = 0; i < listOfRailtrips.size(); i++) {
            if (railTripId == listOfRailtrips.get(i).getRailTripId()) {
                return listOfRailtrips.get(i);
            }

        }
        return null;
    }

    public Passenger findPassengerById(int passengerId) {
        for (int i = 0; i < listOfRegistedPssengers.size(); i++) {
            if (passengerId == listOfRegistedPssengers.get(i).getAccountId()) {
                return listOfRegistedPssengers.get(i);
            }
        }
        return null;
    }

    public static void addPassenger() {
        System.out.print("Give Passenger Name: ");
        String name = scn.next();
        System.out.print("adres: ");
        String adr = scn.next();
        System.out.print("Phone Num: ");
        int number = scn.nextInt();
        System.out.print("Password: ");
        String pass = scn.next();
        Passenger a = new Passenger(name, adr, number, pass);
        listOfRegistedPssengers.add(a);
    }

    public static void addRailTrip() {
        System.out.println("Enter number of first class setas");
        int firstclasssseat = scn.nextInt();
        System.out.println("Enter number of avaliable seat umber");
        int numberofavalibleseeat = scn.nextInt();
        RailTrip b = new RailTrip(firstclasssseat, numberofavalibleseeat);
        listOfRailtrips.add(b);

    }

    public static void getRailTripInfo() {
        for (int i = 0; i < listOfRailtrips.size(); i++) {
            System.out.println(listOfRailtrips.get(i).getRailTripInfo());
        }
    }

    public static void printsallPassengers() {//  
        for (int i = 0; i < listOfRegistedPssengers.size(); i++) {
            System.out.println(listOfRegistedPssengers.get(i).toString());
        }
    }

    public static void showReservation(int id) {
        for (int i = 0; i < listOfRegistedPssengers.size(); i++) {
            Reservation rsr = listOfRegistedPssengers.get(i).findReservation(id);
            if (rsr != null) {
                System.out.println(rsr.getReservationInfo());
            }
        }
    }

    public static void addReservation(int passengerId, String psw) {
        System.out.println("enter your ıd and password");
        Scanner scn = new Scanner(System.in);
        Passenger a = new Passenger();
        if (a.login(psw)) {
            RailTrip mytrip = null;
            a.newReservation(mytrip, scn.nextInt(), scn.nextInt());
        }
    }

    public static void cancelReservation(int reservationId, String psw) {
        Scanner scn = new Scanner(System.in);
        Passenger a = new Passenger();
        if (a.login(psw)) {
            System.out.println("enter the reservation code");
            int reservationCode = scn.nextInt();
            a.cancelReservation(reservationId);
        }
    }

    public static void main(String[] args) {
        System.out.println("1 - add passenger"
                + "2- Add Railtrip" + "3-Show all passengers:"
                + "4Show all trips" + "(5) Add a reservation for an existing passenger"
                + "(6) Display a reservation:" + "(7) Cancel a reservation"
                + "(0) Quit");
        int choice = scn.nextInt();
        boolean quit = false;
        while (!quit) {
            System.out.println("1 - add passenger"
                    + "2- Add Railtrip" + "3-Show all passengers:"
                    + "4Show all trips" + "(5) Add a reservation for an existing passenger"
                    + "(6) Display a reservation:" + "(7) Cancel a reservation"
                    + "(0) Quit");
            switch (choice) {
                case 1:
                    addPassenger();
                    break;
                case 2:
                    addRailTrip();
                    break;
                case 3:
                    printsallPassengers();
                    break;
                case 4:
                    getRailTripInfo();
                    break;
                case 5:
                    addReservation(scn.nextInt(), scn.next());
                    break;
                case 6:
                    showReservation(scn.nextInt());
                    break;
                case 7:
                    cancelReservation(scn.nextInt(), scn.next());
                    break;
                case 0:
                    quit = true;
                default:
                    break;

            }
            choice = scn.nextInt();
        }
    }
}
