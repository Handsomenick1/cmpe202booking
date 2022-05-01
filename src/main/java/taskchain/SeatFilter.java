package taskchain;

import constants.ExceptionHandler;

public class SeatFilter extends AbstractBookingFilter{
    private ExceptionHandler exceptionHandler;
    public SeatFilter(AbstractBookingFilter nextBookingFilter, ExceptionHandler exceptionHandler) {
        super(nextBookingFilter);
        this.exceptionHandler = exceptionHandler;
    }

    @Override
    public boolean validate(bookingList bookingList) {
        if (bookingList.isSeatEnough()) {
            System.out.println("Seat Available");
            return true;
        }
        String bookname = bookingList.getBookName();
        String content = "Please enter correct booking details for " + bookname + " : seat is not enough";
        exceptionHandler.createFile();
        exceptionHandler.writeFile(content);
        return false;
    }
}
