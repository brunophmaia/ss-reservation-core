package com.ss_reservation.ss_reservation_core.account.service;

import com.ss_reservation.ss_reservation_core.account.model.Account;
import com.ss_reservation.ss_reservation_core.account.mapper.AccountMapper;
import com.ss_reservation.ss_reservation_core.account.validation.AccountValidation;
import com.ss_reservation.ss_reservation_core.account.repository.AccountRepository;
import com.ss_reservation.ss_reservation_core.account.model.AccountDTO;
import com.ss_reservation.ss_reservation_core.security.service.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ApplicationContext context;

    @Autowired
    private EmailCodeConfirmationService emailCodeConfirmationService;

    private final PasswordEncoder passwordEncoder;

    public AccountService() {
        this.passwordEncoder = new PasswordEncoder();
    }

    public synchronized void createUser(AccountDTO accountDTO){

        AccountValidation accountValidation = context.getBean(AccountValidation.class);
        accountValidation.checkAccount(accountDTO);

        Account account = AccountMapper.INSTANCE.toEntity(accountDTO);
        account.setPassword(passwordEncoder.getEncodedPassword(accountDTO.getPassword()));

        accountRepository.save(account);
    }

    public void sendEmailCode(String email) {
        emailCodeConfirmationService.setEmail(email);
        emailCodeConfirmationService.generateEmailCode();
        //emailCodeConfirmationService.sendEmail();
    }

    public boolean checkUser(String username, String password) {

        Account account = accountRepository.findByEmail(username);

        if(account == null) {
            return false;
        }

        return passwordEncoder.isValidPassword(password, account.getPassword());
    }
}
