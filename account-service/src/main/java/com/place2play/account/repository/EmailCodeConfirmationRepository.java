package com.place2play.account.repository;

import com.place2play.account.entity.EmailCodeConfirmation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmailCodeConfirmationRepository extends JpaRepository<EmailCodeConfirmation, Long> {
    EmailCodeConfirmation findByEmail(String email);
    List<EmailCodeConfirmation> findByEmailAndCode(String email, String code);
}