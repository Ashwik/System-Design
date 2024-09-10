package LowLevelDesign.BookMyShow.Booking;

import LowLevelDesign.BookMyShow.Enum.BookingStatus;
import LowLevelDesign.BookMyShow.Movie.ShowSeat;
import LowLevelDesign.BookMyShow.Payment.Payment;
import LowLevelDesign.BookMyShow.Movie.Show;

import java.util.*;

public class Booking {

    String bookingId;
    int numberOfSeats;
    Date createdOn;
    BookingStatus status;

    Show show;
    List<ShowSeat> seats;
    Payment payment;

    public boolean makePayment(Payment payment){
        return true;
    }

    public boolean assignSeats(List<ShowSeat> seats){
        return true;
    }
}
