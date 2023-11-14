package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MenuTest {
    @ParameterizedTest
    @DisplayName("메뉴 테스트 - 존재하는 메뉴인지 확인")
    @CsvSource(value = {
            "티본스테이크:true", "화이트와인:false",
            "제로콜라: true", "딸기케이크: false"}, delimiter = ':')
    void testMenuContains(String input, boolean result) {
        assertThat(Menu.contains(input)).isEqualTo(result);
    }

    @ParameterizedTest
    @DisplayName("메뉴 테스트 - 카테고리 반환 확인")
    @CsvSource(value = {
            "타파스:APPETIZER", "양송이수프:APPETIZER",
            "크리스마스파스타:MAIN", "바비큐립:MAIN",
            "초코케이크:DESSERT", "아이스크림:DESSERT",
            "제로콜라:DRINK", "샴페인:DRINK" }, delimiter = ':')
    void testMenuCategory(String input, Menu result) {
        assertThat(Menu.getMenuCategory(input)).isEqualTo(result);
    }

    @ParameterizedTest
    @DisplayName("메뉴 테스트 - 메뉴 가격 반환 확인")
    @CsvSource(value = {
            "양송이수프:6000", "해산물파스타:35000",
            "아이스크림:5000", "레드와인:60000"}, delimiter = ':')
    void testMenuAmount(String input, int result) {
        assertThat(Menu.getMenuAmount(input)).isEqualTo(result);
    }
}
