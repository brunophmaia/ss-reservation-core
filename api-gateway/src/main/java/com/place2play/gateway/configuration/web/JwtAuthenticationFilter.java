package com.place2play.gateway.configuration.web;

import com.place2play.gateway.configuration.properties.ApplicationProperties;
import com.place2play.gateway.configuration.service.JwtTokenClientUtil;
import com.place2play.gateway.configuration.service.JwtTokenServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpCookie;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class JwtAuthenticationFilter implements GlobalFilter, Ordered {

    @Autowired
    JwtTokenServiceUtil jwtTokenServiceUtil;

    @Autowired
    JwtTokenClientUtil jwtTokenClientUtil;

    @Autowired
    private ApplicationProperties properties;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        boolean validReq = false;
        String path = exchange.getRequest().getPath().toString();
        String clientToken = "";

        if(properties.getAllowedPaths().stream().anyMatch(path::startsWith)) {
            validReq = true;
        }

        try {
            String authHeader = exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION);

            if (authHeader != null && authHeader.startsWith("Bearer ")) {

                String token = authHeader.substring(7);
                if (jwtTokenServiceUtil.isValidToken(token)) {
                    validReq = true;
                }
            }

            HttpCookie cookie = exchange.getRequest().getCookies().getFirst("token");
            if (cookie != null && jwtTokenClientUtil.isValidToken(cookie.getValue())) {
                clientToken = cookie.getValue();
                validReq = true;
            }
        } catch (Exception ex) {
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }

        if(validReq) {
            String finalClientToken = clientToken;
            ServerWebExchange mutatedExchange = exchange.mutate()
                    .request(request -> request.headers(httpHeaders -> {

                        if(!finalClientToken.isEmpty()) {
                            httpHeaders.add("X-Client-Token", finalClientToken);
                        }

                        httpHeaders.add("X-Service-Token", jwtTokenServiceUtil.generateToken());
                        httpHeaders.set("Content-Type", "application/json");
                    }))
                    .build();

            return chain.filter(mutatedExchange);
        }
        else {
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }

    }

    @Override
    public int getOrder() {
        return -1;
    }
}