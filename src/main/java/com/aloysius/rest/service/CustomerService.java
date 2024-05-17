package com.aloysius.rest.service;

import com.aloysius.rest.dto.CustomerSearchDTO;
import com.aloysius.rest.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {

    Customer saveCustomer (Customer customer);
    Customer updateCustomer (Customer customer);
    List<Customer> getAllCustomer();
    Customer getCustomerById (String customerId);
    void deleteCustomer(String id);
    Page<Customer> getCustomerPage(Pageable pageable, CustomerSearchDTO customerSearchDTO);

}
