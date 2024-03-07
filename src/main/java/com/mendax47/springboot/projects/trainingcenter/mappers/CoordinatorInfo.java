package com.mendax47.springboot.projects.trainingcenter.mappers;

import java.time.LocalDateTime;
import java.util.Set;

/**
 * Projection for {@link com.mendax47.springboot.projects.trainingcenter.models.Coordinator}
 */
public interface CoordinatorInfo {
    String getFirstName();

    String getLastName();

    String getUsername();

    String getEmail();

    LocalDateTime getCreatedAt();

    LocalDateTime getUpdatedAt();

    Long getId();

    DirectorInfo getSupervisedBy();

    Set<TrainerInfo1> getTrainers();

    /**
     * Projection for {@link com.mendax47.springboot.projects.trainingcenter.models.Director}
     */
    interface DirectorInfo {
        String getFirstName();

        String getLastName();

        String getUsername();

        String getEmail();

        LocalDateTime getCreatedAt();

        LocalDateTime getUpdatedAt();

        Long getId();
    }

    /**
     * Projection for {@link com.mendax47.springboot.projects.trainingcenter.models.Trainer}
     */
    interface TrainerInfo1 {
        String getFirstName();

        String getLastName();

        String getUsername();

        String getEmail();

        LocalDateTime getCreatedAt();

        LocalDateTime getUpdatedAt();

        Long getId();
    }
}