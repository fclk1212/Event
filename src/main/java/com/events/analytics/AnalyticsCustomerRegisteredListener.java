package com.events.analytics;

import com.events.customer.CustomerRegisteredEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AnalyticsCustomerRegisteredListener
{
    private final AnalyticsService analyticsService;

    @Async
    @EventListener
    public void onRegisterEvent(CustomerRegisteredEvent event)
    {
        analyticsService.registerNewCustomer(event.getCustomer());
    }
}
