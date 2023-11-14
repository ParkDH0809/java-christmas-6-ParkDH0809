package christmas.domain.customer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.domain.Menu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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

    @ParameterizedTest
    @DisplayName("주문 가격 테스트 - 할인 전 금액 계산 확인")
    @CsvSource(value = {
            "양송이수프-2,티본스테이크-2,아이스크림-2,레드와인-1:192000",
            "타파스-2,제로콜라-3:20000",
            "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1:142000",}, delimiter = ':')
    void testOrderMenusTotalAmountBeforeDiscount(String input, int value) {
        OrderMenus orderMenus = OrderMenus.from(input);
        assertThat(orderMenus.getAmountBeforeDiscount()).isEqualTo(value);
    }

    @Test
    @DisplayName("동일 카테고리 메뉴 개수 반환")
    void testOrderMenusNumberOfCategory() {
        String input = "티본스테이크-3,바비큐립-1,초코케이크-2,제로콜라-1,양송이수프-2,레드와인-2";
        OrderMenus orderMenus = OrderMenus.from(input);

        assertThat((orderMenus.getNumberOfCategory(Menu.APPETIZER))).isEqualTo(2);
        assertThat((orderMenus.getNumberOfCategory(Menu.MAIN))).isEqualTo(4);
        assertThat((orderMenus.getNumberOfCategory(Menu.DESSERT))).isEqualTo(2);
        assertThat((orderMenus.getNumberOfCategory(Menu.DRINK))).isEqualTo(3);
    }
}
