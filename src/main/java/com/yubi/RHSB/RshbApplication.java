package com.yubi.RHSB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
@ComponentScan(basePackages ="com.yubi.RHSB.*")
public class RshbApplication {

    public static void main(String[] args) {
        SpringApplication.run(RshbApplication.class, args);
    }

}

