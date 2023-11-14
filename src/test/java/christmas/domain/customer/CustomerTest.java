package christmas.domain.customer;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CustomerTest {

    @Test
    @DisplayName("손님 - 이벤트 적용 대상이 맞는 경우")
    void testIsTargetForEvent() {
        Customer customer = Customer.of(VisitDate.from("3"), OrderMenus.from("타파스-4,제로콜라-1"));
        assertThat(customer.isTargetForEvent()).isTrue();
    }

    @Test
    @DisplayName("손님 - 이벤트 적용 대상이 아닌 경우")
    void testIsNotTargetForEvent() {
        Customer customer = Customer.of(VisitDate.from("3"), OrderMenus.from("타파스-1,제로콜라-1"));
        assertThat(customer.isTargetForEvent()).isFalse();
    }


}
