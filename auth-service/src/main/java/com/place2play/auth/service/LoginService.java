package com.place2play.auth.service;

import com.place2play.auth.configuration.exception.CustomGeneralException;
import com.place2play.auth.model.LoginDTO;
import com.place2play.auth.security.JwtTokenClientUtil;
import com.place2play.auth.security.JwtTokenServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class LoginService {

    @Value("${gateway.url}")
    private String accountUrl;

    @Autowired
    private JwtTokenClientUtil jwtTokenClientUtil;

    @Autowired
    private JwtTokenServiceUtil jwtTokenServiceUtil;

    public String login(LoginDTO login){

        String serviceToken = jwtTokenServiceUtil.generateToken();

        WebClient client = WebClient.builder()
                .baseUrl(accountUrl)
                .defaultHeader("Authorization", String.format("Bearer %s", serviceToken))
                .build();

        Mono<Long> result = client.get()
                        .uri(uriBuilder -> uriBuilder
                        .path("/account/checkUser")
                        .queryParam("username", login.getUsername())
                        .queryParam("password", login.getPassword())
                        .build())
                .retrieve().bodyToMono(Long.class);

        Long credentialsResult = result.block();

        if(credentialsResult == null) {
            throw new CustomGeneralException("login.invalidCredentials");
        }

        return jwtTokenClientUtil.generateToken(credentialsResult.toString());
    }
}
