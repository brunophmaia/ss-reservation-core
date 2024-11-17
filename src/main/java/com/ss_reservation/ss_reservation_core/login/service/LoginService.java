package com.ss_reservation.ss_reservation_core.login.service;

import com.ss_reservation.ss_reservation_core.account.validation.AccountValidation;
import com.ss_reservation.ss_reservation_core.common.exception.CustomGeneralException;
import com.ss_reservation.ss_reservation_core.login.model.LoginDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class LoginService {

    @Value("${account.url}")
    private String accountUrl;

    public void login(LoginDTO login){

        WebClient client = WebClient.builder()
                .baseUrl(accountUrl)
                .build();

        Mono<Boolean> result = client.get()
                        .uri(uriBuilder -> uriBuilder
                        .path("/checkUser")
                        .queryParam("username", login.getUsername())
                        .queryParam("password", login.getPassword())
                        .build())
                .retrieve().bodyToMono(Boolean.class);

        Boolean credentialsResult = result.block();

        if(credentialsResult != null && !credentialsResult) {
            throw new CustomGeneralException("login.invalidCredentials");
        }
    }
}
