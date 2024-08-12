package com.ss_reservation.ss_reservation_core.account.service;

import com.ss_reservation.ss_reservation_core.account.model.Account;
import com.ss_reservation.ss_reservation_core.account.mapper.AccountMapper;
import com.ss_reservation.ss_reservation_core.account.validation.AccountValidation;
import com.ss_reservation.ss_reservation_core.account.repository.AccountRepository;
import com.ss_reservation.ss_reservation_core.account.model.AccountDTO;
import com.ss_reservation.ss_reservation_core.account.config.PasswordEncoderService;
import com.ss_reservation.ss_reservation_core.account.service.Interface.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ApplicationContext context;

    @Autowired
    private EmailCodeConfirmationService emailCodeConfirmationService;

    private final PasswordEncoderService passwordEncoderService;

    public AccountServiceImpl () {
        this.passwordEncoderService = new PasswordEncoderService();
    }

    public synchronized void createUser(AccountDTO accountDTO){

        AccountValidation accountValidation = context.getBean(AccountValidation.class);
        accountValidation.checkAccount(accountDTO);

        Account account = AccountMapper.INSTANCE.toEntity(accountDTO);
        account.setPassword(passwordEncoderService.getEncodedPassword(accountDTO.getPassword()));

        accountRepository.save(account);
    }

    public void sendEmailCode(String email) {
        emailCodeConfirmationService.setEmail(email);
        emailCodeConfirmationService.generateEmailCode();
        emailCodeConfirmationService.sendEmail();
    }
}
