package com.example.demo.controller;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Seller;
import com.example.demo.service.SellerService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@RestController
@RequestMapping("/sellers")
public class SellerController {

    private SellerService service;

    @Autowired
    public SellerController(SellerService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseBody
    public Seller addSeller(@RequestBody Seller seller) {
        return service.add(seller);
    }

    @GetMapping
    @ResponseBody
    public List<Seller> getAllSellers() {
        return service.getAll();
    }

    @ResponseBody
    @GetMapping("/{id}")
    public Seller getSeller(@PathVariable long id) throws ResourceNotFoundException {
        return service.get(id);
    }

    @ResponseBody
    @DeleteMapping("/{id}")
    public Seller deleteSeller(@PathVariable long id) throws Throwable {
        return service.delete(id);
    }

    @ResponseBody
    @PutMapping("/{id}")
    public Seller updateSeller(@RequestBody Seller seller, @PathVariable long id) throws ResourceNotFoundException {
        return service.update(seller, id);
    }
}
