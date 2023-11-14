package christmas.domain.event;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ChristmasDDayEventTest {

    ChristmasDDayEvent christmasDDayEvent;

    @BeforeEach
    void initChristmasDDayEvent() {
        christmasDDayEvent = new ChristmasDDayEvent();
    }

    @Test
    @DisplayName("크리스마스 디데이 이벤트 테스트 - 적용이 되는 날짜인 경우")
    void testIsWithinPeriod() {
        assertThat(christmasDDayEvent.isWithinPeriod(25)).isTrue();
    }

    @Test
    @DisplayName("크리스마스 디데이 이벤트 테스트 - 적용이 되지 않는 날짜인 경우")
    void testIsNotWithinPeriod() {
        assertThat(christmasDDayEvent.isWithinPeriod(26)).isFalse();
    }

    @Test
    @DisplayName("크리스마스 디데이 이벤트 테스트 - 정보 확인")
    void testDDayEventBenefit() {
        OfferedEvent offeredEvent = OfferedEvent.of("크리스마스 디데이 할인", 3400);
        assertThat(offeredEvent).usingRecursiveComparison().isEqualTo(christmasDDayEvent.getDDayEventBenefit(25));
    }
}
