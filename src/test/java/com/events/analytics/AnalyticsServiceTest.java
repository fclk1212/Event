package com.events.analytics;

import com.events.customer.Customer;
import com.events.customer.CustomerRepository;
import com.events.customer.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.timeout;

@SpringBootTest
class AnalyticsServiceTest
{
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerService customerService;

    @SpyBean
    private AnalyticsService analyticsService;

    @Test
    void registerCustomer_forNewCustomer_callsAnalytics(){

        //given
        Customer customer = new Customer("fatmacelik@demo.com");
        customerRepository.save(customer);

        //when
        customerService.register(customer);

        //then
        then(analyticsService).should(timeout(100)).registerNewCustomer(customer);
    }

}