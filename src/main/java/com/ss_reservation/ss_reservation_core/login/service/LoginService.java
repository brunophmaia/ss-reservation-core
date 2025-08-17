package com.ss_reservation.ss_reservation_core.login.service;

import com.ss_reservation.ss_reservation_core.common.exception.CustomGeneralException;
import com.ss_reservation.ss_reservation_core.login.model.LoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class LoginService {

    @Value("${account.url}")
    private String accountUrl;

    @Autowired
    private JwtUtil jwtUtil;

    public String login(LoginDTO login){

        WebClient client = WebClient.builder()
                .baseUrl(accountUrl)
                .build();

        Mono<Long> result = client.get()
                        .uri(uriBuilder -> uriBuilder
                        .path("/checkUser")
                        .queryParam("username", login.getUsername())
                        .queryParam("password", login.getPassword())
                        .build())
                .retrieve().bodyToMono(Long.class);

        Long credentialsResult = result.block();

        if(credentialsResult == null) {
            throw new CustomGeneralException("login.invalidCredentials");
        }

        return jwtUtil.generateToken(login.getUsername(), credentialsResult);
    }
}
