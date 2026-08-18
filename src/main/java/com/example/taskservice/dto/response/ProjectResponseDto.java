package com.example.taskservice.dto.response;

import java.util.List;
import java.util.UUID;

public record ProjectResponseDto(
        UUID ownerId,

        List<ProjectSummaryResponseDto> projects
) {
}
