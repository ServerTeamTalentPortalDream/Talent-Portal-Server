package com.revature;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class AppConfig {
    @Value(value = "${com.auth0.domain}")
    private String domain;

    @Value(value = "${com.auth0.clientId}")
    private String clientId;

    @Value(value = "${com.auth0.clientSecret}")
    private String clientSecret;
}