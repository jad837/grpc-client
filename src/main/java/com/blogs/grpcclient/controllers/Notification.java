package com.blogs.grpcclient.controllers;

import com.blogs.grpcclient.clients.UserServiceClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class Notification {

    UserServiceClient userServiceClient;

    public Notification(UserServiceClient userServiceClient) {
        this.userServiceClient = userServiceClient;
    }

    @GetMapping(path = "/notify")
    public void notify(@RequestParam Long id) {
        var user = userServiceClient.getUser(id);
        log.info("Notification sent to user : {} on email address : {} ", user.getName(), user.getEmail());
    }

}
