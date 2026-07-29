package com.example.taskservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;


@Getter
@Setter
@Table
@Entity
public class Project {

    @Id
    private UUID id;

    private UUID ownerId;
    private String name;
    private String description;
}
