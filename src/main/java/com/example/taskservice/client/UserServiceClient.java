package com.example.taskservice.client;

import com.example.taskservice.dto.response.UserSummaryResponseDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.List;

@Component
public class UserServiceClient {

    private static final ParameterizedTypeReference<List<UserSummaryResponseDto>> USER_LIST_TYPE =
            new ParameterizedTypeReference<>() { };

    private final RestClient restClient;

    public UserServiceClient(
            @Value("${services.user-service.url:http://user-service:8081/api/user-service}") String baseUrl
    ) {
        this.restClient = RestClient.create(baseUrl);
    }

    public List<UserSummaryResponseDto> getAllUsers() {
        List<UserSummaryResponseDto> users = restClient.get()
                .uri("/users")
                .retrieve()
                .body(USER_LIST_TYPE);
        return users == null ? List.of() : users;
    }
}
