package com.example.demo.service;


import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Customer;


public interface CustomerService {

    Iterable<Customer> getAll();

    Customer get(long id) throws ResourceNotFoundException;

    Customer create(Customer customer);

    Customer update(Customer customer, long id) throws ResourceNotFoundException;

    Customer delete(long id) throws ResourceNotFoundException;


}
