package com.example.demo.service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Iterable<Product> getAll() {
        return repository.findAll();
    }

    @Override
    public Product get(long id) throws ResourceNotFoundException {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product with such id wasn't found"));
    }

    @Override
    public Product delete(long id) throws ResourceNotFoundException {
        Product product = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product with such id wasn't found"));
        repository.delete(product);
        return product;
    }

    @Override
    public Product add(Product product) {
        return repository.save(product);
    }

    @Override
    public Product update(Product product, long id) throws ResourceNotFoundException {
        Product newProduct = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product with such id wasn't found"));
        newProduct.setId(product.getId());
        newProduct.setName(product.getName());
        newProduct.setPrice(product.getPrice());
        newProduct.setInfo(product.getInfo());
        return newProduct;
    }

    @Override
    public Iterable<Product> getAllSorted() {
        return repository.findAllByOrderByPriceDesc();
    }

    @Override
    public Iterable<Product> getByPriceRange(double start, double end) {
        return repository.findAllByPriceBetween(start, end);
    }

}
