package com.maveric.projectcharter.service;

import com.maveric.projectcharter.dto.CustomerDTO;
import com.maveric.projectcharter.entity.Customer;
import com.maveric.projectcharter.exception.ServiceException;
import com.maveric.projectcharter.repository.CustomerRepository;
import com.maveric.projectcharter.service.impl.CustomerServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class CustomerServiceTest {
    @InjectMocks
    private CustomerServiceImpl customerService;

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private ModelMapper modelMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateCustomer() {
        CustomerDTO customerDTO = CustomerDTO.builder().
                name("Matthew").
                email("matthew@gmail.com").build();
        Customer customer = Customer.builder().
                customerId("CB00001").
                name("Matthew").
                email("matthew@gmail.com").build();
        when(modelMapper.map(customerDTO, Customer.class)).thenReturn(customer);
        String result = customerService.createCustomer(customerDTO);
        assertNotNull(result);
        assertEquals("Customer Created", result);
    }

    @Test
    void testCreateCustomer_ServiceException() {
        CustomerDTO customerDTO = CustomerDTO.builder().
                name("Matthew").
                email("matthew@gmail.com").build();
        Customer customer = Customer.builder().
                customerId("CB00001").
                name("Matthew").
                email("matthew@gmail.com").build();
        when(modelMapper.map(customerDTO, Customer.class)).thenReturn(customer);
        when(customerRepository.save(any(Customer.class))).thenThrow(mock(DataAccessException.class));
        assertThrows(ServiceException.class, () -> customerService.createCustomer(customerDTO));
    }
}
