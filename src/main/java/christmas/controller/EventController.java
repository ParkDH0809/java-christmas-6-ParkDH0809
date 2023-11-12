package christmas.controller;

import christmas.domain.customer.Customer;
import christmas.domain.event.Event;
import christmas.view.OutputView;

public class EventController {
    private final OutputView outputView;
    EventController(OutputView outputView) {
        this.outputView = outputView;
    }

    public void provideEvent(Customer customer) {
        Event event = Event.from(customer);
        printPresent(event);
    }

    private void printPresent(Event event) {
        outputView.outputPresentEventTitle();
        if(event.givePresent()) {
            outputView.outputOrderMenu(event.giftMenu(), event.giftNumber());
            return;
        }
        outputView.outputNone();
    }
}
