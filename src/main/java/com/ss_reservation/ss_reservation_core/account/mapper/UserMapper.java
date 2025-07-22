package com.ss_reservation.ss_reservation_core.account.mapper;

import com.ss_reservation.ss_reservation_core.account.model.Account;
import com.ss_reservation.ss_reservation_core.account.model.UserInfoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "name", source = ".", qualifiedByName = "concatenateName")
    UserInfoDTO toModel(Account account);

    @Named("concatenateName")
    default String concatenateName(Account account) {
        if (account.getName() == null && account.getLastName() == null) {
            return null;
        }

        String firstName = account.getName() != null ? account.getName() : "";
        String lastName = account.getLastName() != null ? account.getLastName() : "";

        return (firstName + " " + lastName).trim();
    }
}
