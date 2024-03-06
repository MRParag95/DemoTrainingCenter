package com.mendax47.springboot.projects.trainingcenter.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
public class Course {
    @Id
    @SequenceGenerator(
            name = "course_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_id_sequence"
    )
    private Long id;
    @Column(
            nullable = false
    )
    private String name;
    @Column(
            nullable = false
    )
    private int duration;
    @ManyToMany(
            mappedBy = "courses",
            cascade = CascadeType.ALL
    )
    @JsonBackReference
    private List<Trainee> trainees;
}