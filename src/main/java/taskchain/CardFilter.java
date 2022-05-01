package taskchain;

import constants.ExceptionHandler;

public class CardFilter extends AbstractBookingFilter{
    private ExceptionHandler exceptionHandler;
    public CardFilter(AbstractBookingFilter nextBookingFilter, ExceptionHandler exceptionHandler) {
        super(nextBookingFilter);
        this.exceptionHandler = exceptionHandler;
    }

    @Override
    public boolean validate(bookingList bookingList) {
        if (bookingList.isCardValid()) {
            System.out.println("Card Validated");
            return true;
        }
        String bookname = bookingList.getBookName();
        String content = "Please enter correct booking details for " + bookname + " : invalid card";
        exceptionHandler.createFile();
        exceptionHandler.writeFile(content);
        return false;
    }
}
