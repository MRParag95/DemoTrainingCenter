package com.mendax47.springboot.projects.trainingcenter.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @OneToMany(
            mappedBy = "supervisedBy"
    )
    private List<Trainee> trainees;
    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn
    @JsonBackReference
    private Director supervisedBy;
}