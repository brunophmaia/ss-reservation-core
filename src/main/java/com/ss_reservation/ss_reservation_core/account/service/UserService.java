package com.ss_reservation.ss_reservation_core.account.service;

import com.ss_reservation.ss_reservation_core.account.mapper.UserMapper;
import com.ss_reservation.ss_reservation_core.account.entity.Account;
import com.ss_reservation.ss_reservation_core.account.model.UserInfoDTO;
import com.ss_reservation.ss_reservation_core.account.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private AccountRepository accountRepository;

    public UserInfoDTO getUserInfo(){
        Optional<Account> account = accountRepository.findById((Long) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return account.isPresent() ? UserMapper.INSTANCE.toModel(account.get()) : null;
    }
}
