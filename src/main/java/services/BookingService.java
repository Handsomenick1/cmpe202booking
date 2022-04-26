package services;
import classes.Order;


public class BookingService {
    private Order order;
    private FlightService flightService;
    private PaymentService paymentService;

    public BookingService(Order order, FlightService flightService, PaymentService paymentService) {
        this.order = order;
        this.flightService = flightService;
        this.paymentService = paymentService;
    }

    public void getOutput() {
        //booking name, flight number, Category, number of seats booked, total price.
        String bookName = order.getBookingName();
        String flightNumber = order.getFlightNumber();
        String category = order.getSeatCategory();
        String numberOfSeats = order.getNumberOfSeats();
        int totalPrice = paymentService.getTotalPrice();

    }
}
