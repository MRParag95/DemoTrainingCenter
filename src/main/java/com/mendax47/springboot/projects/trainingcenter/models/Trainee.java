package com.mendax47.springboot.projects.trainingcenter.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

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
            name = "trainer_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "trainer_id_sequence"
    )
    private Long id;
}