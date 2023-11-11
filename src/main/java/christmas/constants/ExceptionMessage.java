package christmas.constants;

public enum ExceptionMessage {
    ERROR_INVALID_DATE("유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    ERROR_INVALID_MENU("유효하지 않은 주문입니다. 다시 입력해 주세요."),
    ERROR_ONLY_DRINK("음료만 주문할 수 없습니다. 다시 입력해 주세요."),
    ERROR_ORDER_NUMBER("메뉴는 20개를 초과해 주문할 수 없습니다. 다시 입력해 주세요.");

    private static final String PREFIX = "[ERROR] ";

    private final String errorMessage;

    ExceptionMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getMessage() {
        return PREFIX + errorMessage;
    }
}
