


import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author casper
 */
public class RailTrip {

    private String fromLocation;
    private String toLocation;
    private Date dateOfTrip;
    private int numberOfAvailableFirstClassSeats;
    private int numberOfAvailableRegularSeats;
    private int railTripId = 10000;
    private static int count;
    private boolean isReserved;

    public RailTrip(String fromLocation, String toLocation, Date dateOfTrip, int numberOfAvailableFirstClassSeats, int numberOfAvailableRegularSeats, boolean isReserved) {
        this.fromLocation = fromLocation;
        this.toLocation = toLocation;
        this.dateOfTrip = new Date();
        this.numberOfAvailableFirstClassSeats = numberOfAvailableFirstClassSeats;
        this.numberOfAvailableRegularSeats = numberOfAvailableRegularSeats;
        this.isReserved = isReserved;
        count++;
    }

    public RailTrip(int numberOfAvailableFirstClassSeats, int numberOfAvailableRegularSeats) {
        this.numberOfAvailableFirstClassSeats = numberOfAvailableFirstClassSeats = 30;
        this.numberOfAvailableRegularSeats = numberOfAvailableRegularSeats = 70;
        dateOfTrip = new Date();
        count++;
    }

    RailTrip() {
        
    }

    public boolean reserveSeats(int numOfSeats, int typeOfSeats) {//1 represents first class,0 represents regular class.
        if (isReserved) {//numofseats ve typeof seatsleri attribute olarak eklemem gerekmez di mi?
            if (typeOfSeats == 1) {
                numberOfAvailableFirstClassSeats--;
            }
            if (typeOfSeats == 0) {
                if (isReserved) {
                    numberOfAvailableRegularSeats--;
                }
            }
        }
        if (numOfSeats != 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean releaseSeats(int numOfSeats, int typeOfSeats) {//1 represents first class,0 represents regular class.
        if (!isReserved) {
            if (typeOfSeats == 1) {
                numberOfAvailableFirstClassSeats++;
            }
            if (typeOfSeats == 0) {
                if (isReserved) {
                    numberOfAvailableRegularSeats++;
                }
            }
        }
         if (numOfSeats != 0) {
            return true;
        } else {
            return false;
        }

    }

    public int getRailTripId() {
        return railTripId;
    }

    public String getFromLocation() {
        return fromLocation;
    }

    public String getToLocation() {
        return toLocation;
    }

    public Date getTripDate() {
        return dateOfTrip;
    }

    public String getRailTripInfo() {
        return "Railtrip Info: \n"
                + "trip id:" + railTripId
                + "/From " + fromLocation
                + "/To " + toLocation
                + "/Trip date:" + dateOfTrip;

    }

}
