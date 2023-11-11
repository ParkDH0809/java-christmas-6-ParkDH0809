package christmas.controller;

import christmas.domain.customer.Customer;
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
    }

    private Customer receiveCustomer() {
        return Customer.of(takeVisitDate(), takeOrderMenus());
    }

    private VisitDate takeVisitDate() {
        return VisitDate.from(inputView.inputVisitDate());
    }

    private OrderMenus takeOrderMenus() {
        return OrderMenus.from(inputView.inputOrderMenu());
    }

    private void printEventPreviewPhrase(Customer customer) {
        outputView.outputEventPreviewPhrase(customer.visitDate());
    }
}
