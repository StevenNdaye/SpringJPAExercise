package com.thoughtworks.spring.repository;

import com.thoughtworks.spring.entities.Customer;
import com.thoughtworks.spring.entities.FinancialStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    List<Customer> findByLastNameAndStatusIn(String lastName, List<FinancialStatus> statuses);

    List<Customer> findByFirstNameAndLastNameOrderByEnrollmentDesc(String firstName, String lastName);

    List<Customer> findByFirstNameAndLastNameAndBirthDateIsLessThanAndStatusInOrderByEnrollmentDesc(String firstName, String lastName, Date birthDateLimit, List<FinancialStatus> statuses);

    List<Customer> findByFirstNameAndLastNameAndBirthDateIsBetweenAndStatusInOrderByEnrollmentDesc(String firstName, String lastName, Date birthDateFrom, Date birthDateTo, List<FinancialStatus> statuses);
}
