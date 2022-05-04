package me.sithiramunasinghe.dex.foundation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class DexDiscoveryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DexDiscoveryServiceApplication.class, args);
    }

}
