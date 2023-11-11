package christmas.domain;

import java.util.HashMap;

public class OrderMenu {
    private HashMap<String, Integer> orderContents;
    private OrderMenu(String input) {
        orderContents = new OrderMenuValidator().validate(input);
    }

    public static OrderMenu from(String input) {
        return new OrderMenu(input);
    }
}
