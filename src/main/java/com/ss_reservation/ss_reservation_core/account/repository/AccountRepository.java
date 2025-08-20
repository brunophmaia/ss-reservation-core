package com.ss_reservation.ss_reservation_core.account.repository;

import com.ss_reservation.ss_reservation_core.account.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

    boolean existsByEmailIgnoreCase(String email);

    Account findByEmail(String email);
}