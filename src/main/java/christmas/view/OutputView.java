package christmas.view;

public class OutputView {
    private static final String OUTPUT_EVENT_PREVIEW_PHRASE = "12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n\n";

    public void outputEventPreviewPhrase(int number) {
        System.out.printf(OUTPUT_EVENT_PREVIEW_PHRASE, number);
    }
}
