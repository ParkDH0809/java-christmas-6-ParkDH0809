package christmas.domain.customer;

import java.util.List;

public class Customer {
    private final VisitDate visitDate;
    private final OrderMenus orderMenus;

    private Customer(VisitDate visitDate, OrderMenus orderMenus) {
        this.visitDate = visitDate;
        this.orderMenus = orderMenus;
    }

    public static Customer of(VisitDate visitDate, OrderMenus orderMenus) {
        return new Customer(visitDate, orderMenus);
    }

    public int visitDate() {
        return visitDate.visitDate();
    }

    public List<OrderMenu> orderMenus() {
        return orderMenus.getOrderMenus();
    }

    public int getAmountBeforeDiscount() {
        return orderMenus.getAmountBeforeDiscount();
    }
}
