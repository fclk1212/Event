package com.events.email;

import com.events.customer.CustomerRegisteredEvent;
import com.events.customer.CustomerRemovedEvent;
import com.events.order.OrderCompletedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@RequiredArgsConstructor
public class EmailListeners {

    private final EmailService emailService;

    @EventListener
    public void onRegisterEvent(CustomerRegisteredEvent event) {
        emailService.sendRegisterEmail(event.getCustomer());
    }

    @EventListener
    public void onCustomerRemovedEvent(CustomerRemovedEvent event) {
        emailService.sendCustomerRemovedEmail(event.getCustomer());
    }

    @EventListener
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void onOrderCompletedEvent(OrderCompletedEvent event)
    {
        emailService.sendOrderEmail(event.getOrder());
    }
}
