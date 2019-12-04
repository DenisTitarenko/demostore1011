package com.example.demo.service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }


    @Override
    public Iterable<Customer> getAll() {
        return repository.findAll();
    }

    @Override
    public Customer get(long id) throws ResourceNotFoundException {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer with such id wasn't found"));
    }

    @Override
    public Customer create(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public Customer update(Customer customer, long id) throws ResourceNotFoundException {
        Customer newCustomer = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer with such id wasn't found"));
        newCustomer.setFirstName(customer.getFirstName());
        newCustomer.setLastName(customer.getLastName());
        newCustomer.setAddress(customer.getAddress());
        repository.save(newCustomer);
        return newCustomer;
    }

    @Override
    public Customer delete(long id) throws ResourceNotFoundException {
        Customer customer = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer with such id wasn't found"));
        repository.delete(customer);
        return customer;
    }
}
