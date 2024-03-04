package com.mendax47.springboot.projects.trainingcenter.models;

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
public class Director extends Employee {
    @Id
    @SequenceGenerator(
            name = "director_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "director_id_sequence"
    )
    private Long id;
    @OneToMany(
            mappedBy = "supervisedBy"
    )
    private List<Coordinator> coordinators;
}