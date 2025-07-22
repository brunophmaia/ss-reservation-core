package com.ss_reservation.ss_reservation_core.account.service;

import com.ss_reservation.ss_reservation_core.account.mapper.UserMapper;
import com.ss_reservation.ss_reservation_core.account.model.Account;
import com.ss_reservation.ss_reservation_core.account.model.UserInfoDTO;
import com.ss_reservation.ss_reservation_core.account.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private AccountRepository accountRepository;

    public UserInfoDTO getUserInfo(){
        Account account = accountRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
        return UserMapper.INSTANCE.toModel(account);
    }
}
