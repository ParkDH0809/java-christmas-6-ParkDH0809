package christmas.domain.event;

public class WeekendEvent {

    private static final String WEEKEND_EVENT_NAME = "주말 할인";
    private static final int DISCOUNT_AMOUNT = 2023;

    private final int numberOfMainMenu;

    private WeekendEvent(int numberOfMainMenu) {
        this.numberOfMainMenu = numberOfMainMenu;
    }

    public static WeekendEvent from(int numberOfMainMenu) {
        return new WeekendEvent(numberOfMainMenu);
    }

    OfferedEvent getWeekendEventBenefit() {
        return OfferedEvent.of(WEEKEND_EVENT_NAME, numberOfMainMenu * DISCOUNT_AMOUNT);
    }
}
