package com.example.demo.service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Product;

public interface ProductService {

    Iterable<Product> getAll();

    Product get(long id) throws ResourceNotFoundException;

    Product delete(long id) throws ResourceNotFoundException;

    Product add(Product product);

    Product update(Product product, long id) throws ResourceNotFoundException;

    Iterable<Product> getAllSorted();

    Iterable<Product> getByPriceRange(double start, double end);

}
