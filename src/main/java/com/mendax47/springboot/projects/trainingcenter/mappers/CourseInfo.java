package com.mendax47.springboot.projects.trainingcenter.mappers;

import java.time.LocalDateTime;
import java.util.Set;

/**
 * Projection for {@link com.mendax47.springboot.projects.trainingcenter.models.Course}
 */
public interface CourseInfo {
    Long getId();

    String getName();

    int getDuration();

    Set<TraineeInfo> getTrainees();

    /**
     * Projection for {@link com.mendax47.springboot.projects.trainingcenter.models.Trainee}
     */
    interface TraineeInfo {
        String getFirstName();

        String getLastName();

        String getUsername();

        String getEmail();

        LocalDateTime getCreatedAt();

        LocalDateTime getUpdatedAt();

        Long getId();
    }
}