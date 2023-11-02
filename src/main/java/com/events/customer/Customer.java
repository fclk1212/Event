package com.events.customer;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
public class Customer
{
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String email;
    private boolean newsletter;

    @Column(columnDefinition = "DECIMAL(2)")
    private BigDecimal rewardPoints;

    public Customer(String email)
    {
        this.email = email;
    }
}
