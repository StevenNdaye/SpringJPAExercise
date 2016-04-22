package com.thoughtworks.spring.entities;

import com.thoughtworks.spring.utilities.FinancialStatus;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Customer {
    @Id
    private Integer id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private LocalDate enrollment;
    @Enumerated
    private FinancialStatus status;


}
