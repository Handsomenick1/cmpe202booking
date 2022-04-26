package services;

import classes.Flight;
import classes.Order;
import factory.SeatFactory;

import java.util.List;
import java.util.Map;

public class FlightService {
    private final Order order;
    public Map<String, List<Flight>> flightMap;

    public FlightService(Order order, Map<String, List<Flight>> flightMap) {
        this.order = order;
        this.flightMap = flightMap;
    }

    public boolean isFlightExists(){
        String orderFlightNum = order.getFlightNumber();
        if (orderFlightNum == null || orderFlightNum.length() == 0) {
            return false;
        }

        for(String flightNum : flightMap.keySet()) {
            if (orderFlightNum.equals(flightNum)) {
                return true;
            }
        }

        return false;
    }

    public boolean enoughSeats() {
        int orderSeats = Integer.parseInt(order.getNumberOfSeats());
        String category = order.getSeatCategory();
        String flightNum = order.getFlightNumber();

        for(Map.Entry<String, List<Flight>> flight : flightMap.entrySet()) {
            List<Flight> oneFlight = flight.getValue();
            for(Flight curFlight : oneFlight) {
                if (category.equals(curFlight.getCategory()) && flightNum.equals(curFlight.getFlightNumber()) && orderSeats <= curFlight.getAvailableSeats()) {
                    return true;
                }
            }
        }
        return false;
    }

    public void modifySeat() {
        SeatFactory seatFactory = new SeatFactory(flightMap);
        seatFactory.setSeatMap();
        seatFactory.modifySeat(order.getSeatCategory(), order.getNumberOfSeats(), order.getFlightNumber());
    }


}
