package com.events.email;

import com.events.customer.Customer;
import com.events.customer.CustomerRepository;
import com.events.customer.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.annotation.DirtiesContext;

import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class EmailCustomerServiceTest
{
    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerRepository customerRepository;

    @SpyBean
    private EmailService emailService;

    @Test
    void registerCustomer_forNewCustomer_sendsAnEmail(){
        
        Customer customer = new Customer("fatmacelik@demo.com");
        customerService.register(customer);
        then(emailService).should(times(1)).sendRegisterEmail(customer);
    }

    @Test
    void removeCustomer_forExistingCustomer_sendsAnEmail(){
        
        Customer customer = new Customer("fatmacelik@demo.com");
        customerRepository.save(customer);
        customerService.remove(customer);
        then(emailService).should(times(1)).sendCustomerRemovedEmail(customer);
    }
}