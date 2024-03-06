package com.mendax47.springboot.projects.trainingcenter.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
            mappedBy = "supervisedBy",
            cascade = CascadeType.PERSIST
    )
    private List<Trainer> trainers;
    @ManyToOne(
            cascade = CascadeType.PERSIST
    )
    @JoinColumn
    private Director supervisedBy;
}