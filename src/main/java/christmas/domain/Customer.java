package christmas.domain;

public class Customer {
    private VisitDate visitDate;
    private OrderMenu orderMenu;

    private Customer(VisitDate visitDate, OrderMenu orderMenu) {
        this.visitDate = visitDate;
        this.orderMenu = orderMenu;
    }

    public static Customer of(VisitDate visitDate, OrderMenu orderMenu) {
        return new Customer(visitDate, orderMenu);
    }

    public int visitDate() {
        return visitDate.visitDate();
    }
}
