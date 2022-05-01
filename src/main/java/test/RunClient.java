package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opencsv.exceptions.CsvValidationException;

import classes.Flight;
import classes.GenerateFlightList;
import classes.GenerateOrderList;
import classes.Order;
import constants.CSVHandler;
import constants.ExceptionHandler;
import services.FlightService;
import services.PaymentService;
import taskchain.AbstractBookingFilter;
import taskchain.CardFilter;
import taskchain.FlightFilter;
import taskchain.GenerateResFilter;
import taskchain.ModifySeatFilter;
import taskchain.SeatFilter;
import taskchain.bookingList;

public class RunClient {
    public static void main(String[] args) throws IOException, CsvValidationException {
        CSVHandler csvHandler = new CSVHandler(new String[]{"Booking name", " flight number", "Category", " number of seats booked", " total price"}, args[2]);
        ExceptionHandler exceptionHandler = new ExceptionHandler(args[3]);

        Map<String, List<Flight>> flightMap = new HashMap<>();
        // read flight data
        List<String[]> flightsdata = csvHandler.readData(args[1]);
        GenerateFlightList generateFlightList = new GenerateFlightList(flightsdata);
        generateFlightList.generateList();

        // build flight map
        for(Flight flight1 : generateFlightList.getListOfFlight()) {
            String key = flight1.getFlightNumber();
            if (!flightMap.containsKey(key)) {
                flightMap.put(key, new ArrayList<>());
            }
            flightMap.get(key).add(flight1);
        }
        
        // read order data
        List<String[]> orders = csvHandler.readData(args[0]);

        GenerateOrderList generateOrderList = new GenerateOrderList(orders);
        List<Order> orderList = generateOrderList.generateList();

        // Iterate order list
        for (Order order : orderList) {
            System.out.println("*** Order Information --->");
            System.out.println(order.getOrder());

            PaymentService paymentService = new PaymentService(order, flightMap);
            FlightService flightService = new FlightService(order, flightMap);

            bookingList bookingList = new bookingList(order, flightMap, flightService, paymentService, csvHandler);

            AbstractBookingFilter generateresFilter = new GenerateResFilter(null);
            AbstractBookingFilter modifyseatFilter = new ModifySeatFilter(generateresFilter);
            AbstractBookingFilter cardCheck = new CardFilter(modifyseatFilter, exceptionHandler);
            AbstractBookingFilter seatCheck = new SeatFilter(cardCheck, exceptionHandler);
            AbstractBookingFilter flightCheck = new FlightFilter(seatCheck, exceptionHandler);
            flightCheck.doFilter(bookingList);

            System.out.println("--------------------------------------------");
        }

    }
}
