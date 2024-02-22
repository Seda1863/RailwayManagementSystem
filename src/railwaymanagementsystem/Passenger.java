

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author casper
 */
public class Passenger {

    private String name;
    private String address;
    private int phoneNumber;
    private int accountId = 1000;
    private ArrayList<Reservation> listOfPassenger;
    private String realPass;

    public Passenger(String name, String address, int phoneNumber, String realPass) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        if (checkPassword(realPass)) {
            this.realPass = realPass;
        }else{
            this.realPass = "123456";
        }
        System.out.println("Id is" + accountId);
        this.listOfPassenger = new ArrayList<Reservation>();
    }

    Passenger() {

    }

    public String getName() {
        return name;
    }

    public String getAdress() {
        return address;
    }

    public int getPhonenumber() {
        return phoneNumber;
    }

    public int getAccountId() {
        return accountId;
    }

    private boolean  checkPassword(String s) {
        int oldDigit = s.charAt(0);
        if (s.length() != 6 || oldDigit == '0') {
            return false;
        }
        for (int i = 1; i < s.length() - 1; i++) {
            if (oldDigit == s.charAt(i)) {
                return false;
            }
            oldDigit = s.charAt(i);
        }
        return false;
    }

    public boolean login(String pwd) {
        return realPass.equals(pwd);
    }

    public Reservation findReservation(int reservationId) {

        for (int i = 0; i < listOfPassenger.size(); i++) {
            if (reservationId == listOfPassenger.get(i).getReservationId()) {
                return listOfPassenger.get(i);
            }

        }
        return null;
    }

    public int newReservation(RailTrip myTrip, int numberOfSeats, int typeOfSeats) {
        Reservation a = new Reservation(myTrip, numberOfSeats, typeOfSeats);
        a.approveReservation();
        if (a.isApproved()) {
            listOfPassenger.add(a);
            return a.getReservationId();
        }
        return -1;

    }

    public boolean cancelReservation(int reservationId) {
        Reservation reservation = this.findReservation(reservationId);
        if (reservation != null) {
            listOfPassenger.remove(reservation);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "\n Passenger Info: \n"
                + "Passenger Name: " + name + ", "
                + "Address: " + address  + ", "
                + "Phone Number: " + phoneNumber  + ", "
                + "Account ID: " + accountId  + ", "
                + "Real Password: " + realPass; //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
