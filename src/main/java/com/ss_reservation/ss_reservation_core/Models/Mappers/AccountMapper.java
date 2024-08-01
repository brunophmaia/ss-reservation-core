package com.ss_reservation.ss_reservation_core.Models.Mappers;

import com.ss_reservation.ss_reservation_core.Entities.Account;
import com.ss_reservation.ss_reservation_core.Models.AccountModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.mapstruct.Mapping;

@Mapper
public interface AccountMapper {
    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    @Mapping(target = "password", ignore = true)
    Account toEntity(AccountModel accountModel);

    //AccountModel toModel(Account account);
}