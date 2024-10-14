package com.localtym.account_core.controller;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@PropertySource({"classpath:config/persistence-multiple-db.properties"})
public class AccountController {
    // Injecting value with the @Value annotaion
    @Value("${spring.application.name}")
    String app_name;

    //Fetching property values from the Spring Boot Environment
    @Autowired
    private Environment env;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(@RequestParam(defaultValue = "User") String param) {
        String app_nm = env.getProperty("spring.application.name");
        String app_nm2 = env.getProperty("account.datasource.name");
        return String.format("Welcome %s", app_name + " " + app_nm + " " + app_nm2);
    }

}
