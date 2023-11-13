package christmas.controller;

import christmas.domain.customer.Customer;
import christmas.domain.event.Event;
import christmas.domain.event.OfferedEvent;
import christmas.view.OutputView;
import java.util.List;

public class EventController {

    private final OutputView outputView;

    EventController(OutputView outputView) {
        this.outputView = outputView;
    }

    public void provideEvent(Customer customer) {
        Event event = Event.from(customer);
        printEvent(event);
    }

    private void printEvent(Event event) {
        printPresent(event);
        printBenefit(event);
        printTotalDiscountAmount(event);
        printEstimatedPaymentAmount(event);
        printEventBadge(event);
    }

    private void printPresent(Event event) {
        outputView.outputPresentEventTitle();
        if (event.isPresentRequirementAmount()) {
            outputView.outputOrderMenu(event.givePresentMenu(), event.givePresentNumber());
            return;
        }
        outputView.outputNone();
    }

    private void printBenefit(Event event) {
        outputView.outputBenefitTitle();
        List<OfferedEvent> offeredEvents = event.getEventBenefit();
        if (offeredEvents.isEmpty()) {
            outputView.outputNone();
        }

        for (OfferedEvent offeredEvent : offeredEvents) {
            outputView.outputBenefit(offeredEvent.getEventName(), offeredEvent.getDiscountAmount());
        }
    }

    private void printTotalDiscountAmount(Event event) {
        outputView.outputTotalBenefitAmount(event.getTotalDiscountAmount());
    }

    private void printEstimatedPaymentAmount(Event event) {
        outputView.outputEstimatedAmount(event.getEstimatedAmount());
    }

    private void printEventBadge(Event event) {
        outputView.outputEventBadge(event.getBadge());
    }
}