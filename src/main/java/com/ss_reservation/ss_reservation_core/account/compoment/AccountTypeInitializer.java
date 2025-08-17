package com.ss_reservation.ss_reservation_core.account.compoment;


import com.ss_reservation.ss_reservation_core.account.entity.AccountType;
import com.ss_reservation.ss_reservation_core.account.repository.AccountTypeRepository;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountTypeInitializer {

    public final String ownerKey = "owner";
    public final String staffKey = "staff";
    public final String playerKey = "player";

    @Autowired
    AccountTypeRepository accountTypeRepository;

    @PostConstruct
    @Transactional
    public void initData() {

        if(!accountTypeRepository.existsByKey(ownerKey)){
            AccountType accountType = new AccountType(ownerKey, String.format("%s.%s", "createAccount.accountType", ownerKey));
            accountTypeRepository.save(accountType);
        }

        if(!accountTypeRepository.existsByKey(staffKey)){
            AccountType accountType = new AccountType(staffKey, String.format("%s.%s", "createAccount.accountType", staffKey));
            accountTypeRepository.save(accountType);
        }

        if(!accountTypeRepository.existsByKey(playerKey)){
            AccountType accountType = new AccountType(playerKey, String.format("%s.%s", "createAccount.accountType", playerKey));
            accountTypeRepository.save(accountType);
        }
    }
}
