package christmas.domain.event;

import christmas.domain.customer.Customer;
import java.util.ArrayList;
import java.util.List;

public class Event {
    Customer customer;
    List<OfferedEvent> offeredEvents;
    private Event(Customer customer) {
        this.customer = customer;
        offeredEvents = new ArrayList<>();
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
        checkDDayEvent();
        checkWeekdayAndWeekendEvent();
        checkSpecialEvent();
        checkPresentEvent();
        return offeredEvents;
    }

    private void checkDDayEvent() {
        ChristmasDDayEvent christmasDDayEvent = new ChristmasDDayEvent();
        if (christmasDDayEvent.isWithinPeriod(customer.visitDate())) {
            offeredEvents.add(christmasDDayEvent.getDDayEventBenefit(customer.visitDate()));
        }
    }

    private void checkWeekdayAndWeekendEvent() {
        if(Calender.isWeekendDate(customer.visitDate())) {
            getWeekendEvent();
            return;
        }
        getWeekdayEvent();
    }

    private void getWeekendEvent() {
        WeekendEvent weekendEvent = WeekendEvent.from(customer.getNumberOfMainMenu());
        offeredEvents.add(weekendEvent.getWeekendEventBenefit());
    }

    private void getWeekdayEvent() {
        WeekdayEvent weekdayEvent = WeekdayEvent.from(customer.getNumberOfDesertMenu());
        offeredEvents.add(weekdayEvent.getWeekdayEventBenefit());
    }

    private void checkSpecialEvent() {
        if (Calender.isStarDate(customer.visitDate())) {
            offeredEvents.add(new SpecialEvent().getSpecialEventBenefit());
        }
    }

    private void checkPresentEvent() {
        if(givePresent()) {
            offeredEvents.add(new PresentEvent().getPresentEventBenefit());
        }
    }

    public int getTotalDiscountAmount() {
        int totalDiscountAmount = 0;
        for (OfferedEvent offeredEvent : offeredEvents) {
            totalDiscountAmount += offeredEvent.getDiscountAmount();
        }
        return totalDiscountAmount;
    }
}
