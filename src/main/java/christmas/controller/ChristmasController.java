package christmas.controller;

import christmas.domain.Customer;
import christmas.domain.OrderMenu;
import christmas.domain.VisitDate;
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
        return Customer.of(takeVisitDate(), takeOrderMenu());
    }

    private VisitDate takeVisitDate() {
        return VisitDate.from(inputView.inputVisitDate());
    }

    private OrderMenu takeOrderMenu() {
        return OrderMenu.from(inputView.inputOrderMenu());
    }

    private void printEventPreviewPhrase(Customer customer) {
        outputView.outputEventPreviewPhrase(customer.visitDate());
    }
}
