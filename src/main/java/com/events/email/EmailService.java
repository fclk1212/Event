package com.events.email;

import com.events.customer.Customer;
import com.events.order.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EmailService {

    public void sendRegisterEmail(Customer customer) {
        log.info("Sending registration email to customer {}", customer);
    }

    public void sendCustomerRemovedEmail(Customer customer) {
        log.info("Sending removed email for customer {}", customer);
    }

    public void sendOrderEmail(Order order) {
        log.info("Sending email for order {}", order);
    }
}
