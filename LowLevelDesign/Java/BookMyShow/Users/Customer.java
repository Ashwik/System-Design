package LowLevelDesign.BookMyShow.Users;

import LowLevelDesign.BookMyShow.Booking.Booking;

import java.util.*;

public class Customer extends Person{
    public boolean makeBooking(Booking booking){
        return true;
    }
    public List<Booking> getBookings(){
        return new ArrayList<>();
    }
}
