package com.mendax47.springboot.projects.trainingcenter.mappers;

import java.time.LocalDateTime;
import java.util.Set;

/**
 * Projection for {@link com.mendax47.springboot.projects.trainingcenter.models.Trainee}
 */
public interface TraineeInfo {
    String getFirstName();

    String getLastName();

    String getUsername();

    String getEmail();

    LocalDateTime getCreatedAt();

    LocalDateTime getUpdatedAt();

    Long getId();

    TrainerInfo getSupervisedBy();

    Set<CourseInfo1> getCourses();

    /**
     * Projection for {@link com.mendax47.springboot.projects.trainingcenter.models.Trainer}
     */
    interface TrainerInfo {
        String getFirstName();

        String getLastName();

        String getUsername();

        String getEmail();

        LocalDateTime getCreatedAt();

        LocalDateTime getUpdatedAt();

        Long getId();
    }

    /**
     * Projection for {@link com.mendax47.springboot.projects.trainingcenter.models.Course}
     */
    interface CourseInfo1 {
        Long getId();

        String getName();

        int getDuration();
    }
}