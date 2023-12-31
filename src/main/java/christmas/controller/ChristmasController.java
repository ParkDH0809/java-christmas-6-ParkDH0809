package christmas.controller;

import christmas.domain.customer.Customer;
import christmas.domain.customer.OrderMenu;
import christmas.domain.customer.OrderMenus;
import christmas.domain.customer.VisitDate;
import christmas.view.InputView;
import christmas.view.OutputView;

public class ChristmasController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void startProgram() {
        Customer customer = receiveCustomer();
        printEventPreviewPhrase(customer);
        printOrderMenu(customer);
        printOrderAmount(customer);

        new EventController(outputView).provideEvent(customer);
    }

    private Customer receiveCustomer() {
        return Customer.of(takeVisitDate(), takeOrderMenus());
    }

    private VisitDate takeVisitDate() {
        try {
            return VisitDate.from(inputView.inputVisitDate());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return takeVisitDate();
        }
    }

    private OrderMenus takeOrderMenus() {
        try {
            return OrderMenus.from(inputView.inputOrderMenu());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return takeOrderMenus();
        }
    }

    private void printEventPreviewPhrase(Customer customer) {
        outputView.outputEventPreviewPhrase(customer.visitDate());
    }

    private void printOrderMenu(Customer customer) {
        outputView.outputOrderMenuTitle();
        for (OrderMenu orderMenu : customer.orderMenus()) {
            outputView.outputOrderMenu(orderMenu.getMenuName(), orderMenu.getOrderNumber());
        }
    }

    private void printOrderAmount(Customer customer) {
        outputView.outputBeforeDiscount(customer.getAmountBeforeDiscount());
    }
}