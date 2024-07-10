package com.ss_reservation.ss_reservation_core.Services;

import com.ss_reservation.ss_reservation_core.Models.UserModel;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public UserModel getUser(Long id){
        return new UserModel("Bruno Maia", "bruno@gmail.com", id);
    }
}
