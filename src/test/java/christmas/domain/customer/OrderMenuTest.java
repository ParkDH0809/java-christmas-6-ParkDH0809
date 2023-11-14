package christmas.domain.customer;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.Menu;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrderMenuTest {

    static OrderMenu orderMenu;

    @BeforeAll
    static void initOrderMenu() {
        orderMenu = OrderMenu.from("크리스마스파스타-3");
    }

    @Test
    @DisplayName("메뉴 - 카테고리 반환 테스트")
    void testGetMenuCategory() {
        assertThat(orderMenu.getMenuCategory()).isEqualTo(Menu.MAIN);
    }

    @Test
    @DisplayName("메뉴 - 메뉴 가격 반환 테스트")
    void testGetMenuAmount() {
        assertThat(orderMenu.getMenuAmount()).isEqualTo(75000);
    }

    @Test
    @DisplayName("메뉴 - 이름 반환 테스트")
    void testGetMenuName() {
        assertThat(orderMenu.getMenuName()).isEqualTo("크리스마스파스타");
    }

    @Test
    @DisplayName("메뉴 - 개수 반환 테스트")
    void testGetMenuNumber() {
        assertThat(orderMenu.getOrderNumber()).isEqualTo(3);
    }
}
