package christmas.domain.event;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PresentEventTest {

    PresentEvent presentEvent;

    @BeforeEach
    void initPresentEvent() {
        presentEvent = new PresentEvent();
    }

    @Test
    @DisplayName("증정 이벤트 테스트 - 이벤트 적용 대상이 아닌 경우")
    void testIsNotPresentRequirementAmount() {
        assertThat(presentEvent.isPresentRequirementAmount(119999)).isFalse();
    }

    @Test
    @DisplayName("증정 이벤트 테스트 - 이벤트 적용 대상이 맞는 경우")
    void testIsPresentRequirementAmount() {
        assertThat(presentEvent.isPresentRequirementAmount(120000)).isTrue();
    }

    @Test
    @DisplayName("증정 이벤트 테스트 - 정보 확인")
    void testPresentEventBenefit() {
        OfferedEvent offeredEvent = OfferedEvent.of("증정 이벤트", 25000);
        assertThat(offeredEvent).usingRecursiveComparison()
                .isEqualTo(presentEvent.getPresentEventBenefit());
    }
}
