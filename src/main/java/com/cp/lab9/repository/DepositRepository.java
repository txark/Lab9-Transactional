package com.cp.lab9.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cp.lab9.model.DepositTransaction;

public interface DepositRepository extends JpaRepository<DepositTransaction, Long> {
}