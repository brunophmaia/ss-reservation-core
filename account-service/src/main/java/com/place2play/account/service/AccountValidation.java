package com.place2play.account.service;

import com.place2play.account.configuration.exception.CustomGeneralException;
import com.place2play.account.entity.EmailCodeConfirmation;
import com.place2play.account.model.dto.AccountDTO;
import com.place2play.account.repository.AccountRepository;
import com.place2play.account.repository.EmailCodeConfirmationRepository;
import com.place2play.account.utility.DateUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class AccountValidation {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private EmailCodeConfirmationRepository emailCodeConfirmationRepository;

    @Value("${account.email-code-expiration-hours}")
    private int codeExpirationHours;

    public void checkAccount(AccountDTO accountDTO){

        if(accountDTO.checkNullRequiredFields()){
            throw new CustomGeneralException("createAccount.checkFields");
        }

        if(accountRepository.existsByEmailIgnoreCase(accountDTO.getEmail())) {
            throw new CustomGeneralException("createAccount.emailInUse", getListEmailInInUse(accountDTO.getEmail()));
        }

        if(!checkValidCode(accountDTO)) {
            throw new CustomGeneralException("createAccount.invalidCode");
        }
    }

    private boolean checkValidCode(AccountDTO accountDTO){

        List<EmailCodeConfirmation> listEmailCode =
                emailCodeConfirmationRepository
                        .findByEmailAndCode(accountDTO.getEmail(), accountDTO.getEmailCode());

        if(listEmailCode.isEmpty()) {
            return  false;
        }
        else {
            Date codeCreatedDate  = listEmailCode.getFirst().getCreateDate();
            return !DateUtility.addHour(codeCreatedDate, codeExpirationHours).before(new Date());
        }
    }

    public static List<String> getListEmailInInUse(String email) {
        List<String> emails = new ArrayList<String>();
        emails.add(email);
        return emails;
    }
}
