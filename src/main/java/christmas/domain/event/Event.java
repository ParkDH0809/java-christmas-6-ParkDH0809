package christmas.domain.event;

import christmas.domain.customer.Customer;

public class Event {
    Customer customer;
    private Event(Customer customer) {
        this.customer = customer;
    }

    public static Event from(Customer customer) {
        return new Event(customer);
    }

    public boolean givePresent() {
        return new PresentEvent().givePresent(customer.getAmountBeforeDiscount());
    }

    public String giftMenu() {
        return new PresentEvent().giftMenu();
    }

    public int giftNumber() {
        return new PresentEvent().giftNumber();
    }
}
