package com.aloysius.rest.controller;


import com.aloysius.rest.annotation.CustomAnnotation;
import com.aloysius.rest.dto.CustomerSearchDTO;
import com.aloysius.rest.entity.Customer;
import com.aloysius.rest.service.CustomerService;
import com.aloysius.rest.util.PageResponseWrapper;
import com.aloysius.rest.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.aloysius.rest.constant.ApiUrlConstant.CUSTOMER_PATH;

@CustomAnnotation
@RequestMapping(CUSTOMER_PATH)

public class CustomerController {
    CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping()
    public ResponseEntity<Response<Customer>>saveCustomer(@RequestBody Customer customer){
        String message ="Data resources Customer has been inserted";
        Response<Customer>response = new Response<>();
        response.setMessage(message);
        response.setData(customerService.saveCustomer(customer));
        return  ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }


    @GetMapping("/getallcust")
    public ResponseEntity< Response<List<Customer>>> findCustomer( ){
        String message ="Data Customer found";
        Response<List<Customer>>customerResponse= new Response<>();
        customerResponse.setMessage(message);
        customerResponse.setData(customerService.getAllCustomer());


        return  ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(customerResponse);
    }

    @GetMapping("/pagination")
    public PageResponseWrapper<Customer> findCustomer(@RequestParam (defaultValue = "0") Integer page,
                                                      @RequestParam (defaultValue = "5")Integer size,
                                                      @RequestParam(name = "sortBy",defaultValue = "fullName")String sort,
                                                      @RequestParam(name="direction",defaultValue = "ASC")String direction,
                                                      @RequestParam (required = false)String fullName,
                                                      @RequestParam (required = false)String address,
                                                      @RequestParam (required = false)String birthDate ){
        Sort sort1 = Sort.by(Sort.Direction.fromString(direction),sort);
        Pageable pageable = PageRequest.of(page,size,sort1);
        CustomerSearchDTO customerSearchDTO = new CustomerSearchDTO();
        customerSearchDTO.setCustomerFullName(fullName);
        customerSearchDTO.setCustomerAddress(address);

     Page<Customer> customers  =  customerService.getCustomerPage(pageable,customerSearchDTO);
     return  new PageResponseWrapper<>(customers);
    }

    @GetMapping("/{id}")
    public  Customer findCustomerById(@PathVariable String id){
        return customerService.getCustomerById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable String id){
        customerService.deleteCustomer(id);
    }

    @PutMapping()
    public Customer updateCustomer(@RequestBody Customer customer){
        return customerService.updateCustomer(customer);
    }


}
