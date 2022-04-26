package taskchain;

import classes.Flight;
import classes.GenerateFlightList;
import classes.GenerateOrderList;
import classes.Order;
import com.opencsv.exceptions.CsvValidationException;
import constants.CSVHandler;
import org.junit.Test;
import services.FlightService;
import services.PaymentService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class CardFilterTest {

    @Test
    public void validateHappy() throws IOException, CsvValidationException {
        Map<String, List<Flight>> flightMap = new HashMap<>();
        CSVHandler csvHandler = new CSVHandler(new String[]{"Booking name", " flight number", "Category", " number of seats booked", " total price"});

        Flight flight = new Flight("Business", "BY110", "5", "2000", "Seattle", "San jose");
        Order order = new Order("Nick", "BY110", "Business", "2", "5410000000000000");
        flightMap.put(flight.getFlightNumber(), new ArrayList<>());
        flightMap.get(flight.getFlightNumber()).add(flight);
        PaymentService paymentService = new PaymentService(order, flightMap);
        FlightService flightService = new FlightService(order, flightMap);

        bookingList bookingList = new bookingList(order, flightMap, flightService, paymentService, csvHandler);

        CardFilter cardFilter = new CardFilter(null);
        assertTrue(cardFilter.validate(bookingList));
    }

    @Test
    public void validateFailed() throws IOException, CsvValidationException {
        Map<String, List<Flight>> flightMap = new HashMap<>();
        CSVHandler csvHandler = new CSVHandler(new String[]{"Booking name", " flight number", "Category", " number of seats booked", " total price"});

        Flight flight = new Flight("Business", "BY110", "5", "2000", "Seattle", "San jose");
        Order order = new Order("Nick", "BY110", "Business", "2", "123123123");
        flightMap.put(flight.getFlightNumber(), new ArrayList<>());
        flightMap.get(flight.getFlightNumber()).add(flight);
        PaymentService paymentService = new PaymentService(order, flightMap);
        FlightService flightService = new FlightService(order, flightMap);

        bookingList bookingList = new bookingList(order, flightMap, flightService, paymentService, csvHandler);

        CardFilter cardFilter = new CardFilter(null);
        assertFalse(cardFilter.validate(bookingList));
    }
}