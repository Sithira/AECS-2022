package me.sithiramunasinghe.dex.foundation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class DexApiGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(DexApiGatewayApplication.class, args);
    }
}
