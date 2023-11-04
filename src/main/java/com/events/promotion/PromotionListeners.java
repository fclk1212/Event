package com.events.promotion;

import com.events.customer.CustomerRegisteredEvent;
import com.events.order.OrderCompletedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PromotionListeners
{

    private final PromotionService promotionService;

    @EventListener(condition = "#event.customer.newsletter")
    public void onRegistrationEvent (CustomerRegisteredEvent event)
    {
        promotionService.applyPromotion(event.getCustomer());
    }

    @EventListener
    public void onOrderCompleted(OrderCompletedEvent event)
    {
        promotionService.calculateRewardPoints(event.getOrder());
    }
}
