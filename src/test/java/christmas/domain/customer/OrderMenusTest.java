package christmas.domain.customer;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class OrderMenusTest {

    @ParameterizedTest
    @DisplayName("메뉴 입력 테스트 - 입력 포맷이 잘못된 경우")
    @ValueSource(strings = {
            "제로콜라-2.타파스-1",
            "티본스테이크-4, 샴페인-3, 시저샐러드-2",
            " ,바비큐립-3,아이스크림-2",
            "크리스마스파스타, 해산물파스타-1"})
    void testOrderMenusFormatException(String input) {
        assertThatThrownBy(() -> OrderMenus.from(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("메뉴 입력 테스트 - 음료만 입력한 경우")
    @ValueSource(strings = {
            "제로콜라-2,레드와인-1",
            "샴페인-3",
            "제로콜라-1"})
    void testOrderMenusOnlyDrinkException(String input) {
        assertThatThrownBy(() -> OrderMenus.from(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("메뉴 입력 테스트 - 중복 메뉴를 입력한 경우")
    @ValueSource(strings = {
            "초코케이크-1,초코케이크-2",
            "티본스테이크-2,제로콜라-2,아이스크림-3,제로콜라-1",
            "샴페인-2,타파스-1,시저샐러드-1,바비큐립-2,타파스-2"})
    void testOrderMenusDuplicateException(String input) {
        assertThatThrownBy(() -> OrderMenus.from(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("메뉴 입력 테스트 - 20개 초과 주문을 한 경우")
    @ValueSource(strings = {
            "초코케이크-8,제로콜라-8,타파스-8",
            "해산물파스타-6,크리스마스파스타-12,아이스크림-4",
            "초코케이크-20,아이스크림-1"})
    void testOrderMenusOverNumberException(String input) {
        assertThatThrownBy(() -> OrderMenus.from(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("메뉴 입력 테스트 - 정상 입력을 한 경우")
    @ValueSource(strings = {
            "타파스-1,제로콜라-1",
            "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1"
    })
    void testOrderMenusInput(String input) {
        assertThatCode(() -> OrderMenus.from(input))
                .doesNotThrowAnyException();
    }
}
