package com.ss_reservation.ss_reservation_core.account.service;

import com.ss_reservation.ss_reservation_core.account.model.EmailCodeConfirmation;
import com.ss_reservation.ss_reservation_core.account.repository.EmailCodeConfirmationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Random;

@Component
@Scope("prototype")
public class EmailCodeConfirmationService {

    private String email;
    private String code;

    private final Random random = new Random();

    @Autowired
    private EmailCodeConfirmationRepository emailCodeConfirmationRepo;

    public void setEmail(String email){
        this.email = email;
    }

    public void generateEmailCode() {
        EmailCodeConfirmation emailCodeConfirmation = emailCodeConfirmationRepo.findByEmail(this.email);

        if(emailCodeConfirmation == null) {
            emailCodeConfirmation = new EmailCodeConfirmation(this.email);
        }

        this.code = generateCode();

        emailCodeConfirmation.setCode(this.code);
        emailCodeConfirmation.setCreateDate(new Date());
        emailCodeConfirmationRepo.save(emailCodeConfirmation);
    }

    public void sendEmail(){
        System.out.println(this.code);
    }

    private String generateCode() {
        return String.valueOf(random.nextInt(900001) + 100000);
    }
}
