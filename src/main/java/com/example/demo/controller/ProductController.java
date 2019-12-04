package com.example.demo.controller;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Getter
@Setter
@NoArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    @ResponseBody
    public Iterable<Product> getAllProducts() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Product getProductById(@PathVariable long id) throws ResourceNotFoundException {
        return service.get(id);
    }

    @PostMapping
    @ResponseBody
    public Product addProduct(@RequestBody Product product) {
        return service.add(product);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public Product deleteProductById(@PathVariable long id) throws ResourceNotFoundException {
        return service.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public Product updateProductById(@RequestBody Product request, @PathVariable long id) throws ResourceNotFoundException {
        return service.update(request, id);
    }


    @GetMapping("/sortedbyprice/desc")
    @ResponseBody
    public Iterable<Product> getAllProductsOrderedByPriceDesc() {
        return service.getAllSorted();
    }


    @GetMapping("/range")
    public Iterable<Product> getProductsInPriceRange(@RequestParam(value = "start") double start,
                                                     @RequestParam(value = "end") double end) {
        return service.getByPriceRange(start, end);
    }
}
