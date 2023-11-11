package christmas.domain.customer;

import java.util.HashMap;

public class OrderMenu {
    private final HashMap<String, Integer> orderContents;
    private OrderMenu(String input) {
        orderContents = new OrderMenuValidator().validate(input);
    }

    public static OrderMenu from(String input) {
        return new OrderMenu(input);
    }
}
