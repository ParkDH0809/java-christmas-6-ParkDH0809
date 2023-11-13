package christmas.domain.event;

public class OfferedEvent {

    private final String eventName;
    private final int discountAmount;

    private OfferedEvent(String eventName, int discountAmount) {
        this.eventName = eventName;
        this.discountAmount = discountAmount;
    }

    public static OfferedEvent of(String eventName, int discountAmount) {
        return new OfferedEvent(eventName, discountAmount);
    }

    public String getEventName() {
        return eventName;
    }

    public int getDiscountAmount() {
        return discountAmount;
    }
}
