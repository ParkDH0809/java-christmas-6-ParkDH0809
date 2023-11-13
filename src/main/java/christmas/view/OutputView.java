package christmas.view;

public class OutputView {
    private static final String OUTPUT_EVENT_PREVIEW_PHRASE = "12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n";
    private static final String OUTPUT_ORDER_MENU_TITLE = "\n<주문 메뉴>";
    private static final String OUTPUT_ORDER_MENU = "%s %d개\n";
    private static final String OUTPUT_BEFORE_DISCOUNT = "\n<할인 전 총주문 금액>\n%,d원\n";
    private static final String OUTPUT_PRESENT_EVENT_TITLE = "\n<증정 메뉴>";
    private static final String OUTPUT_NONE = "없음";
    private static final String OUTPUT_BENEFIT_TITLE = "\n<혜택 내역>";
    private static final String OUTPUT_BENEFIT = "%s: -%,d원\n";
    private static final String OUTPUT_TOTAL_BENEFIT_AMOUNT = "\n<총혜택 금액>\n-%,d원\n";
    private static final String OUTPUT_ESTIMATED_AMOUNT = "\n<할인 후 예상 결제 금액>\n%,d원\n";
    private static final String OUTPUT_EVENT_BADGE = "\n<12월 이벤트 배지>\n%s\n";

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

    public void outputPresentEventTitle() {
        System.out.println(OUTPUT_PRESENT_EVENT_TITLE);
    }

    public void outputNone() {
        System.out.println(OUTPUT_NONE);
    }

    public void outputBenefitTitle() {
        System.out.println(OUTPUT_BENEFIT_TITLE);
    }

    public void outputBenefit(String string, int number) {
        System.out.printf(OUTPUT_BENEFIT, string, number);
    }

    public void outputTotalBenefitAmount(int number) {
        System.out.printf(OUTPUT_TOTAL_BENEFIT_AMOUNT, number);
    }

    public void outputEstimatedAmount(int number) {
        System.out.printf(OUTPUT_ESTIMATED_AMOUNT, number);
    }

    public void outputEventBadge(String string) {
        System.out.printf(OUTPUT_EVENT_BADGE, string);
    }
}
