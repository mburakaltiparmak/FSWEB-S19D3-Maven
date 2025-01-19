package com.workintech.s19d2.controller;

import com.workintech.s19d2.entity.Account;
import com.workintech.s19d2.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
@AllArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @GetMapping
    public List<Account> findAll(){
        return accountService.findAll();
    }
    @GetMapping("/{id}")
    public Account findById(@PathVariable("id") Long id){
        return accountService.findById(id);
    }
    @PostMapping
    public Account save(@RequestBody Account account){
        return accountService.save(account);
    }
    @PutMapping("/{id}")
    public Account update(@PathVariable("id") Long id, @RequestBody Account account){
        return accountService.update(id,account);
    }
    @DeleteMapping("/{id}")
    public Account delete(@PathVariable("id") Long id){
        return accountService.delete(id);
    }
}
