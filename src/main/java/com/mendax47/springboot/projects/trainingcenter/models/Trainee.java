package com.mendax47.springboot.projects.trainingcenter.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

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
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinTable(
            joinColumns = {
                    @JoinColumn(name = "trainee_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "course_id")
            }
    )
    private Set<Course> courses;
}