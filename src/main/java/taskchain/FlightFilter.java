package taskchain;

import constants.ExceptionHandler;

public class FlightFilter extends AbstractBookingFilter{
    private ExceptionHandler exceptionHandler;

    public FlightFilter(AbstractBookingFilter nextBookingFilter, ExceptionHandler exceptionHandler) {
        super(nextBookingFilter);
        this.exceptionHandler = exceptionHandler;
    }

    @Override
    public boolean validate(bookingList bookingList) {
        if (bookingList.isFlightExist()){
            System.out.println("Flight Available");
            return true;
        }
        // Flight is not available
        String bookname = bookingList.getBookName();
        String content = "Please enter correct booking details for " + bookname + " : No such flight number";
        exceptionHandler.createFile();
        exceptionHandler.writeFile(content);
        return false;
    }
}
