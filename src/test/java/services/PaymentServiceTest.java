package services;

import classes.Flight;
import classes.Order;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class PaymentServiceTest {

    @Test
    public void isCardValidHappy() {
        Flight flight = new Flight("Business", "BY110", "5", "2000", "Seattle", "San jose");
        Order order = new Order("Nick", "BY110", "Business", "2", "5410000000000000");
        Map<String, List<Flight>> flightMap = new HashMap<>();
        flightMap.put(flight.getFlightNumber(), new ArrayList<>());
        flightMap.get(flight.getFlightNumber()).add(flight);
        PaymentService paymentService = new PaymentService(order, flightMap);
        assertTrue(paymentService.isCardValid());
    }

    @Test
    public void isCardValidFailed() {
        Flight flight = new Flight("Business", "BY110", "5", "2000", "Seattle", "San jose");
        Order order = new Order("Nick", "BY110", "Business", "2", "123123123");
        Map<String, List<Flight>> flightMap = new HashMap<>();
        flightMap.put(flight.getFlightNumber(), new ArrayList<>());
        flightMap.get(flight.getFlightNumber()).add(flight);
        PaymentService paymentService = new PaymentService(order, flightMap);
        assertFalse(paymentService.isCardValid());
    }
    @Test
    public void getTotalPrice() {
        Flight flight = new Flight("Business", "BY110", "5", "2000", "Seattle", "San jose");
        Order order = new Order("Nick", "BY110", "Business", "1", "123123123");
        Map<String, List<Flight>> flightMap = new HashMap<>();
        flightMap.put(flight.getFlightNumber(), new ArrayList<>());
        flightMap.get(flight.getFlightNumber()).add(flight);
        PaymentService paymentService = new PaymentService(order, flightMap);
        Assert.assertEquals(2000, paymentService.getTotalPrice());
    }

}