package com.mendax47.springboot.projects.trainingcenter.models;

import jakarta.persistence.Column;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Employee {
    @Column(
            nullable = false
    )
    private String firstName;
    @Column(
            nullable = false
    )
    private String lastName;
    @Column(
            nullable = false,
            unique = true
    )
    private String username;
    @Column(
            nullable = false,
            unique = true
    )
    private String email;
    @CreationTimestamp
    @Column(
            updatable = false
    )
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}