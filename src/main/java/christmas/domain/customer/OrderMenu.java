package christmas.domain.customer;

import christmas.constants.InputRule;
import christmas.domain.Menu;

public class OrderMenu {

    private final String menuName;
    private final int orderNumber;

    private OrderMenu(String input) {
        new OrderMenuValidator().validate(input);
        String[] result = splitInput(input);
        this.menuName = result[0];
        this.orderNumber = Integer.parseInt(result[1]);
    }

    private String[] splitInput(String input) {
        return input.split(InputRule.FOOD_NUMBER_SEPARATOR.getString());
    }

    public static OrderMenu from(String input) {
        return new OrderMenu(input);
    }

    public String getMenuName() {
        return menuName;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public Menu getMenuCategory() {
        return Menu.getMenuCategory(menuName);
    }

    public int getMenuAmount() {
        return Menu.getMenuAmount(menuName) * orderNumber;
    }
}
