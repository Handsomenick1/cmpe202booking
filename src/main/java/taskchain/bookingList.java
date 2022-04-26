package taskchain;

import classes.Flight;
import classes.Order;
import constants.CSVHandler;
import services.FlightService;
import services.PaymentService;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class bookingList {
    private Order order;
    private Map<String , List<Flight>> flightMap;
    private FlightService flightService;
    private PaymentService paymentService;
    private CSVHandler csvHandler;

    public bookingList(Order order, Map<String, List<Flight>> flightMap, FlightService flightService, PaymentService paymentService, CSVHandler csvHandler) {
        this.order = order;
        this.flightMap = flightMap;
        this.flightService = flightService;
        this.paymentService = paymentService;
        this.csvHandler = csvHandler;
    }

    public boolean isFlightExist() {
        return flightService.isFlightExists();
    }

    public boolean isSeatEnough() {
        return flightService.enoughSeats();
    }

    public boolean isCardValid() {
        return paymentService.isCardValid();
    }

    public String getBookName() {
        return order.getBookingName();
    }

    public void modifySeat(){
        FlightService flightService = new FlightService(order, flightMap);
        flightService.modifySeat();
    }

    public void generateCSV() throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append(order.getBookingName()).append(",");
        sb.append(order.getFlightNumber()).append(",");
        sb.append(order.getSeatCategory()).append(",");
        sb.append(order.getNumberOfSeats()).append(",");
        sb.append(paymentService.getTotalPrice());
        csvHandler.insertData(sb.toString());
    }

}
