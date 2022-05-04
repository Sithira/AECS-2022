package me.sithiramunasinghe.services.exchangeservice;

import me.sithiramunasinghe.services.exchangeservice.config.RestTemplateInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@SpringBootApplication
public class DexExchangeServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(DexExchangeServiceApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        restTemplateBuilder.interceptors(Collections.singleton(new RestTemplateInterceptor()));

        RestTemplate restTemplate = restTemplateBuilder.build();
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        clientHttpRequestFactory.setBufferRequestBody(false);
        BufferingClientHttpRequestFactory bufferingClientHttpRequestFactory = new BufferingClientHttpRequestFactory(clientHttpRequestFactory);

        restTemplate.setRequestFactory(bufferingClientHttpRequestFactory);

        return restTemplate;
    }
}
