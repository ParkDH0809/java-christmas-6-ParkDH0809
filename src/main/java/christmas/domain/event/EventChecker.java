package christmas.domain.event;

import christmas.domain.customer.Customer;
import java.util.ArrayList;
import java.util.List;

public class EventChecker {

    private final Customer customer;

    private EventChecker(Customer customer) {
        this.customer = customer;
    }

    public static EventChecker from(Customer customer) {
        return new EventChecker(customer);
    }

    List<OfferedEvent> generateEventResult() {
        List<OfferedEvent> offeredEvents = new ArrayList<>();
        checkEvent(offeredEvents);
        return offeredEvents;
    }

    private void checkEvent(List<OfferedEvent> offeredEvents) {
        checkDDayEvent(offeredEvents);
        checkWeekdayAndWeekendEvent(offeredEvents);
        checkSpecialEvent(offeredEvents);
        checkPresentEvent(offeredEvents);
    }

    private void checkDDayEvent(List<OfferedEvent> offeredEvents) {
        ChristmasDDayEvent christmasDDayEvent = new ChristmasDDayEvent();
        if (christmasDDayEvent.isWithinPeriod(customer.visitDate())) {
            offeredEvents.add(christmasDDayEvent.getDDayEventBenefit(customer.visitDate()));
        }
    }

    private void checkWeekdayAndWeekendEvent(List<OfferedEvent> offeredEvents) {
        if (Calender.isWeekendDate(customer.visitDate())) {
            getWeekendEvent(offeredEvents);
            return;
        }
        getWeekdayEvent(offeredEvents);
    }

    private void getWeekendEvent(List<OfferedEvent> offeredEvents) {
        WeekendEvent weekendEvent = WeekendEvent.from(customer.getNumberOfMainMenu());
        offeredEvents.add(weekendEvent.getWeekendEventBenefit());
    }

    private void getWeekdayEvent(List<OfferedEvent> offeredEvents) {
        WeekdayEvent weekdayEvent = WeekdayEvent.from(customer.getNumberOfDesertMenu());
        offeredEvents.add(weekdayEvent.getWeekdayEventBenefit());
    }

    private void checkSpecialEvent(List<OfferedEvent> offeredEvents) {
        if (Calender.isStarDate(customer.visitDate())) {
            offeredEvents.add(new SpecialEvent().getSpecialEventBenefit());
        }
    }

    private void checkPresentEvent(List<OfferedEvent> offeredEvents) {
        PresentEvent presentEvent = new PresentEvent();
        if (presentEvent.isPresentRequirementAmount(customer.getAmountBeforeDiscount())) {
            offeredEvents.add(presentEvent.getPresentEventBenefit());
        }
    }
}
