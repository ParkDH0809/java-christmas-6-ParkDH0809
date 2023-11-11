package christmas.domain.customer;

import christmas.constants.ExceptionMessage;
import christmas.constants.InputRule;
import christmas.domain.Menu;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.PatternSyntaxException;

public class OrderMenusValidator {
    void validate(String input) {
        validateContainsSpace(input);
        validateDelimiterSeparation(input);
    }

    private void validateContainsSpace(String input) {
        if(input.contains(" ")) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_INVALID_MENU.getMessage());
        }
    }

    private void validateDelimiterSeparation(String input) {
        try {
            input.split(InputRule.MENU_SEPARATOR.getString());
        } catch (PatternSyntaxException e) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_INVALID_MENU.getMessage());
        }
    }

    void validateOther(List<OrderMenu> orderMenus) {
        validateOnlyDrink(orderMenus);
        validateDuplicate(orderMenus);
        validateTotalOrderNumber(orderMenus);
    }

    private void validateOnlyDrink(List<OrderMenu> orderMenus) {
        for (OrderMenu orderMenu : orderMenus) {
            if(!isDrink(orderMenu)) {
                return;
            }
        }
        throw new IllegalArgumentException(ExceptionMessage.ERROR_ONLY_DRINK.getMessage());
    }

    private boolean isDrink(OrderMenu orderMenu) {
        return orderMenu.getMenuCategory() == Menu.DRINK;
    }

    private void validateDuplicate(List<OrderMenu> orderMenus) {
        Set<String> set = new HashSet<>();
        for (OrderMenu orderMenu : orderMenus) {
            set.add(orderMenu.getMenuName());
        }
        if(set.size() != orderMenus.size()) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_INVALID_MENU.getMessage());
        }
    }

    private void validateTotalOrderNumber(List<OrderMenu> orderMenus) {
        int sum = 0;
        for (OrderMenu orderMenu : orderMenus) {
            sum += orderMenu.getOrderNumber();
        }
        if(sum > InputRule.MAX_ORDER_NUMBER.getNumber()) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_ORDER_NUMBER.getMessage());
        }
    }
}
