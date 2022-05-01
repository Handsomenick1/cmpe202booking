package taskchain;

import classes.Flight;
import classes.Order;
import constants.CSVHandler;
import constants.ExceptionHandler;
import org.junit.Test;
import services.FlightService;
import services.PaymentService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class FlightFilterTest {

    @Test
    public void validateHappy() {
        Map<String, List<Flight>> flightMap = new HashMap<>();
        CSVHandler csvHandler = new CSVHandler(new String[]{"Booking name", " flight number", "Category", " number of seats booked", " total price"}, "/Users/fuyuzhang/Documents/sjsu-2022spring/cmpe-202/projectdoc");
        ExceptionHandler exceptionHandler = new ExceptionHandler("/Users/fuyuzhang/Documents/sjsu-2022spring/cmpe-202/projectdoc");

        Flight flight = new Flight("Business", "BY110", "5", "2000", "Seattle", "San jose");
        Order order = new Order("Nick", "BY110", "Business", "2", "5410000000000000");
        flightMap.put(flight.getFlightNumber(), new ArrayList<>());
        flightMap.get(flight.getFlightNumber()).add(flight);
        PaymentService paymentService = new PaymentService(order, flightMap);
        FlightService flightService = new FlightService(order, flightMap);

        bookingList bookingList = new bookingList(order, flightMap, flightService, paymentService, csvHandler);
        FlightFilter flightFilter = new FlightFilter(null, exceptionHandler);
        assertTrue(flightFilter.validate(bookingList));
    }

    @Test
    public void validateFailed() {
        Map<String, List<Flight>> flightMap = new HashMap<>();
        CSVHandler csvHandler = new CSVHandler(new String[]{"Booking name", " flight number", "Category", " number of seats booked", " total price"}, "/Users/fuyuzhang/Documents/sjsu-2022spring/cmpe-202/projectdoc");
        ExceptionHandler exceptionHandler = new ExceptionHandler("/Users/fuyuzhang/Documents/sjsu-2022spring/cmpe-202/projectdoc");

        Flight flight = new Flight("Business", "BY1110", "5", "2000", "Seattle", "San jose");
        Order order = new Order("Nick", "BY110", "Business", "2", "5410000000000000");
        flightMap.put(flight.getFlightNumber(), new ArrayList<>());
        flightMap.get(flight.getFlightNumber()).add(flight);
        PaymentService paymentService = new PaymentService(order, flightMap);
        FlightService flightService = new FlightService(order, flightMap);

        bookingList bookingList = new bookingList(order, flightMap, flightService, paymentService, csvHandler);
        FlightFilter flightFilter = new FlightFilter(null, exceptionHandler);
        assertFalse(flightFilter.validate(bookingList));
    }
}