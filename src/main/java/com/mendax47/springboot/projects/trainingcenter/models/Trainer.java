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
public class Trainer extends Employee {
    @Id
    @SequenceGenerator(
            name = "trainer_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "trainer_id_sequence"
    )
    private Long id;
    @OneToMany(
            mappedBy = "supervisedBy",
            cascade = CascadeType.ALL
    )
    @JsonManagedReference
    private List<Trainee> trainees;
    @ManyToOne
    @JoinColumn
    @JsonBackReference
    private Coordinator supervisedBy;
}