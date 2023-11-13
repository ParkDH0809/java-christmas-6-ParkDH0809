package christmas.domain.customer;

import christmas.constants.ExceptionMessage;

public class VisitDate {

    private static final int EVENT_MIN_DATE = 1;
    private static final int EVENT_MAX_DATE = 31;
    private final int visitDate;

    private VisitDate(String input) {
        validate(input);
        this.visitDate = stringToInt(input);
    }

    public static VisitDate from(String input) {
        return new VisitDate(input);
    }

    private void validate(String input) {
        validateNumber(input);
        validateRange(input);
    }

    private void validateNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_INVALID_DATE.getMessage());
        }
    }

    private void validateRange(String input) {
        int date = Integer.parseInt(input);
        if (date < EVENT_MIN_DATE) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_INVALID_DATE.getMessage());
        }
        if (date > EVENT_MAX_DATE) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_INVALID_DATE.getMessage());
        }
    }

    private int stringToInt(String input) {
        return Integer.parseInt(input);
    }

    int visitDate() {
        return visitDate;
    }
}
