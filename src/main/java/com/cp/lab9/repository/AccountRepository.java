package com.cp.lab9.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cp.lab9.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
}