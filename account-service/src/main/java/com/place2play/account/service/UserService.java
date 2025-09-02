package com.place2play.account.service;

import com.place2play.account.entity.Account;
import com.place2play.account.model.dto.UserInfoDTO;
import com.place2play.account.model.mapper.UserMapper;
import com.place2play.account.repository.AccountRepository;
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
