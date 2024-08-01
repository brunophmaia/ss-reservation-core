package com.ss_reservation.ss_reservation_core.Services;

import com.ss_reservation.ss_reservation_core.Entities.Account;
import com.ss_reservation.ss_reservation_core.Models.Mappers.AccountMapper;
import com.ss_reservation.ss_reservation_core.Repository.AccountRepository;
import com.ss_reservation.ss_reservation_core.Models.AccountModel;
import com.ss_reservation.ss_reservation_core.Services.Interfaces.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public void createUser(AccountModel accountModel){

        Account account = AccountMapper.INSTANCE.toEntity(accountModel);

        accountRepository.save(account);
    }
}
