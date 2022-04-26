package implement;

import services.CheckCardService;

public class VisaCard implements CheckCardService {
    private String cardNumber;

    public VisaCard(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public boolean validCard() {
        return ((cardNumber.length() == 13 || cardNumber.length() == 16) && cardNumber.charAt(0) == '4');
    }
}
