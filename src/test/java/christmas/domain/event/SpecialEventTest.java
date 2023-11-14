package christmas.domain.event;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SpecialEventTest {

    @Test
    @DisplayName("증정 이벤트 테스트 - 정보 확인")
    void testSpecialEventBenefit() {
        OfferedEvent offeredEvent = OfferedEvent.of("특별 할인", 1000);
        assertThat(offeredEvent).usingRecursiveComparison().isEqualTo(new SpecialEvent().getSpecialEventBenefit());
    }
}
