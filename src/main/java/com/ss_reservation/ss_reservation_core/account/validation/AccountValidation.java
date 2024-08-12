package com.ss_reservation.ss_reservation_core.account.validation;

import com.ss_reservation.ss_reservation_core.common.exception.CustomGeneralException;
import com.ss_reservation.ss_reservation_core.account.model.AccountDTO;
import com.ss_reservation.ss_reservation_core.account.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class AccountValidation {

    @Autowired
    private AccountRepository accountRepository;

    public void checkAccount(AccountDTO accountDTO){
        if(accountDTO.checkNullRequiredFields()){
            throw new CustomGeneralException("createAccount.checkFields");
        }

        if(accountRepository.existsByEmail(accountDTO.getEmail())) {
            throw new CustomGeneralException("createAccount.emailInUse", getListEmailInInUse(accountDTO.getEmail()));
        }
    }

    private List<String> getListEmailInInUse(String email) {
        List<String> emails = new ArrayList<String>();
        emails.add(email);
        return emails;
    }
}
