package com.example.demo.service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Seller;

import java.util.List;

public interface SellerService {

    Seller add(Seller seller);

    Seller delete(long id) throws Throwable;

    Seller get(long id) throws ResourceNotFoundException;

    List<Seller> getAll();

    Seller update(Seller seller, long id) throws ResourceNotFoundException;
}
