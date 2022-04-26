package taskchain;

import java.io.IOException;

public class GenerateResFilter extends AbstractBookingFilter{
    public GenerateResFilter(AbstractBookingFilter nextBookingFilter) {
        super(nextBookingFilter);
    }

    @Override
    public boolean validate(bookingList bookingList) throws IOException {
        bookingList.generateCSV();
        return true;
    }
}
