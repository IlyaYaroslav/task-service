package com.example.taskservice.dto.request;

import lombok.Builder;

import java.util.List;
import java.util.UUID;

@Builder
public record ProjectCreateRequestDto(
        String name,
        String description,
        String key,
        List<UUID> projectMembers
) {
}
