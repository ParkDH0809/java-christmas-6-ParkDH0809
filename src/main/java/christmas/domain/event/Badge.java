package christmas.domain.event;

public enum Badge {
    SANTA(-20000, "산타"),
    TREE(-10000, "트리"),
    STAR(-5000, "별"),
    NONE(0, "없음");

    private final int amount;
    private final String name;

    Badge(int amount, String name) {
        this.amount = amount;
        this.name = name;
    }

    static String getBadge(int discountAmount) {
        if (discountAmount <= SANTA.amount) {
            return SANTA.name;
        }
        if (discountAmount <= TREE.amount) {
            return TREE.name;
        }
        if (discountAmount <= STAR.amount) {
            return STAR.name;
        }
        return NONE.name;
    }
}
