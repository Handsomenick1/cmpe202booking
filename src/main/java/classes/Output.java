package classes;

public class Output {
    private String BookingName;
    private String FlightNumber;
    private String Category;
    private int NumberOfSeatsBooked;
    private int TotalPrice;

    public Output(String bookingName, String flightNumber, String category, int numberOfSeatsBooked, int totalPrice) {
        BookingName = bookingName;
        FlightNumber = flightNumber;
        Category = category;
        NumberOfSeatsBooked = numberOfSeatsBooked;
        TotalPrice = totalPrice;
    }

    public String getBookingName() {
        return BookingName;
    }

    public void setBookingName(String bookingName) {
        BookingName = bookingName;
    }

    public String getFlightNumber() {
        return FlightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        FlightNumber = flightNumber;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public int getNumberOfSeatsBooked() {
        return NumberOfSeatsBooked;
    }

    public void setNumberOfSeatsBooked(int numberOfSeatsBooked) {
        NumberOfSeatsBooked = numberOfSeatsBooked;
    }

    public int getTotalPrice() {
        return TotalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        TotalPrice = totalPrice;
    }
}
