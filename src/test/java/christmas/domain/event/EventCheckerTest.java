package christmas.domain.event;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.customer.Customer;
import christmas.domain.customer.OrderMenus;
import christmas.domain.customer.VisitDate;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EventCheckerTest {

    @Test
    @DisplayName("이벤트 체커 테스트 - 적용된 이벤트 반환 확인(디데이, 평일, 특별, 증정)")
    void testEventResultCase1() {
        EventChecker eventChecker = EventChecker.from(
                Customer.of(
                        VisitDate.from("3"),
                        OrderMenus.from("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1")
                )
        );

        List<OfferedEvent> test = List.of(OfferedEvent.of("크리스마스 디데이 할인", 1200),
                OfferedEvent.of("평일 할인", 4046),
                OfferedEvent.of("특별 할인", 1000),
                OfferedEvent.of("증정 이벤트", 25000)
        );

        assertThat(eventChecker.generateEventResult()).usingRecursiveComparison().isEqualTo(test);
    }

    @Test
    @DisplayName("이벤트 체커 테스트 - 적용된 이벤트 반환 확인(이벤트 대상이 아닌 경우)")
    void testEventResultCase2() {
        EventChecker eventChecker = EventChecker.from(
                Customer.of(
                        VisitDate.from("26"),
                        OrderMenus.from("타파스-1,제로콜라-1")
                )
        );

        List<OfferedEvent> test = Collections.emptyList();

        assertThat(eventChecker.generateEventResult()).usingRecursiveComparison().isEqualTo(test);
    }

    @Test
    @DisplayName("이벤트 체커 테스트 - 적용된 이벤트 반환 확인(주말, 증정)")
    void testEventResultCase3() {
        EventChecker eventChecker = EventChecker.from(
                Customer.of(
                        VisitDate.from("30"),
                        OrderMenus.from("티본스테이크-3,제로콜라-1")
                )
        );

        List<OfferedEvent> test = List.of(
                OfferedEvent.of("주말 할인", 6069),
                OfferedEvent.of("증정 이벤트", 25000)
        );

        assertThat(eventChecker.generateEventResult()).usingRecursiveComparison().isEqualTo(test);
    }

    @Test
    @DisplayName("이벤트 체커 테스트 - 적용된 이벤트 반환 확인(디데이, 평일, 특별, 증정)")
    void testEventResultCase4() {
        EventChecker eventChecker = EventChecker.from(
                Customer.of(
                        VisitDate.from("25"),
                        OrderMenus.from("티본스테이크-3,초코케이크-2,제로콜라-1")
                )
        );

        List<OfferedEvent> test = List.of(
                OfferedEvent.of("크리스마스 디데이 할인", 3400),
                OfferedEvent.of("평일 할인", 4046),
                OfferedEvent.of("특별 할인", 1000),
                OfferedEvent.of("증정 이벤트", 25000)
        );

        assertThat(eventChecker.generateEventResult()).usingRecursiveComparison().isEqualTo(test);
    }
}
