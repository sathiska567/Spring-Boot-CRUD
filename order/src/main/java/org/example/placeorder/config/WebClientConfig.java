package org.example.placeorder.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

//create file as config file
@Configuration
public class WebClientConfig {
    @Bean
    public WebClient webClient(){
        return WebClient.builder().build();
    }

    @Bean
    public WebClient inventoryWebClient(){
        return WebClient.builder().baseUrl("http://localhost:8080/api/v1").build();
    }

    @Bean
    public WebClient productWebClient(){
        return WebClient.builder().baseUrl("http://localhost:8082/api/v1").build();
    }
}

