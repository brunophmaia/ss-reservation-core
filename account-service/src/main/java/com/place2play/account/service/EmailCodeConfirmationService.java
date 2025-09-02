package com.place2play.account.service;

import com.place2play.account.configuration.exception.CustomGeneralException;
import com.place2play.account.entity.EmailCodeConfirmation;
import com.place2play.account.repository.AccountRepository;
import com.place2play.account.repository.EmailCodeConfirmationRepository;
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

    @Autowired
    private EmailSendingService emailSendingService;

    @Autowired
    private AccountRepository accountRepo;

    public void setEmail(String email){
        this.email = email;
    }

    public void generateEmailCode() {

        if(accountRepo.existsByEmailIgnoreCase(this.email)){
            throw new CustomGeneralException("createAccount.emailInUse", AccountValidation.getListEmailInInUse(this.email));
        }

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
        emailSendingService.sendEmail(this.email, "SS-Reservation Email Confirmation", String.format("Code: %s", this.code));
    }

    private String generateCode() {
        return String.valueOf(random.nextInt(900001) + 100000);
    }
}
