package com.mendax47.springboot.projects.trainingcenter.controllers;

import com.mendax47.springboot.projects.trainingcenter.mappers.DirectorInfo;
import com.mendax47.springboot.projects.trainingcenter.models.Director;
import com.mendax47.springboot.projects.trainingcenter.services.DirectorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/directors")
public class DirectorController {
    private final DirectorService directorService;

    @PostMapping
    public ResponseEntity<Director> createDirector(@RequestBody Director director) {
        return new ResponseEntity<>(this.directorService.createDirector(director), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Set<DirectorInfo>> getAllDirectors() {
        return new ResponseEntity<>(this.directorService.getAllDirectors(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Director> getDirectorById(@PathVariable Long id) {
        return ResponseEntity.ok(this.directorService.getDirectorById(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<Director> updateDirector(@PathVariable Long id, @RequestBody Director director) {
        return ResponseEntity.ok(this.directorService.updateDirector(id, director));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteDirector(@PathVariable Long id) {
        return ResponseEntity.ok(this.directorService.deleteDirector(id));
    }
}