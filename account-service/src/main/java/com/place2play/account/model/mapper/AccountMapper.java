package com.place2play.account.model.mapper;

import com.place2play.account.entity.Account;
import com.place2play.account.model.dto.AccountDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AccountMapper {
    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    @Mapping(target = "password", ignore = true)
    Account toEntity(AccountDTO accountDTO);
}