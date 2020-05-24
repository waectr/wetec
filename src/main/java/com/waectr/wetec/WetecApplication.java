package com.waectr.wetec;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.waectr.wetec"})
@MapperScan("com.waectr.wetec.dao")
public class WetecApplication {

    public static void main(String[] args) {
        SpringApplication.run(WetecApplication.class, args);
    }

}
