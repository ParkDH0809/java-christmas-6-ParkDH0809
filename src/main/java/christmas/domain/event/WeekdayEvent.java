package christmas.domain.event;

public class WeekdayEvent {
    private final int numberOfDesertMenu;
    private WeekdayEvent(int numberOfDesertMenu) {
        this.numberOfDesertMenu = numberOfDesertMenu;
    }

    public static WeekdayEvent from(int numberOfDesertMenu) {
        return new WeekdayEvent(numberOfDesertMenu);
    }

    OfferedEvent getWeekdayEventBenefit() {
        return OfferedEvent.of("평일 할인", numberOfDesertMenu * 2023);
    }
}
