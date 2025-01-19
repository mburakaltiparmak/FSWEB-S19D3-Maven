package com.workintech.s19d2.service;

import com.workintech.s19d2.repository.AccountRepository;
import com.workintech.s19d2.entity.Account;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService{
    private final AccountRepository accountRepository;
    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account findById(Long id) {
        return accountRepository.findById(id).orElseThrow(()-> new RuntimeException("This account is not exist!"));
    }

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account update(Long id, Account updatedAccount) {
        Account accountToBeUpdate = findById(id);
        accountToBeUpdate.setName(updatedAccount.getName());
        accountToBeUpdate.setId(updatedAccount.getId());
        return accountToBeUpdate;
    }

    @Override
    public Account delete(Long id) {
        Account deletedAccount = findById(id);
        accountRepository.delete(deletedAccount);
        return deletedAccount;
    }
}
