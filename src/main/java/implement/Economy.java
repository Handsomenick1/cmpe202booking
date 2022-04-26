package implement;

import classes.Flight;
import strategy.CategoryStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Economy implements CategoryStrategy {
    private final Map<String, List<Flight>> flightMap;

    private final List<String[]> priceList;
    private final List<String[]> seatList;

    public Economy(Map<String, List<Flight>> flightMap) {
        this.flightMap = flightMap;
        this.seatList = new ArrayList<>();
        this.priceList = new ArrayList<>();
    }

    @Override
    public List<String[]> getprice() {
        for(Map.Entry<String, List<Flight>> entry : this.flightMap.entrySet()) {
            List<Flight> flights = entry.getValue();
            for(Flight flight : flights) {
                if (flight.getCategory().equals("Economy")){
                    String[] curPrice = {flight.getFlightNumber(), String.valueOf(flight.getPrice())};
                    this.priceList.add(curPrice);
                }
            }
        }
        return this.priceList;
    }

    @Override
    public List<String[]> getseats() {
        for(Map.Entry<String, List<Flight>> entry : this.flightMap.entrySet()) {
            List<Flight> flights = entry.getValue();
            for(Flight flight : flights) {
                if (flight.getCategory().equals("Economy")){
                    String[] curseats = {flight.getFlightNumber(), String.valueOf(flight.getAvailableSeats())};
                    this.seatList.add(curseats);
                }
            }
        }
        return this.seatList;
    }
}
