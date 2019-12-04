package com.example.demo.controller;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@NoArgsConstructor
@Getter
@Setter
@RestController
@RequestMapping("/customers")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    @ResponseBody
    public Iterable<Customer> getAllCustomers() {
        return customerService.getAll();

    }

    @PostMapping
    @ResponseBody
    public Customer add(@RequestBody Customer request) {
        return customerService.create(request);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Customer getCustomerById(@PathVariable long id) throws ResourceNotFoundException {
        return customerService.get(id);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public Customer deleteCustomerById(@PathVariable(value = "id") long id) throws ResourceNotFoundException {
        return customerService.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public Customer updateCustomerInfoById(@RequestBody Customer request, @PathVariable long id) throws ResourceNotFoundException {
        return customerService.update(request, id);
    }
}
