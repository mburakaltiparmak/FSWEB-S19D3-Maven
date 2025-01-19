package com.workintech.s19d2.repository;

import com.workintech.s19d2.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account,Long> {
    @Query(value = "select a from Account a where a.name = :name")
    Optional<Account> findByName(String name);

}
