package factory;

import classes.Flight;
import constants.CSVHandler;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class SeatFactoryTest {

    @Test
    public void modifySeat() {
        Map<String, List<Flight>> flightMap = new HashMap<>();
        CSVHandler csvHandler = new CSVHandler(new String[]{"Booking name", " flight number", "Category", " number of seats booked", " total price"});

        Flight flight = new Flight("Business", "BY110", "5", "2000", "Seattle", "San jose");
        flightMap.put(flight.getFlightNumber(), new ArrayList<>());
        flightMap.get(flight.getFlightNumber()).add(flight);
        SeatFactory seatFactory = new SeatFactory(flightMap);
        seatFactory.setSeatMap();
        assertTrue(seatFactory.modifySeat("Business", "3","BY110"));
        assertEquals(2, flight.getAvailableSeats());
    }
}