package christmas.constants;

public enum InputRule {
    MENU_SEPARATOR(","),
    FOOD_NUMBER_SEPARATOR("-"),
    MIN_ORDER_NUMBER("1"),
    MAX_ORDER_NUMBER("20");
    private final String string;

    InputRule(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }

    public int getNumber() {
        return Integer.parseInt(string);
    }



}
