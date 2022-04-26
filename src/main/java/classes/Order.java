package classes;

public class Order {
    private String bookingName;
    private String flightNumber;
    private String seatCategory;
    private String numberOfSeats;
    private String card;


    public Order(String bookingName, String flightNumber, String seatCategory, String numberOfSeats, String card) {
        this.bookingName = bookingName;
        this.flightNumber = flightNumber;
        this.seatCategory = seatCategory;
        this.numberOfSeats = numberOfSeats;
        this.card = card;
    }

    public String getBookingName() {
        return bookingName;
    }

    public void setBookingName(String bookingName) {
        this.bookingName = bookingName;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getSeatCategory() {
        return seatCategory;
    }

    public void setSeatCategory(String seatCategory) {
        this.seatCategory = seatCategory;
    }

    public String getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(String numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String getCard() {
        return card;
    }
    public void setCard(String card) {
        this.card = card;
    }
    public String getOrder() {
        return "bookingName: " + this.bookingName +
                ", flightNumber: " + this.flightNumber +
                ", category: " + this.seatCategory +
                ", # of seats: " + this.numberOfSeats +
                ", card: " + this.card;
    }
}
