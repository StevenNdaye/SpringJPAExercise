package com.thoughtworks.spring.controllers;

import com.thoughtworks.spring.entities.Customer;
import com.thoughtworks.spring.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;


    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Customer> getCustomers() {
        return customerRepository.findAll();
    }

}
