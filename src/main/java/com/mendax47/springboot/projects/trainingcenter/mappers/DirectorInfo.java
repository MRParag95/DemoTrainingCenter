package com.mendax47.springboot.projects.trainingcenter.mappers;

import java.time.LocalDateTime;
import java.util.Set;

/**
 * Projection for {@link com.mendax47.springboot.projects.trainingcenter.models.Director}
 */
public interface DirectorInfo {
    String getFirstName();

    String getLastName();

    String getUsername();

    String getEmail();

    LocalDateTime getCreatedAt();

    LocalDateTime getUpdatedAt();

    Long getId();

    Set<CoordinatorInfo> getCoordinators();

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
}