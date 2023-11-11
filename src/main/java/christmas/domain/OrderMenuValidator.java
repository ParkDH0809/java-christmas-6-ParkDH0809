package christmas.domain;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.PatternSyntaxException;

class OrderMenuValidator {
    private static final String MENU_SEPARATOR = ",";
    private static final String FOOD_NUMBER_SEPARATOR = "-";

    private Set<String> totalOrderMenu;
    private int totalOrderNumber;
    void validate(String input) {
        totalOrderMenu = new HashSet<>();
        totalOrderNumber = 0;
        validateFormat(input);
        validateDetail(input);
    }

    private void validateFormat(String input) {
        validateContainsSpace(input);
        validateDelimiterSeparation(input, MENU_SEPARATOR);
    }

    private void validateContainsSpace(String input) {
        if(input.contains(" ")) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDelimiterSeparation(String input, String separator) {
        try {
            input.split(separator);
        } catch (PatternSyntaxException e) {
            throw new IllegalArgumentException();
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
    }

    private void validateOrderMenu(String input) {
        validateContains(input);
        validateDuplicate(input);
    }

    private void validateContains(String input) {
        if(!Menu.contains(input)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(String input) {
        if (totalOrderMenu.contains(input)) {
            throw new IllegalArgumentException();
        }
        totalOrderMenu.add(input);
    }

    private void validateOrderNumber(String input) {
        try {
            int order = Integer.parseInt(input);
            validateRange(order);
            validateTotalOrderNumber(order);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void validateRange(int input) {
        if (input < 1) {
            throw new IllegalArgumentException();
        }
        if (input > 20) {
            throw new IllegalArgumentException();
        }
    }

    private void validateTotalOrderNumber(int input) {
        totalOrderNumber += input;
        if (totalOrderNumber > 20) {
            throw new IllegalArgumentException();
        }
    }
}
