package com.example.taskservice.controller;

import com.example.taskservice.client.UserServiceClient;
import com.example.taskservice.dto.response.UserSummaryResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserServiceClient userServiceClient;

    @GetMapping
    public List<UserSummaryResponseDto> getAllUsers() {
        return userServiceClient.getAllUsers();
    }
}
