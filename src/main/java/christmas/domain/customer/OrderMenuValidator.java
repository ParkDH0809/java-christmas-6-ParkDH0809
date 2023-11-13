package christmas.domain.customer;

import christmas.constants.ExceptionMessage;
import christmas.constants.InputRule;
import christmas.domain.Menu;
import java.util.regex.PatternSyntaxException;

class OrderMenuValidator {

    void validate(String input) {
        validateDelimiterSeparation(input);
        validateContent(input.split(InputRule.FOOD_NUMBER_SEPARATOR.getString()));
    }

    private void validateDelimiterSeparation(String input) {
        try {
            input.split(InputRule.FOOD_NUMBER_SEPARATOR.getString());
        } catch (PatternSyntaxException e) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_INVALID_MENU.getMessage());
        }
    }

    private void validateContent(String[] detail) {
        validateExistingMenu(detail[0]);
        validateOrderNumber(detail[1]);
    }

    private void validateExistingMenu(String input) {
        if (!Menu.contains(input)) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_INVALID_MENU.getMessage());
        }
    }

    private void validateOrderNumber(String input) {
        validateNumber(input);
        validateRange(input);
    }

    private void validateNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_INVALID_MENU.getMessage());
        }
    }

    private void validateRange(String input) {
        int number = Integer.parseInt(input);
        if (isLessThanMinOrderNumber(number)) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_INVALID_MENU.getMessage());
        }
        if (isMoreThanMaxOrderNumber(number)) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_ORDER_NUMBER.getMessage());
        }
    }

    private boolean isLessThanMinOrderNumber(int number) {
        return number < InputRule.MIN_ORDER_NUMBER.getNumber();
    }

    private boolean isMoreThanMaxOrderNumber(int number) {
        return number > InputRule.MAX_ORDER_NUMBER.getNumber();
    }
}
