package com.ss_reservation.ss_reservation_core.account.repository;

import com.ss_reservation.ss_reservation_core.account.model.EmailCodeConfirmation;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EmailCodeConfirmationRepository extends JpaRepository<EmailCodeConfirmation, Long> {
    EmailCodeConfirmation findByEmail(String email);
    List<EmailCodeConfirmation> findByEmailAndCode(String email, String code);
}