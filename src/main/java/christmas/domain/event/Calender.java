package christmas.domain.event;

import java.util.List;

public enum Calender {
    STAR_DATE(List.of(3, 10, 17, 24, 25, 31)),
    WEEKEND_DATE(List.of(1, 2, 8, 9, 15, 16, 22, 23, 29, 30));

    private final List<Integer> eventDates;

    Calender(List<Integer> eventDates) {
        this.eventDates = eventDates;
    }

    static boolean isStarDate(int date) {
        return STAR_DATE.eventDates.stream().anyMatch(event -> event.equals(date));
    }

    static boolean isWeekendDate(int date) {
        return WEEKEND_DATE.eventDates.stream().anyMatch(event -> event.equals(date));
    }
}
