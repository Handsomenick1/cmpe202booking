package classes;

public class Flight {
    private String category;
    private String flightNumber;
    private String availableSeats;
    private String price;
    private String arrival;
    private String departure;

    public Flight(String category, String flightNumber, String availableSeats, String price, String arrival, String departure) {
        this.category = category;
        this.flightNumber = flightNumber;
        this.availableSeats = availableSeats;
        this.price = price;
        this.arrival = arrival;
        this.departure = departure;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public int getAvailableSeats() {
        return Integer.parseInt(availableSeats);
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = String.valueOf(availableSeats);
    }

    public int getPrice() {
        return Integer.parseInt(price);
    }

    public void setPrice(int price) {
        this.price = String.valueOf(price);
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }
}
