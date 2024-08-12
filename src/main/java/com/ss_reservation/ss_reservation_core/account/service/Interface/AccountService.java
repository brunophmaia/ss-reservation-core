package com.ss_reservation.ss_reservation_core.account.service.Interface;

import com.ss_reservation.ss_reservation_core.account.model.AccountDTO;

public interface AccountService {
    void createUser(AccountDTO accountDTO);
    void sendEmailCode(String email);
}