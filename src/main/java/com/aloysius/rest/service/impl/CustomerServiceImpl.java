package com.aloysius.rest.service.impl;

import com.aloysius.rest.config.ThreadPoolConfig;
import com.aloysius.rest.dto.CustomerSearchDTO;
import com.aloysius.rest.entity.Customer;
import com.aloysius.rest.repository.CustomerRepository;
import com.aloysius.rest.service.CustomerService;
import com.aloysius.rest.specification.CustomerSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ThreadPoolConfig threadpoolConfig;


    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;

    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }


    @Override
    public Customer getCustomerById(String customerId) {
        Optional<Customer> cust=customerRepository.findById(customerId);
        if(cust.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Customer is not Found");
        }
        return cust.get();
    }

    @Override
    public void deleteCustomer(String id) {

        customerRepository.deleteById(id);
    }

    @Override
    public Page<Customer> getCustomerPage(Pageable pageable, CustomerSearchDTO customerSearchDTO) {
        Specification<Customer>customerSpecification= CustomerSpecification.getspecification(customerSearchDTO);

        return customerRepository.findAll(customerSpecification,pageable);
    }




}
