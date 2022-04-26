package taskchain;

import constants.ExceptionHandler;

public class FlightFilter extends AbstractBookingFilter{
    public FlightFilter(AbstractBookingFilter nextBookingFilter) {
        super(nextBookingFilter);
    }

    @Override
    public boolean validate(bookingList bookingList) {
        if (bookingList.isFlightExist()){
            System.out.println("flight good");
            return true;
        }
        String bookname = bookingList.getBookName();
        String content = "Please enter correct booking details for " + bookname + " : No such flight number";
        ExceptionHandler.createFile();
        ExceptionHandler.writeFile(content);
        return false;
    }
}
