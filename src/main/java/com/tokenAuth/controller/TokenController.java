package com.tokenAuth.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tokenAuth.service.CustomerService;

@RestController
public class TokenController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/token")
    public String getToken(@RequestParam("username") final String username, @RequestParam("password") final String password){
       String token= customerService.login(username,password);
       if(StringUtils.isEmpty(token)){
           return "no token found";
       }
       return token;
    }
}