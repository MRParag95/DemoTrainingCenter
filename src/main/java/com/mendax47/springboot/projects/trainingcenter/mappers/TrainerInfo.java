package com.mendax47.springboot.projects.trainingcenter.mappers;

import java.time.LocalDateTime;
import java.util.Set;

/**
 * Projection for {@link com.mendax47.springboot.projects.trainingcenter.models.Trainer}
 */
public interface TrainerInfo {
    String getFirstName();

    String getLastName();

    String getUsername();

    String getEmail();

    LocalDateTime getCreatedAt();

    LocalDateTime getUpdatedAt();

    Long getId();

    CoordinatorInfo getSupervisedBy();

    Set<TraineeInfo1> getTrainees();

    /**
     * Projection for {@link com.mendax47.springboot.projects.trainingcenter.models.Coordinator}
     */
    interface CoordinatorInfo {
        String getFirstName();

        String getLastName();

        String getUsername();

        String getEmail();

        LocalDateTime getCreatedAt();

        LocalDateTime getUpdatedAt();

        Long getId();
    }

    /**
     * Projection for {@link com.mendax47.springboot.projects.trainingcenter.models.Trainee}
     */
    interface TraineeInfo1 {
        String getFirstName();

        String getLastName();

        String getUsername();

        String getEmail();

        LocalDateTime getCreatedAt();

        LocalDateTime getUpdatedAt();

        Long getId();
    }
}