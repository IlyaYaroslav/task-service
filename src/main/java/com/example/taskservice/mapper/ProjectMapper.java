package com.example.taskservice.mapper;

import com.example.taskservice.dto.request.ProjectCreateRequestDto;
import com.example.taskservice.dto.response.ProjectCreateResponseDto;
import com.example.taskservice.dto.response.ProjectResponseDto;
import com.example.taskservice.dto.response.ProjectSummaryResponseDto;
import com.example.taskservice.entity.Project;
import com.example.taskservice.model.ProjectMemberDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProjectMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "ownerId", ignore = true)
    @Mapping(target = "memberIds", source = "projectMembers")
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Project toEntity(ProjectCreateRequestDto projectCreateRequestDto);

    @Mapping(target = "members", source = "memberIds")
    ProjectCreateResponseDto toDto(Project project);


    @Mapping(target = "ownerId", source = "ownerId")
    @Mapping(target = "projects", source = "projects")
    ProjectResponseDto toDto(UUID ownerId, List<Project> projects);

    ProjectSummaryResponseDto toSummaryDto(Project project);

    default ProjectMemberDto toMemberDto(UUID userId) {
        return new ProjectMemberDto(userId);
    }
}
