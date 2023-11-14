package christmas.domain.event;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CalenderTest {

    @ParameterizedTest
    @DisplayName("날짜 테스트 - 스타 데이가 맞는 경우")
    @ValueSource(strings = {"3", "10", "17", "24", "25", "31"})
    void testIsStarDate(int input) {
        assertThat(Calender.isStarDate(input)).isEqualTo(true);
    }

    @ParameterizedTest
    @DisplayName("날짜 테스트 - 스타 데이가 아닌 경우")
    @ValueSource(strings = {"2", "4", "11", "23", "26", "30"})
    void testIsNotStarDate(int input) {
        assertThat(Calender.isStarDate(input)).isEqualTo(false);
    }

    @ParameterizedTest
    @DisplayName("날짜 테스트 - 평일인 경우")
    @ValueSource(strings = {"4", "12", "25", "28", "14", "7"})
    void testIsWeekdayDate(int input) {
        assertThat(Calender.isWeekendDate(input)).isEqualTo(false);
    }

    @ParameterizedTest
    @DisplayName("날짜 테스트 - 주말인 경우")
    @ValueSource(strings = {"1", "8", "16", "22", "29", "30"})
    void testIsWeekendDate(int input) {
        assertThat(Calender.isWeekendDate(input)).isEqualTo(true);
    }
}
