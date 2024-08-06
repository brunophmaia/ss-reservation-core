package com.ss_reservation.ss_reservation_core.Services;

import com.ss_reservation.ss_reservation_core.Entities.Account;
import com.ss_reservation.ss_reservation_core.Models.Mappers.AccountMapper;
import com.ss_reservation.ss_reservation_core.Models.Validation.AccountValidation;
import com.ss_reservation.ss_reservation_core.Repository.AccountRepository;
import com.ss_reservation.ss_reservation_core.Models.AccountModel;
import com.ss_reservation.ss_reservation_core.Security.SecurityService;
import com.ss_reservation.ss_reservation_core.Services.Interfaces.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ApplicationContext context;

    private final SecurityService securityService;

    public AccountServiceImpl () {
        this.securityService = new SecurityService();
    }

    public synchronized void createUser(AccountModel accountModel){

        AccountValidation accountValidation = context.getBean(AccountValidation.class);
        accountValidation.checkAccount(accountModel);

        Account account = AccountMapper.INSTANCE.toEntity(accountModel);
        account.setPassword(securityService.getEncodedPassword(accountModel.getPassword()));

        accountRepository.save(account);
    }
}
