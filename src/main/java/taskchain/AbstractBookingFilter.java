package taskchain;

import java.io.IOException;

public abstract class AbstractBookingFilter {
    private AbstractBookingFilter nextBookingFilter;

    public AbstractBookingFilter(AbstractBookingFilter nextBookingFilter){
        this.nextBookingFilter = nextBookingFilter;
    }

    public boolean doFilter(bookingList bookingList) throws IOException {

        if (nextBookingFilter == null) {
            // do something
            return validate(bookingList);
        } else {
            if (!validate(bookingList)) {
                return false;
            }
            nextBookingFilter.doFilter(bookingList);
        }
        return true;
    }

    public abstract boolean validate(bookingList bookingList) throws IOException;
}
