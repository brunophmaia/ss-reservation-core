package com.place2play.account.service;

import com.place2play.account.entity.Account;
import com.place2play.account.model.mapper.AccountMapper;
import com.place2play.account.model.dto.AccountDTO;
import com.place2play.account.repository.AccountRepository;
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

    public Long checkUser(String username, String password) {

        Account account = accountRepository.findByEmail(username);

        if(account == null) {
            return null;
        }

        return passwordEncoder.isValidPassword(password, account.getPassword()) ? account.getId() : null;
    }
}
