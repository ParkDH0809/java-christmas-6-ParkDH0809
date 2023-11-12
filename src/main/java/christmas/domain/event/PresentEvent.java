package christmas.domain.event;

class PresentEvent {
    private static final int GIFT_AMOUNT = 120000;
    private final String GIFT_MENU = "샴페인";
    private final int GIFT_NUMBER = 1;

    boolean givePresent(int amount) {
        return amount >= GIFT_AMOUNT;
    }

    String giftMenu() {
        return GIFT_MENU;
    }

    int giftNumber() {
        return GIFT_NUMBER;
    }
}
