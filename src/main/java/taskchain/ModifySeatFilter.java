package taskchain;

public class ModifySeatFilter extends AbstractBookingFilter{
    public ModifySeatFilter(AbstractBookingFilter nextBookingFilter) {
        super(nextBookingFilter);
    }

    @Override
    public boolean validate(bookingList bookingList) {
        bookingList.modifySeat();
        return true;
    }
}
