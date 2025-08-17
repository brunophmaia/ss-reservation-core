package com.ss_reservation.ss_reservation_core.account.mapper;

import com.ss_reservation.ss_reservation_core.account.entity.Account;
import com.ss_reservation.ss_reservation_core.account.model.AccountDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.mapstruct.Mapping;

@Mapper
public interface AccountMapper {
    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    @Mapping(target = "password", ignore = true)
    Account toEntity(AccountDTO accountDTO);

    //AccountModel toModel(Account account);
}