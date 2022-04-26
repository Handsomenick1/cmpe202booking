package taskchain;

import classes.Flight;
import classes.Order;
import constants.CSVHandler;
import org.junit.Test;
import services.FlightService;
import services.PaymentService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class SeatFilterTest {

    @Test
    public void validateHappy() {
        Map<String, List<Flight>> flightMap = new HashMap<>();
        CSVHandler csvHandler = new CSVHandler(new String[]{"Booking name", " flight number", "Category", " number of seats booked", " total price"});

        Flight flight = new Flight("Business", "BY110", "5", "2000", "Seattle", "San jose");
        Order order = new Order("Nick", "BY110", "Business", "2", "5410000000000000");
        flightMap.put(flight.getFlightNumber(), new ArrayList<>());
        flightMap.get(flight.getFlightNumber()).add(flight);
        PaymentService paymentService = new PaymentService(order, flightMap);
        FlightService flightService = new FlightService(order, flightMap);

        bookingList bookingList = new bookingList(order, flightMap, flightService, paymentService, csvHandler);
        SeatFilter seatFilter = new SeatFilter(null);
        assertTrue(seatFilter.validate(bookingList));
    }

    @Test
    public void validateFailed() {
        Map<String, List<Flight>> flightMap = new HashMap<>();
        CSVHandler csvHandler = new CSVHandler(new String[]{"Booking name", " flight number", "Category", " number of seats booked", " total price"});

        Flight flight = new Flight("Business", "BY110", "1", "2000", "Seattle", "San jose");
        Order order = new Order("Nick", "BY110", "Business", "2", "5410000000000000");
        flightMap.put(flight.getFlightNumber(), new ArrayList<>());
        flightMap.get(flight.getFlightNumber()).add(flight);
        PaymentService paymentService = new PaymentService(order, flightMap);
        FlightService flightService = new FlightService(order, flightMap);

        bookingList bookingList = new bookingList(order, flightMap, flightService, paymentService, csvHandler);
        SeatFilter seatFilter = new SeatFilter(null);
        assertFalse(seatFilter.validate(bookingList));
    }

}