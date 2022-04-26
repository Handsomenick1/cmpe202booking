package factory;

import classes.Flight;
import implement.Business;
import implement.Economy;
import implement.PremiumEconomy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SeatFactory {
    public Map<String, List<Flight>> flightMap;
    public Map<String, List<String[]>> seatMap;
    public SeatFactory(Map<String, List<Flight>> flightMap) {
        this.flightMap = flightMap;
        this.seatMap = new HashMap<>();
    }

    public void setSeatMap() {
        seatMap.put("Economy", new Economy(flightMap).getseats());
        seatMap.put("PremiumEconomy", new PremiumEconomy(flightMap).getseats());
        seatMap.put("Business", new Business(flightMap).getseats());
    }

    public boolean modifySeat(String category, String takenseat, String flightNum) {
        for(String key : seatMap.keySet()) {
            if(key.equals(category)) {
                List<String[]> seatList = seatMap.get(key);
                for(String[] seat : seatList) {
                    if(flightNum.equals(seat[0])) {
                        int curSeat = Integer.parseInt(seat[1]) - Integer.parseInt(takenseat);
                        seat[1] = String.valueOf(curSeat);
                        List<Flight> flights = flightMap.get(flightNum);
                        for(Flight flight: flights) {
                            if (flight.getCategory().equals(category) && flight.getFlightNumber().equals(flightNum)) {
                                flight.setAvailableSeats(curSeat);
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}
