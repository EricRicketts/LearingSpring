package com.example.services;

import com.example.exceptions.AccountNotFoundException;
import com.example.model.Account;
import com.example.repositories.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TransferService {

    private final AccountRepository accountRepository;

    public TransferService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    public void transferMoney(long idSender, long idReceiver, BigDecimal amount) {
        Account sender = this.accountRepository.findById(idSender)
                .orElseThrow(AccountNotFoundException::new);

        Account receiver = this.accountRepository.findById(idReceiver)
                .orElseThrow(AccountNotFoundException::new);

        BigDecimal senderNewAmount = sender.getAmount().subtract(amount);
        BigDecimal receiverNewAmount = sender.getAmount().add(amount);

        this.accountRepository.changeAmount(idSender, senderNewAmount);
        this.accountRepository.changeAmount(idReceiver, receiverNewAmount);
    }

    public Iterable<Account> getAllAccounts() { return this.accountRepository.findAll(); }

    public List<Account> findAccountsByName(String name) { return this.accountRepository.findAccountsByName(name); }
}
