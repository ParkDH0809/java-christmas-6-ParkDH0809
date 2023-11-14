package christmas.domain.event;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WeekdayEventTest {

    @Test
    @DisplayName("평일 할인 테스트 - 정보 확인")
    void testPresentEventBenefit() {
        WeekdayEvent weekdayEvent = WeekdayEvent.from(3);
        OfferedEvent offeredEvent = OfferedEvent.of("평일 할인", 2023 * 3);
        assertThat(offeredEvent).usingRecursiveComparison().isEqualTo(weekdayEvent.getWeekdayEventBenefit());
    }
}
