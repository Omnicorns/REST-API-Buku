package com.aloysius.rest.repository;


import com.aloysius.rest.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CustomerRepository extends JpaRepository<Customer,String>, JpaSpecificationExecutor<Customer> {


}
