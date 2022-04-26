package factory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import classes.Flight;
import implement.Business;
import implement.Economy;
import implement.PremiumEconomy;

public class Pricefactory {
    public Map<String, List<Flight>> flightMap;
    public Map<String, List<String[]>> priceMap;

    public Pricefactory(Map<String, List<Flight>> flightMap) {
        this.flightMap = flightMap;
        this.priceMap = new HashMap<>();
    }

    public void setPriceMap() {
        priceMap.put("Economy", new Economy(flightMap).getprice());
        priceMap.put("PremiumEconomy", new PremiumEconomy(flightMap).getprice());
        priceMap.put("Business", new Business(flightMap).getprice());
    }

    public Map<String, List<String[]>> getPriceMap() {
        return priceMap;
    }

    public int getPrice(String category, String flightNumber) {
        for(String key : priceMap.keySet()) {
            if (category.equals(key)) {
                List<String[]> curPrice = priceMap.get(key);
                for(String[] prices : curPrice) {
                    if(prices[0].equals(flightNumber)) {
                        return Integer.parseInt(prices[1]);
                    }
                }
            }
        }
        return 0;
    }

}
