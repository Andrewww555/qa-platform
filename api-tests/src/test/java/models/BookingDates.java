package models;

public class BookingDates {
    private final String checkin;
    private final String checkout;

    public BookingDates(String checkin, String checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public String getCheckin() { return checkin; }
    public String getCheckout() { return checkout; }
}
