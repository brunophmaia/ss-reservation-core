package com.ss_reservation.ss_reservation_core.Repository;

import com.ss_reservation.ss_reservation_core.Entities.EmailCodeConfirmation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailCodeConfirmationRepository extends JpaRepository<EmailCodeConfirmation, Long> {
    EmailCodeConfirmation findByEmail(String email);
}