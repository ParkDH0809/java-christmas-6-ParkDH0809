package christmas.domain.event;

import christmas.domain.customer.Customer;
import java.util.ArrayList;
import java.util.List;

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

    public List<OfferedEvent> getEventBenefit() {
        List<OfferedEvent> offeredEvents = new ArrayList<>();
        checkDDayEvent(offeredEvents);
        checkWeekdayAndWeekendEvent(offeredEvents);
        checkSpecialEvent(offeredEvents);
        checkPresentEvent(offeredEvents);
        return offeredEvents;
    }

    private void checkDDayEvent(List<OfferedEvent> offeredEvents) {
        ChristmasDDayEvent christmasDDayEvent = new ChristmasDDayEvent();
        if (christmasDDayEvent.isWithinPeriod(customer.visitDate())) {
            offeredEvents.add(christmasDDayEvent.getDDayEventBenefit(customer.visitDate()));
        }
    }

    private void checkWeekdayAndWeekendEvent(List<OfferedEvent> offeredEvents) {
        if(Calender.isWeekendDate(customer.visitDate())) {
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
        if(givePresent()) {
            offeredEvents.add(new PresentEvent().getPresentEventBenefit());
        }
    }
}
