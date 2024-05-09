package org.blitmatthew.bankjdbc.controller;

import lombok.RequiredArgsConstructor;
import org.blitmatthew.bankjdbc.annotation.LogExecutionTime;
import org.blitmatthew.bankjdbc.dto.PostNewUser;
import org.blitmatthew.bankjdbc.dto.User;
import org.blitmatthew.bankjdbc.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    protected final UserService userService;

    @PostMapping("/")
    @LogExecutionTime
    public ResponseEntity<User> createUser(@RequestBody PostNewUser postNewUser) {
        return new ResponseEntity<>(userService.createUser(postNewUser), HttpStatus.CREATED);
    }
}
