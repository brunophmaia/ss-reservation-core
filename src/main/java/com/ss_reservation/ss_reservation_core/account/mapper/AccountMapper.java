package com.ss_reservation.ss_reservation_core.account.mapper;

import com.ss_reservation.ss_reservation_core.account.entity.Account;
import com.ss_reservation.ss_reservation_core.account.entity.AccountType;
import com.ss_reservation.ss_reservation_core.account.model.AccountDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.mapstruct.Mapping;

@Mapper
public interface AccountMapper {
    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    @Mapping(target = "password", ignore = true)
    Account toEntity(AccountDTO accountDTO);

    @Named("idToAccountType")
    default AccountType idToAccountType(Long accountTypeId) {
        if (accountTypeId == null) {
            return null;
        }
        AccountType accountType = new AccountType();
        accountType.setId(accountTypeId);
        return accountType;
    }

    //AccountModel toModel(Account account);
}