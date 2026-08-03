package com.example.taskservice.dto.response;

import java.util.UUID;

public record UserSummaryResponseDto(
        UUID id,
        String firstName,
        String lastName
) {
}
