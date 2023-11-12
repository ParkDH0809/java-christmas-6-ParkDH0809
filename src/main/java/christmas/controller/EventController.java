package christmas.controller;

import christmas.domain.customer.Customer;
import christmas.domain.event.Event;
import christmas.domain.event.OfferedEvent;
import christmas.view.OutputView;

public class EventController {
    private final OutputView outputView;
    EventController(OutputView outputView) {
        this.outputView = outputView;
    }

    public void provideEvent(Customer customer) {
        Event event = Event.from(customer);
        printPresent(event);
        printBenefit(event);
        printTotalDiscountAmount(event);
        printEstimatedPaymentAmount(event);
    }

    private void printPresent(Event event) {
        outputView.outputPresentEventTitle();
        if(event.givePresent()) {
            outputView.outputOrderMenu(event.giftMenu(), event.giftNumber());
            return;
        }
        outputView.outputNone();
    }

    private void printBenefit(Event event) {
        outputView.outputBenefitTitle();
        for(OfferedEvent offeredEvent : event.getEventBenefit()) {
            outputView.outputBenefit(offeredEvent.getEventName(), offeredEvent.getDiscountAmount());
        }
    }

    private void printTotalDiscountAmount(Event event) {
        outputView.outputTotalBenefitAmountTitle();
        outputView.outputTotalBenefitAmount(event.getTotalDiscountAmount());
    }

    private void printEstimatedPaymentAmount(Event event) {
        outputView.outputEstimatedAmountTitle();
        outputView.outputEstimatedAmount(event.getEstimatedAmount());
    }
}
