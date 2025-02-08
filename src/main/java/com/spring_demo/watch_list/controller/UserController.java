package com.spring_demo.watch_list.controller;

import com.spring_demo.watch_list.dto.UserRequest;
import com.spring_demo.watch_list.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // Add User
    @PostMapping
    public ResponseEntity<String> addUser(@RequestBody UserRequest userRequest){
        userService.addUser(userRequest.getUsername(),userRequest.getPassword(),true);
        return ResponseEntity.ok("User has been added successfully");
    }

    // List All user
    @GetMapping
    public ResponseEntity<List<String>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @DeleteMapping("/disable/{username}")
    public ResponseEntity<String> disableUser(@PathVariable String username) {
        userService.disableUser(username);
        return ResponseEntity.ok("User has been disabled successfully.");
    }

    @DeleteMapping("/enable/{username}")
    public ResponseEntity<String> enableUser(@PathVariable String username) {
        userService.enableUser(username);
        return ResponseEntity.ok("User has been enabled successfully.");
    }

}
