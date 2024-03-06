package com.mendax47.springboot.projects.trainingcenter.services;

import com.mendax47.springboot.projects.trainingcenter.models.Director;
import com.mendax47.springboot.projects.trainingcenter.repository.DirectorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class DirectorService {
    private final DirectorRepository directorRepository;

    public Director createDirector(Director director) {
        return this.directorRepository.save(director);
    }

    public List<Director> getAllDirectors() {
        return this.directorRepository.findAll();
    }

    public Director getDirectorById(Long id) {
        return this.directorRepository.findById(id).orElseThrow();
    }

    public Director updateDirector(Long id, Director director) throws RuntimeException {
        Director foundDirector = this.getDirectorById(id);

        foundDirector.setFirstName(director.getFirstName());
        foundDirector.setLastName(director.getLastName());
        foundDirector.setUsername(director.getUsername());
        foundDirector.setEmail(director.getEmail());

        foundDirector.setCoordinators(director.getCoordinators());

        return this.directorRepository.save(foundDirector);
    }

    public String deleteDirector(Long id) {
        this.directorRepository.deleteById(id);

        return "Director Deleted Successfully.";
    }
}