package christmas.domain;

public class OrderMenu {
    private OrderMenu(String input) {
        new OrderMenuValidator().validate(input);
    }

    public static OrderMenu from(String input) {
        return new OrderMenu(input);
    }
}
