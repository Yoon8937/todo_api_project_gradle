package com.example.todo.dto;

import com.example.todo.domain.Todo;

import java.time.OffsetDateTime;

public class TodoResponse {

    private final Long id;
    private final String title;
    private final String description;
    private final boolean completed;
    private final OffsetDateTime createdAt;
    private final OffsetDateTime updatedAt;

    private TodoResponse(Long id, String title, String description, boolean completed,
                         OffsetDateTime createdAt, OffsetDateTime updatedAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.completed = completed;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static TodoResponse from(Todo todo) {
        return new TodoResponse(
                todo.getId(),
                todo.getTitle(),
                todo.getDescription(),
                todo.isCompleted(),
                todo.getCreatedAt(),
                todo.getUpdatedAt()
        );
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }
}
