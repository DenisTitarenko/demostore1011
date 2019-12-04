package com.example.demo.service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Seller;
import com.example.demo.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerServiceImpl implements SellerService {

    private SellerRepository repository;

    @Autowired
    public SellerServiceImpl(SellerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Seller add(Seller seller) {
        return repository.save(seller);
    }

    @Override
    public Seller delete(long id) throws Throwable {
        Seller seller = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Seller with such id wasn't found"));
        repository.delete(seller);
        return seller;
    }

    @Override
    public Seller get(long id) throws ResourceNotFoundException {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Seller with such id wasn't found"));
    }

    @Override
    public List<Seller> getAll() {
        return repository.findAll();
    }

    @Override
    public Seller update(Seller seller, long id) throws ResourceNotFoundException {
        Seller newSeller = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Seller with such id wasn't found"));
        newSeller.setPhone(seller.getPhone());
        newSeller.setMail(seller.getMail());
        newSeller.setName(seller.getName());
        return newSeller;
    }
}
