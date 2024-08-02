package com.ss_reservation.ss_reservation_core.Models.Validation;

import com.ss_reservation.ss_reservation_core.Exception.CustomGeneralException;
import com.ss_reservation.ss_reservation_core.Models.AccountModel;
import com.ss_reservation.ss_reservation_core.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class AccountValidation {

    @Autowired
    private AccountRepository accountRepository;

    public void checkAccount(AccountModel accountModel){
        if(accountModel.checkNullRequiredFields()){
            throw new CustomGeneralException("createAccount.checkFields");
        }

        if(accountRepository.existsByEmail(accountModel.getEmail())) {
            throw new CustomGeneralException("createAccount.emailInUse", getListEmailInInUse(accountModel.getEmail()));
        }
    }

    private List<String> getListEmailInInUse(String email) {
        List<String> emails = new ArrayList<String>();
        emails.add(email);
        return emails;
    }
}
