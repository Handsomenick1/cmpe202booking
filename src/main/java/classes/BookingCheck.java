package classes;

import taskchain.bookingList;

public class BookingCheck {

    public void check(bookingList bookingList) {
        if (bookingList.isFlightExist()) {
            System.out.println("flight good");
        }
        if (bookingList.isSeatEnough()) {
            System.out.println("Seat good");
        }
        if (bookingList.isCardValid()) {
            System.out.println("Card good");
        }
        System.out.println("Good to pay ticket");
    }
}
