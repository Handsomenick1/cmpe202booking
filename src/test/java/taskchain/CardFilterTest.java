package taskchain;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opencsv.exceptions.CsvValidationException;

import constants.ExceptionHandler;
import org.junit.Test;

import classes.Flight;
import classes.Order;
import constants.CSVHandler;
import services.FlightService;
import services.PaymentService;

public class CardFilterTest {

    @Test
    public void validateHappy() throws IOException, CsvValidationException {
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

        CardFilter cardFilter = new CardFilter(null, exceptionHandler);
        assertTrue(cardFilter.validate(bookingList));
    }

    @Test
    public void validateFailed() throws IOException, CsvValidationException {
        Map<String, List<Flight>> flightMap = new HashMap<>();
        CSVHandler csvHandler = new CSVHandler(new String[]{"Booking name", " flight number", "Category", " number of seats booked", " total price"}, "/Users/fuyuzhang/Documents/sjsu-2022spring/cmpe-202/projectdoc");
        ExceptionHandler exceptionHandler = new ExceptionHandler("/Users/fuyuzhang/Documents/sjsu-2022spring/cmpe-202/projectdoc");
        Flight flight = new Flight("Business", "BY110", "5", "2000", "Seattle", "San jose");
        Order order = new Order("Nick", "BY110", "Business", "2", "123123123");
        flightMap.put(flight.getFlightNumber(), new ArrayList<>());
        flightMap.get(flight.getFlightNumber()).add(flight);
        PaymentService paymentService = new PaymentService(order, flightMap);
        FlightService flightService = new FlightService(order, flightMap);

        bookingList bookingList = new bookingList(order, flightMap, flightService, paymentService, csvHandler);

        CardFilter cardFilter = new CardFilter(null, exceptionHandler);
        assertFalse(cardFilter.validate(bookingList));
    }
}