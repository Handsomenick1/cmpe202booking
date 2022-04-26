package test;

import classes.Flight;
import classes.GenerateFlightList;
import classes.GenerateOrderList;
import classes.Order;
import com.opencsv.exceptions.CsvValidationException;
import constants.CSVHandler;
import services.FlightService;
import services.PaymentService;
import taskchain.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RunClient {
    public static void main(String[] args) throws IOException, CsvValidationException {
        Map<String, List<Flight>> flightMap = new HashMap<>();
        CSVHandler csvHandler = new CSVHandler(new String[]{"Booking name", " flight number", "Category", " number of seats booked", " total price"});

        // read flight data
        List<String[]> flightsdata = csvHandler.readData("/Users/fuyuzhang/Documents/sjsu-2022spring/cmpe-202/projectdoc/flights.csv");
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
        List<String[]> orders = csvHandler.readData("/Users/fuyuzhang/Documents/sjsu-2022spring/cmpe-202/projectdoc/Sample.csv");

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
            AbstractBookingFilter cardCheck = new CardFilter(modifyseatFilter);
            AbstractBookingFilter seatCheck = new SeatFilter(cardCheck);
            AbstractBookingFilter flightCheck = new FlightFilter(seatCheck);
            flightCheck.doFilter(bookingList);

            System.out.println("--------------------------------------------");
        }

    }
}
