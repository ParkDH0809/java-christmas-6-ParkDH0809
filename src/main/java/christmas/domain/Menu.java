package christmas.domain;

import java.util.Arrays;
import java.util.Map;

public enum Menu {
    APPETIZER(Map.of(
            "양송이수프", 6000,
            "타파스", 5500,
            "시저샐러드", 8000)),
    MAIN(Map.of(
            "티본스테이크", 55000,
            "바비큐립", 54000,
            "해산물파스타", 35000,
            "크리스마스파스타", 25000)),
    DESSERT(Map.of(
            "초코케이크", 15000,
            "아이스크림", 5000)),
    DRINK(Map.of(
            "제로콜라", 3000,
            "레드와인", 60000,
            "샴페인", 25000));

    private final Map<String, Integer> menu;

    Menu(Map<String, Integer> menu) {
        this.menu = menu;
    }

    public static boolean contains(String menuName) {
        return Arrays.stream(Menu.values())
                .anyMatch(menu -> menu.menu.containsKey(menuName));
    }

    public static Menu getMenuCategory(String menuName) {
        return Arrays.stream(Menu.values())
                .filter(menu -> menu.menu.containsKey(menuName))
                .findFirst()
                .orElse(null);
    }

    public static int getMenuAmount(String menuName) {
        return getMenuCategory(menuName).menu.get(menuName);
    }
}
