package services;

import classes.Flight;
import classes.Order;
import factory.Cardfactory;
import factory.Pricefactory;

import java.util.List;
import java.util.Map;

public class PaymentService {
    private Order order;
    public Map<String, List<Flight>> flightMap;

    public PaymentService(Order order, Map<String, List<Flight>> flightMap) {
        this.order = order;
        this.flightMap = flightMap;
    }

    public boolean isCardValid() {
        Cardfactory cardfactory = new Cardfactory(order.getCard());
        return cardfactory.cardValid();
    }

    public int getTotalPrice() {
        int numOfGuests = Integer.parseInt(order.getNumberOfSeats());
        Pricefactory pricefactory = new Pricefactory(flightMap);
        pricefactory.setPriceMap();
        int seatPrice = pricefactory.getPrice(order.getSeatCategory().replaceAll("\\s", ""), order.getFlightNumber());
        return numOfGuests * seatPrice;
    }

}

