package implement;

import classes.Flight;
import strategy.CategoryStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Business implements CategoryStrategy {
    private Map<String, List<Flight>> flightMap;
    private List<String[]> result;
    private final List<String[]> seatList;
    public Business(Map<String, List<Flight>> flightMap) {
        this.flightMap = flightMap;
        this.seatList = new ArrayList<>();
        this.result = new ArrayList<>();
    }

    @Override
    public List<String[]> getprice() {
        for(Map.Entry<String, List<Flight>> entry : flightMap.entrySet()) {
            List<Flight> flights = entry.getValue();
            for(Flight flight : flights) {
                if (flight.getCategory().equals("Business")){
                    String[] curPrice = {flight.getFlightNumber(), String.valueOf(flight.getPrice())};
                    result.add(curPrice);
                }
            }
        }
        return result;
    }

    @Override
    public List<String[]> getseats() {
        for(Map.Entry<String, List<Flight>> entry : flightMap.entrySet()) {
            List<Flight> flights = entry.getValue();
            for(Flight flight : flights) {
                if (flight.getCategory().equals("Business")){
                    String[] curseats = {flight.getFlightNumber(), String.valueOf(flight.getAvailableSeats())};
                    seatList.add(curseats);
                }
            }
        }
        return seatList;
    }
}
