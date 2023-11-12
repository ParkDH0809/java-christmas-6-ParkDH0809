package christmas.domain.event;

public class SpecialEvent {

    OfferedEvent getSpecialEventBenefit() {
        return OfferedEvent.of("특별 할인", 1000);
    }
}
