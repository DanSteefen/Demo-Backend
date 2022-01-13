package com.example.demo.demo.controller;

import com.example.demo.demo.model.Experience;
import com.example.demo.demo.service.ExperienceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/experiences")
public class ExperienceController {

    private ExperienceService experienceService;

    public ExperienceController(ExperienceService experienceService) {
        this.experienceService = experienceService;
    }

    @PostMapping()
    public ResponseEntity<Experience> saveExperience(@RequestBody Experience experience){
        return new ResponseEntity<>(experienceService.saveExperience(experience), HttpStatus.CREATED);
    }

    @GetMapping()
    public List<Experience> getAllExperiences(){
        return experienceService.getAllExperience();
    }

    @RequestMapping("{id}")
    public ResponseEntity<Experience> getExperienceByID(@PathVariable("id") long expId){
        return new ResponseEntity<Experience>(experienceService.getExperienceById(expId), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Experience> updateExperience(@PathVariable("id") long id, @RequestBody Experience experience){
        return new ResponseEntity<Experience>(experienceService.updateExperience(experience, id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteExperience(@PathVariable("id") long id){
        experienceService.deleteExperience(id);

        return new ResponseEntity<String>("Experience deleted successfully!.", HttpStatus.OK);
    }
}
