package implement;

import services.CheckCardService;

public class AmexCard implements CheckCardService {
    private String cardNumber;

    public AmexCard(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public boolean validCard() {
        return cardNumber.length() == 15 && cardNumber.charAt(0) == '3' && (cardNumber.charAt(1) == '4' || cardNumber.charAt(1) == '7');
    }
}