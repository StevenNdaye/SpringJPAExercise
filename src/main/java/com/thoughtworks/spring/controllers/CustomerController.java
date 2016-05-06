package com.thoughtworks.spring.controllers;

import com.thoughtworks.spring.entities.Customer;
import com.thoughtworks.spring.repository.CustomerRepository;
import com.thoughtworks.spring.repository.Repository;
import com.thoughtworks.spring.entities.FinancialStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

import static com.thoughtworks.spring.repository.Repository.Specs.*;
import static org.springframework.data.jpa.domain.Specifications.where;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private Repository repository;


    @RequestMapping(method = RequestMethod.GET)
    public List<Customer> getCustomers() {
        return (List<Customer>) customerRepository.findAll();
    }


    @RequestMapping(method = RequestMethod.GET, value = "/status")
    public List<Customer> getCustomers(@RequestParam String lastName,
                                       @RequestParam List<FinancialStatus> statuses) {
        return customerRepository.findByLastNameAndStatusIn(lastName, statuses);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/by")
    public List<Customer> getCustomer(@RequestParam String firstName, @RequestParam String lastName) {
        return customerRepository.findByFirstNameAndLastNameOrderByEnrollmentDesc(firstName, lastName);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/filterBy")
    public List<Customer> getCustomers(@RequestParam String firstName, @RequestParam String lastName,
                                       @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date bornBefore,
                                       @RequestParam List<FinancialStatus> statuses) {

        return repository.findAll(
                where(firstNameIs(firstName))
                        .and(lastNameIs(lastName))
                        .and(birthDateIsBefore(bornBefore))
                        .and(statusIn(statuses)),
                orderByEnrollmentDesc());


    }


    @RequestMapping(method = RequestMethod.GET, value = "/born")
    public List<Customer> getCustomers(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date from,
                                       @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date to) {
        return repository.findAll(where(birthDateIsBetween(from, to)),
                orderByEnrollmentDesc());
    }

}
