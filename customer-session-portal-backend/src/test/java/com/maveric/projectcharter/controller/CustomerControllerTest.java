package com.maveric.projectcharter.controller;

import com.maveric.projectcharter.dto.CustomerDTO;
import com.maveric.projectcharter.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
class CustomerControllerTest {

    @InjectMocks
    private CustomerController customerController;

    @Mock
    private CustomerService customerService;

    @Test
    void testCreateCustomer(){
        CustomerDTO customerDTO = CustomerDTO.builder().
                name("Matthew").
                email("matthew@gmail.com").build();
        when(customerService.createCustomer(customerDTO)).thenReturn(anyString());
        ResponseEntity<String> result = customerController.createCustomer(customerDTO);
        assertEquals(HttpStatus.CREATED, result.getStatusCode());
        assertNotNull(result);
    }
}
