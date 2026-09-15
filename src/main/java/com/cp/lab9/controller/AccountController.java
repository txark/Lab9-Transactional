package com.cp.lab9.controller;

import com.cp.lab9.model.Account;
import com.cp.lab9.service.AccountService;
import com.cp.lab9.service.DepositService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    private final AccountService accountService;
    private final DepositService depositService;

    public AccountController(AccountService accountService, DepositService depositService) {
        this.accountService = accountService;
        this.depositService = depositService;
    }

    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        Account created = accountService.createAccount(account);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccount(@PathVariable Long id) {
        Account account = accountService.getAccountById(id);
        return ResponseEntity.ok(account);
    }

    @PostMapping("/{id}/deposit")
    public ResponseEntity<Map<String, String>> deposit(
            @PathVariable Long id,
            @RequestBody Map<String, Double> request) {
        Double amount = request.get("amount");
        depositService.deposit(id, amount);
        return ResponseEntity.ok(Map.of("message", "Deposit successful"));
    }
}