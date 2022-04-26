package factory;

import classes.Flight;
import classes.Order;
import constants.CSVHandler;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class PricefactoryTest {

    @Test
    public void getPrice() {
        Map<String, List<Flight>> flightMap = new HashMap<>();
        CSVHandler csvHandler = new CSVHandler(new String[]{"Booking name", " flight number", "Category", " number of seats booked", " total price"});

        Flight flight = new Flight("Business", "BY110", "5", "2000", "Seattle", "San jose");
        flightMap.put(flight.getFlightNumber(), new ArrayList<>());
        flightMap.get(flight.getFlightNumber()).add(flight);
        Pricefactory pricefactory = new Pricefactory(flightMap);
        pricefactory.setPriceMap();
        assertEquals(2000, pricefactory.getPrice("Business", "BY110"));
    }
}