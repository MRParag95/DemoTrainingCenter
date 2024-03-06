package com.mendax47.springboot.projects.trainingcenter.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

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
    @ManyToMany(
            cascade = CascadeType.ALL
    )
    @JoinTable(
            joinColumns = {
                    @JoinColumn(name = "trainee_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "course_id")
            }
    )
    @JsonManagedReference
    private List<Course> courses;
    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn
    @JsonBackReference
    private Trainer supervisedBy;
}