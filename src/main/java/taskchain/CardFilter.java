package taskchain;

import constants.ExceptionHandler;

public class CardFilter extends AbstractBookingFilter{
    public CardFilter(AbstractBookingFilter nextBookingFilter) {
        super(nextBookingFilter);
    }

    @Override
    public boolean validate(bookingList bookingList) {
        if (bookingList.isCardValid()) {
            System.out.println("Card good");
            return true;
        }
        String bookname = bookingList.getBookName();
        String content = "Please enter correct booking details for " + bookname + " : invalid card";
        ExceptionHandler.createFile();
        ExceptionHandler.writeFile(content);
        return false;
    }
}
