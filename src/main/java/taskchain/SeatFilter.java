package taskchain;

import constants.ExceptionHandler;

public class SeatFilter extends AbstractBookingFilter{
    public SeatFilter(AbstractBookingFilter nextBookingFilter) {
        super(nextBookingFilter);
    }

    @Override
    public boolean validate(bookingList bookingList) {
        if (bookingList.isSeatEnough()) {
            System.out.println("seat good");
            return true;
        }
        String bookname = bookingList.getBookName();
        String content = "Please enter correct booking details for " + bookname + " : seat is not enough";
        ExceptionHandler.createFile();
        ExceptionHandler.writeFile(content);
        return false;
    }
}
