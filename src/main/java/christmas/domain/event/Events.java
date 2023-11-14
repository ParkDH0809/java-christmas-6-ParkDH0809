package christmas.domain.event;

import christmas.domain.Menu;
import christmas.domain.customer.Customer;
import java.util.List;

public class Events {

    private final Customer customer;
    private final List<OfferedEvent> offeredEvents;

    private Events(Customer customer) {
        this.customer = customer;
        EventChecker eventResultGenerator = EventChecker.from(customer);
        this.offeredEvents = eventResultGenerator.generateEventResult();
    }

    public static Events from(Customer customer) {
        return new Events(customer);
    }

    public List<OfferedEvent> getEventBenefit() {
        return offeredEvents;
    }

    public int getTotalDiscountAmount() {
        return -offeredEvents.stream().mapToInt(OfferedEvent::getDiscountAmount).sum();
    }

    public int getEstimatedAmount() {
        PresentEvent presentEvent = new PresentEvent();
        if (presentEvent.isPresentRequirementAmount(customer.getAmountBeforeDiscount())) {
            return customer.getAmountBeforeDiscount() + getTotalDiscountAmount()
                    + Menu.getMenuAmount(presentEvent.getPresentMenu());
        }
        return customer.getAmountBeforeDiscount() + getTotalDiscountAmount();
    }

    public String getBadge() {
        return Badge.getBadge(getTotalDiscountAmount());
    }
}
