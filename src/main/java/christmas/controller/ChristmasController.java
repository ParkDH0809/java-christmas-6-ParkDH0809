package christmas.controller;

import christmas.domain.Customer;
import christmas.domain.OrderMenu;
import christmas.domain.VisitDate;
import christmas.view.InputView;
import christmas.view.OutputView;

public class ChristmasController {
    private final InputView inputView = new InputView();

    public void startProgram() {
        takeOrder();
    }

    private void takeOrder() {
        Customer customer = receiveCustomer();
    }

    private Customer receiveCustomer() {
        return Customer.of(takeVisitDate(), takeOrderMenu());
    }

    private VisitDate takeVisitDate() {
        return VisitDate.from(inputView.inputVisitDate());
    }

    private OrderMenu takeOrderMenu() {
        return OrderMenu.from(inputView.inputOrderMenu());
    }
}
