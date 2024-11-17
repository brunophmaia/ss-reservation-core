package com.ss_reservation.ss_reservation_core.account.repository;

import com.ss_reservation.ss_reservation_core.account.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

    boolean existsByEmail(String email);

    Account findByEmail(String email);
}