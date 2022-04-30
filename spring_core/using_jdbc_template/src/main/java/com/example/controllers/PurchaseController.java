package com.example.controllers;

import com.example.model.Purchase;
import com.example.repositories.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    private final PurchaseRepository purchaseRepository;

    @Autowired
    public PurchaseController(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    @GetMapping
    public List<Purchase> findPurchases() {
        return this.purchaseRepository.findAllPurchases();
    }

    @PostMapping
    public void storePurchase(@RequestBody Purchase purchase) {
        this.purchaseRepository.storePurchase(purchase);
    }
}
