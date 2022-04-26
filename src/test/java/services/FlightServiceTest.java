package services;

import classes.Flight;
import classes.Order;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class FlightServiceTest {

    @Test
    public void isFlightExistsHappy() {
        Flight flight = new Flight("Business", "BY110", "5", "2000", "Seattle", "San jose");
        Order order = new Order("Nick", "BY110", "Business", "2", "5410000000000000");
        Map<String, List<Flight>> flightMap = new HashMap<>();
        flightMap.put(flight.getFlightNumber(), new ArrayList<>());
        flightMap.get(flight.getFlightNumber()).add(flight);
        FlightService flightService = new FlightService(order, flightMap);
        assertTrue(flightService.isFlightExists());
    }

    @Test
    public void isFlightExistsFailed() {
        Flight flight = new Flight("Business", "BY110", "5", "2000", "Seattle", "San jose");
        Order order = new Order("Nick", "BY1110", "Business", "2", "5410000000000000");
        Map<String, List<Flight>> flightMap = new HashMap<>();
        flightMap.put(flight.getFlightNumber(), new ArrayList<>());
        flightMap.get(flight.getFlightNumber()).add(flight);
        FlightService flightService = new FlightService(order, flightMap);
        assertFalse(flightService.isFlightExists());
    }

    @Test
    public void enoughSeatsHappy() {
        Flight flight = new Flight("Business", "BY110", "5", "2000", "Seattle", "San jose");
        Order order = new Order("Nick", "BY110", "Business", "2", "5410000000000000");
        Map<String, List<Flight>> flightMap = new HashMap<>();
        flightMap.put(flight.getFlightNumber(), new ArrayList<>());
        flightMap.get(flight.getFlightNumber()).add(flight);
        FlightService flightService = new FlightService(order, flightMap);
        assertTrue(flightService.enoughSeats());
    }
    @Test
    public void enoughSeatsFailed() {
        Flight flight = new Flight("Business", "BY110", "1", "2000", "Seattle", "San jose");
        Order order = new Order("Nick", "BY110", "Business", "2", "5410000000000000");
        Map<String, List<Flight>> flightMap = new HashMap<>();
        flightMap.put(flight.getFlightNumber(), new ArrayList<>());
        flightMap.get(flight.getFlightNumber()).add(flight);
        FlightService flightService = new FlightService(order, flightMap);
        assertFalse(flightService.enoughSeats());
    }

}