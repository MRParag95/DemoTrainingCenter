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
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Coordinator supervisedBy;
    @OneToMany(mappedBy = "supervisedBy", cascade = CascadeType.ALL)
    private Set<Trainee> trainees;
}