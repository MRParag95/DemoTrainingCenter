package com.mendax47.springboot.projects.trainingcenter.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
public class Trainee extends Employee {
    @Id
    @SequenceGenerator(
            name = "trainee_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "trainee_id_sequence"
    )
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Trainer supervisedBy;
    @ManyToMany(mappedBy = "trainees", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Set<Course> courses = new HashSet<>();
}