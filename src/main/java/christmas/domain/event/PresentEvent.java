package christmas.domain.event;

import christmas.domain.Menu;

class PresentEvent {

    private static final String PRESENT_EVENT_NAME = "증정 이벤트";
    private static final String PRESENT_MENU = "샴페인";
    private static final int PRESENT_NUMBER = 1;
    private static final int PRESENT_REQUIREMENT_AMOUNT = 120000;


    boolean givePresent(int amount) {
        return amount >= PRESENT_REQUIREMENT_AMOUNT;
    }

    String giftMenu() {
        return PRESENT_MENU;
    }

    int giftNumber() {
        return PRESENT_NUMBER;
    }

    OfferedEvent getPresentEventBenefit() {
        return OfferedEvent.of(PRESENT_EVENT_NAME, Menu.getMenuAmount(PRESENT_MENU));
    }
}
