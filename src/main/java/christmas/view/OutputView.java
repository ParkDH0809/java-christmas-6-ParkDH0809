package christmas.view;

public class OutputView {
    private static final String OUTPUT_EVENT_PREVIEW_PHRASE = "12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n";
    private static final String OUTPUT_ORDER_MENU_TITLE = "\n<주문 메뉴>";
    private static final String OUTPUT_ORDER_MENU = "%s %d개\n";
    private static final String OUTPUT_BEFORE_DISCOUNT = "\n<할인 전 총주문 금액>\n%,d원\n";

    public void outputEventPreviewPhrase(int number) {
        System.out.printf(OUTPUT_EVENT_PREVIEW_PHRASE, number);
    }

    public void outputOrderMenuTitle() {
        System.out.println(OUTPUT_ORDER_MENU_TITLE);
    }

    public void outputOrderMenu(String string, int number) {
        System.out.printf(OUTPUT_ORDER_MENU, string, number);
    }

    public void outputBeforeDiscount(int number) {
        System.out.printf(OUTPUT_BEFORE_DISCOUNT, number);
    }
}
