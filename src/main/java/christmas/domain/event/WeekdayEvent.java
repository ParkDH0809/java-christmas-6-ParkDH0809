package christmas.domain.event;

public class WeekdayEvent {

    private static final String WEEKDAY_EVENT_NAME = "평일 할인";
    private static final int DISCOUNT_AMOUNT = 2023;

    private final int numberOfDesertMenu;

    private WeekdayEvent(int numberOfDesertMenu) {
        this.numberOfDesertMenu = numberOfDesertMenu;
    }

    public static WeekdayEvent from(int numberOfDesertMenu) {
        return new WeekdayEvent(numberOfDesertMenu);
    }

    OfferedEvent getWeekdayEventBenefit() {
        return OfferedEvent.of(WEEKDAY_EVENT_NAME, numberOfDesertMenu * DISCOUNT_AMOUNT);
    }
}
