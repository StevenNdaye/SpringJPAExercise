package com.thoughtworks.spring.repository;

import com.thoughtworks.spring.entities.Customer;
import com.thoughtworks.spring.utilities.FinancialStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    List<Customer> findByLastNameAndStatusIn(String lastName, List<FinancialStatus> statuses);

    List<Customer> findByFirstNameAndLastNameOrderByEnrollmentDesc(String firstName, String lastName);
}
