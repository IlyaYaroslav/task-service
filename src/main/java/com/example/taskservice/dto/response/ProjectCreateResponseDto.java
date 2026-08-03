package com.example.taskservice.dto.response;

import com.example.taskservice.model.ProjectMemberDto;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public record ProjectCreateResponseDto(
        UUID id,
        String name,
        String key,
        String description,
        List<ProjectMemberDto> members,
        Instant createdAt,
        Instant updatedAt

) {
}
