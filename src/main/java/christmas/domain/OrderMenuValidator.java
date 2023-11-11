package christmas.domain;

import christmas.constants.ExceptionMessage;
import java.util.HashMap;
import java.util.regex.PatternSyntaxException;

class OrderMenuValidator {
    private static final String MENU_SEPARATOR = ",";
    private static final String FOOD_NUMBER_SEPARATOR = "-";
    private static final int MIN_ORDER_NUMBER = 1;
    private static final int MAX_ORDER_NUMBER = 20;
    
    private HashMap<String, Integer> verifiedOrder;

    HashMap<String, Integer> validate(String input) {
        verifiedOrder = new HashMap<>();

        validateFormat(input);
        validateDetail(input);
        validateOnlyDrink();
        validateTotalOrderNumber();

        return verifiedOrder;
    }

    private void validateFormat(String input) {
        validateContainsSpace(input);
        validateDelimiterSeparation(input, MENU_SEPARATOR);
    }

    private void validateContainsSpace(String input) {
        if(input.contains(" ")) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_INVALID_MENU.getMessage());
        }
    }

    private void validateDelimiterSeparation(String input, String separator) {
        try {
            input.split(separator);
        } catch (PatternSyntaxException e) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_INVALID_MENU.getMessage());
        }
    }

    private void validateDetail(String input) {
        for (String detail : input.split(MENU_SEPARATOR)) {
            validateDelimiterSeparation(detail, FOOD_NUMBER_SEPARATOR);
            validateContent(detail.split(FOOD_NUMBER_SEPARATOR));
        }
    }

    private void validateContent(String[] detail) {
        validateOrderMenu(detail[0]);
        validateOrderNumber(detail[1]);
        verifiedOrder.put(detail[0], Integer.parseInt(detail[1]));
    }

    private void validateOrderMenu(String input) {
        validateExistingMenu(input);
        validateDuplicate(input);
    }

    private void validateExistingMenu(String input) {
        if(!Menu.contains(input)) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_INVALID_MENU.getMessage());
        }
    }

    private void validateDuplicate(String input) {
        if (verifiedOrder.containsKey(input)) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_INVALID_MENU.getMessage());
        }
    }

    private void validateOrderNumber(String input) {
        try {
            int order = Integer.parseInt(input);
            validateRange(order);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void validateRange(int input) {
        if (input < MIN_ORDER_NUMBER) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_INVALID_MENU.getMessage());
        }
        if (input > MAX_ORDER_NUMBER) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_ORDER_NUMBER.getMessage());
        }
    }

    private void validateTotalOrderNumber() {
        if(isTotalOrderNumberOverThanMaxOrderNumber()) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_ORDER_NUMBER.getMessage());
        }
    }

    private boolean isTotalOrderNumberOverThanMaxOrderNumber() {
        return verifiedOrder.values().stream().mapToInt(Integer::intValue).sum() > MAX_ORDER_NUMBER;
    }

    private void validateOnlyDrink() {
        if(Menu.isOnlyDrink(verifiedOrder.keySet())) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_ONLY_DRINK.getMessage());
        }
    }
}
