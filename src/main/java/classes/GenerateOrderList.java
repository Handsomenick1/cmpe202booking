package classes;

import java.util.ArrayList;
import java.util.List;

public class GenerateOrderList {
    private List<String[]> roderlist;
    private List<Order> orderList;

    public GenerateOrderList(List<String[]> roderlist) {
        this.roderlist = roderlist;
        this.orderList = new ArrayList<>();
    }
    public List<Order> generateList() {
        for (String[] record : roderlist) {
            String bookingName = record[0];
            String flightNumber = record[1];
            String seatCategory = record[2];
            String numberOfSeats = record[3];
            String card = record[4];
            Order order = new Order(bookingName, flightNumber, seatCategory, numberOfSeats, card);
            this.orderList.add(order);
        }
        return orderList;
    }
    public List<String[]> getRoderlist() {
        return roderlist;
    }

    public void setRoderlist(List<String[]> roderlist) {
        this.roderlist = roderlist;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }
}
