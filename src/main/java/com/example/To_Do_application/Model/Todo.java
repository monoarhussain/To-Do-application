package com.example.To_Do_application.Model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data // Lombok generates getters/setters
@NoArgsConstructor
@AllArgsConstructor
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is required")
    @Size(min = 3, max = 100)
    private String title;
    private String description;
    private boolean completed;
    private LocalDate dueDate;
    private boolean deleted = false;

    public enum Priority {
        LOW, MEDIUM, HIGH
    }

    @Enumerated(EnumType.STRING)
    private Priority priority;
    private String userId; // For simplicity, just store user id
    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

}
