package com.example.taskservice.controller;

import com.example.taskservice.dto.request.ProjectCreateRequestDto;
import com.example.taskservice.dto.response.ProjectCreateResponseDto;
import com.example.taskservice.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import java.util.UUID;

@RequestMapping("/projects")
@RequiredArgsConstructor
@RestController
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping
    public ResponseEntity<ProjectCreateResponseDto> create(
            @Valid @RequestBody ProjectCreateRequestDto projectCreateRequestDto,
            @AuthenticationPrincipal UUID ownerId
    ) {
        ProjectCreateResponseDto project = projectService.create(projectCreateRequestDto, ownerId);

        return ResponseEntity.status(201)
                .body(project);
    }
}
