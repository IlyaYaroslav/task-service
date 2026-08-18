package com.example.taskservice.repository;


import com.example.taskservice.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface ProjectRepository extends JpaRepository<Project, UUID> {
    boolean existsByKeyIgnoreCase(String key);

//    @Query()
    List<Project> findProjectsByOwnerId(UUID ownerId);
}
