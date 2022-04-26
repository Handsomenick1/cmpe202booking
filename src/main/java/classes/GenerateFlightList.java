package classes;

import java.util.ArrayList;
import java.util.List;

public class GenerateFlightList {
    private List<String[]> flightsData;
    private List<Flight> listOfFlight;

    public GenerateFlightList(List<String[]> flightsData) {
        this.flightsData = flightsData;
        this.listOfFlight = new ArrayList<>();
    }

    public void generateList() {
        for(String[] flight : flightsData) {
            String category = flight[0];
            String flightNum = flight[1];
            String seat = flight[2];
            String price = flight[3];
            String arrival = flight[4];
            String departure = flight[5];
            Flight flight1 = new Flight(category, flightNum, seat, price, arrival, departure);
            listOfFlight.add(flight1);
        }
    }

    public List<Flight> getListOfFlight() {
        return listOfFlight;
    }

    public void setListOfFlight(List<Flight> listOfFlight) {
        this.listOfFlight = listOfFlight;
    }
}
