package com.ss_reservation.ss_reservation_core.account.repository;

import com.ss_reservation.ss_reservation_core.account.entity.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountTypeRepository extends JpaRepository<AccountType, Long> {

    boolean existsByKey(String key);
}