package com.example.controllers;

import com.example.dto.TransferRequest;
import com.example.model.Account;
import com.example.services.TransferService;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {

    private final TransferService transferService;

    public AccountController(TransferService transferService) { this.transferService = transferService; }

    @GetMapping("/accounts")
    public Iterable<Account> getAllAccounts(
        @RequestParam(required = false) String name
    ) {
        if (name == null) {
            return this.transferService.getAllAccounts();
        } else {
            return this.transferService.findAccountsByName(name);
        }
    }

    @PostMapping("/transfer")
    public void transferMoney(
        @RequestBody TransferRequest transferRequest
    ) {
        this.transferService.transferMoney(
            transferRequest.getSenderAccountId(),
            transferRequest.getReceiverAccountId(),
            transferRequest.getAmount()
        );
    }
}
