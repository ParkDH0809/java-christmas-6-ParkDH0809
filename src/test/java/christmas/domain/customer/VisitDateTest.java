package christmas.domain.customer;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class VisitDateTest {

    @ParameterizedTest
    @DisplayName("방문 날짜 입력 테스트 - 입력이 올바르지 않은 경우")
    @ValueSource(strings = {"", " ", "a", "0", "32", "1a", "2일"})
    void testVisitDateInputException(String input) {
        assertThatThrownBy(() -> VisitDate.from(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("방문 날짜 입력 테스트 - 입력이 올바른 경우")
    @ValueSource(strings = {"1", "11", "20", "31"})
    void testVisitDateInput(String input) {
        assertThatCode(() -> VisitDate.from(input))
                .doesNotThrowAnyException();
    }
}
