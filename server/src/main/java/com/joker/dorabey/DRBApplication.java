package com.joker.dorabey;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication(scanBasePackages = {
        "com.joker.dorabey.config",
        "com.joker.dorabey.controller",
        "com.joker.dorabey.service",
        "com.joker.dorabey.annotation.handler"
})
@Slf4j
public class DRBApplication {

    public static ApplicationContext ctx;

    public static void main(String[] args) {
        SpringApplication.run(DRBApplication.class, args);
//        Application.launch(FXApplication.class, args);
    }

}
