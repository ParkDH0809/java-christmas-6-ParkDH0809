package christmas.domain.customer;

import christmas.constants.InputRule;
import java.util.ArrayList;
import java.util.List;

public class OrderMenus {
     private final List<OrderMenu> orderMenus;
    private OrderMenus(String input) {
        OrderMenusValidator orderMenusValidator = new OrderMenusValidator();
        orderMenusValidator.validate(input);
        orderMenus = initOrderMenus(input);
        orderMenusValidator.validateOther(orderMenus);
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
}
