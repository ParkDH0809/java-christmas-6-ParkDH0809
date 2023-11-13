package christmas.domain.event;

public class SpecialEvent {

    private static final String SPECIAL_EVENT_NAME = "특별 할인";
    private static final int DISCOUNT_AMOUNT = 1000;

    OfferedEvent getSpecialEventBenefit() {
        return OfferedEvent.of(SPECIAL_EVENT_NAME, DISCOUNT_AMOUNT);
    }
}