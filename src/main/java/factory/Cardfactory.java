package factory;

import implement.AmexCard;
import implement.DiscoverCard;
import implement.MasterCard;
import implement.VisaCard;

public class Cardfactory {
    private String cardNumber;
    private AmexCard amexCard;
    private MasterCard masterCard;
    private DiscoverCard discoverCard;
    private VisaCard visaCard;
    public Cardfactory(String cardNumber) {
        this.cardNumber = cardNumber;
        this.amexCard = new AmexCard(cardNumber);
        this.masterCard = new MasterCard(cardNumber);
        this.discoverCard = new DiscoverCard(cardNumber);
        this.visaCard = new VisaCard(cardNumber);
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public AmexCard getAmexCard() {
        return amexCard;
    }

    public MasterCard getMasterCard() {
        return masterCard;
    }

    public DiscoverCard getDiscoverCard() {
        return discoverCard;
    }

    public VisaCard getVisaCard() {
        return visaCard;
    }

    public boolean cardValid() {
        return amexCard.validCard() || masterCard.validCard() || discoverCard.validCard() || visaCard.validCard();
    }
}
