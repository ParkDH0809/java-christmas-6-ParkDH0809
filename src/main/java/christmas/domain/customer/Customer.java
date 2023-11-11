package christmas.domain.customer;

public class Customer {
    private final VisitDate visitDate;
    private final OrderMenu orderMenu;

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
