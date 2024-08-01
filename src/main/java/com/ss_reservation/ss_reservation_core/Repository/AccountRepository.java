package com.ss_reservation.ss_reservation_core.Repository;

import com.ss_reservation.ss_reservation_core.Entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    //boolean existsByEmail(String email);
}