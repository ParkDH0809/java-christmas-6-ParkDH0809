package christmas.domain.event;

public class ChristmasDDayEvent {

    private static final String CHRISTMAS_D_DAY_EVENT_NAME = "크리스마스 디데이 할인";
    private static final int D_DAY = 25;
    private static final int BASIC_DISCOUNT_AMOUNT = 1000;
    private static final int ADDITIONAL_DISCOUNT_AMOUNT = 100;


    OfferedEvent getDDayEventBenefit(int visitDate) {
        return OfferedEvent.of(CHRISTMAS_D_DAY_EVENT_NAME, getDiscountAmount(visitDate));
    }

    private int getDiscountAmount(int visitDate) {
        return BASIC_DISCOUNT_AMOUNT + (ADDITIONAL_DISCOUNT_AMOUNT * (visitDate - 1));
    }

    boolean isWithinPeriod(int visitDate) {
        return visitDate <= D_DAY;
    }
}
