package com.example.taskservice.service;

import com.example.taskservice.dto.request.ProjectCreateRequestDto;
import com.example.taskservice.dto.response.ProjectCreateResponseDto;
import com.example.taskservice.mapper.ProjectMapper;
import com.example.taskservice.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    @Transactional
    public ProjectCreateResponseDto create(ProjectCreateRequestDto projectCreateRequestDto) {

        return projectMapper.toDto(projectRepository.save(projectMapper.toEntity(projectCreateRequestDto)));
    }

}
