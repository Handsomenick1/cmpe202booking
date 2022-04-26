package implement;

import services.CheckCardService;

public class DiscoverCard implements CheckCardService {
    private final String cardNumber;

    public DiscoverCard(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public boolean validCard() {
        return cardNumber.length() == 16 && cardNumber.startsWith("6011");
    }
}
