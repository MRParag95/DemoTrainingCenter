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
public class Coordinator extends Employee {
    @Id
    @SequenceGenerator(
            name = "coordinator_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "coordinator_id_sequence"
    )
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Director supervisedBy;
    @OneToMany(mappedBy = "supervisedBy", cascade = CascadeType.ALL)
    private Set<Trainer> trainers = new HashSet<>();
}