package com.example.demo.controller;

import com.example.demo.dao.UserAccountRepository;
import com.example.demo.entity.UserAccount;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping
public class UserController {

    @Autowired
    UserAccountRepository userAccountRepository;

    @GetMapping("/v1/account")
    public UserAccount getUserAccount(@RequestHeader("OAuth-User-Name") String userName, @RequestHeader("OAuth-User-Email") String email) {

        log.info("Getting UserAccount by userName:[{}]", userName);

        return userAccountRepository.loadByPrimaryKeyAndSortKey(userName, email).orElse(null);
    }
}
