package christmas.domain.event;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BadgeTest {

    @ParameterizedTest
    @DisplayName("배지 - 할인 가격에 따른 배지 반환 테스트")
    @CsvSource(value = {
            "-30000:산타", "-20000:산타",
            "-19999:트리", "-10000:트리",
            "-9999:별", "-5000:별",
            "-4999:없음", "0:없음"}, delimiter = ':')
    void testGetBadge(int value, String result) {
        assertThat(Badge.getBadge(value)).isEqualTo(result);
    }
}
