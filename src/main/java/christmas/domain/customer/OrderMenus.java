package christmas.domain.customer;

import christmas.constants.InputRule;
import christmas.domain.Menu;
import java.util.ArrayList;
import java.util.List;

public class OrderMenus {

    private final List<OrderMenu> orderMenus;

    private OrderMenus(String input) {
        OrderMenusValidator orderMenusValidator = new OrderMenusValidator();
        orderMenusValidator.validate(input);

        orderMenus = initOrderMenus(input);
        orderMenusValidator.validateContents(orderMenus);
    }

    private List<OrderMenu> initOrderMenus(String input) {
        List<OrderMenu> orderMenus = new ArrayList<>();
        for (String detail : input.split(InputRule.MENU_SEPARATOR.getString())) {
            orderMenus.add(OrderMenu.from(detail));
        }
        return orderMenus;
    }

    public static OrderMenus from(String input) {
        return new OrderMenus(input);
    }

    public List<OrderMenu> getOrderMenus() {
        return orderMenus;
    }

    int getAmountBeforeDiscount() {
        return orderMenus.stream().mapToInt(OrderMenu::getMenuAmount).sum();
    }

    int getNumberOfCategory(Menu menu) {
        return orderMenus.stream()
                .filter(order -> order.getMenuCategory().equals(menu))
                .mapToInt(OrderMenu::getOrderNumber)
                .sum();
    }
}
