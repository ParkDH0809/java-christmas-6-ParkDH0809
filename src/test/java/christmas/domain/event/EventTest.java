package christmas.domain.event;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.customer.Customer;
import christmas.domain.customer.OrderMenus;
import christmas.domain.customer.VisitDate;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EventTest {

    static Event event;
    static Customer customer;
    static List<OfferedEvent> offeredEvents;

    @BeforeAll
    static void initEventTest() {
        customer = Customer.of(
                VisitDate.from("3"),
                OrderMenus.from("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1")
        );
        event = Event.from(customer);
        offeredEvents = event.getEventBenefit();
    }

    @Test
    @DisplayName("이벤트 테스트 - 총 혜택 금액 테스트")
    void testTotalDiscountAmount() {
        assertThat(event.getTotalDiscountAmount()).isEqualTo(-31246);
    }

    @Test
    @DisplayName("이벤트 테스트 - 할인 후 예상 결제 금액 테스트")
    void testEstimatedAmount() {
        assertThat(event.getEstimatedAmount()).isEqualTo(135754);
    }

    @Test
    @DisplayName("이벤트 테스트 - 배지 테스트")
    void testBadge() {
        assertThat(event.getBadge()).isEqualTo("산타");
    }
}
