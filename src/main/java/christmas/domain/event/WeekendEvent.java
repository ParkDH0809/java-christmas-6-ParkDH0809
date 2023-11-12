package christmas.domain.event;

public class WeekendEvent {
    private final int numberOfMainMenu;
    private WeekendEvent(int numberOfMainMenu) {
        this.numberOfMainMenu = numberOfMainMenu;
    }

    public static WeekendEvent from(int numberOfMainMenu) {
        return new WeekendEvent(numberOfMainMenu);
    }

    OfferedEvent getWeekendEventBenefit() {
        return OfferedEvent.of("주말 할인", numberOfMainMenu * 2023);
    }
}
