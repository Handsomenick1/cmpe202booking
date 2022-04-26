package implement;

import services.CheckCardService;

public class MasterCard implements CheckCardService {
    private String cardNumber;

    public MasterCard(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public boolean validCard() {
        if (cardNumber.length() == 16 && cardNumber.charAt(0) == '5') { // 1st letter
            for(int i = 1; i <= 5; i++) { // 2nd letter
                if (cardNumber.charAt(1) == (char)(i + '0')) {
                    return true;
                }
            }
        }
        return false;
    }
}