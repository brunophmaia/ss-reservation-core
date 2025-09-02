package com.place2play.account.repository;

import com.place2play.account.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

    boolean existsByEmailIgnoreCase(String email);

    Account findByEmail(String email);
}