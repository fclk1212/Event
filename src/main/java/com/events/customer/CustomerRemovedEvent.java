package com.events.customer;

import lombok.Data;

@Data
public class CustomerRemovedEvent {
    private final Customer customer;
}
