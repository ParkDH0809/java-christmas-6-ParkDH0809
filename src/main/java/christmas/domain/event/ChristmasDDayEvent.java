package christmas.domain.event;

public class ChristmasDDayEvent {
    private static final int D_DAY = 25;
    OfferedEvent getDDayEventBenefit(int visitDate) {
        return OfferedEvent.of("크리스마스 디데이 할인", 1000 + ((visitDate - 1) * 100));
    }

    boolean isWithinPeriod(int visitDate) {
        return visitDate <= D_DAY;
    }
}
