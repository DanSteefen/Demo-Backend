package com.example.demo.demo.service;


import com.example.demo.demo.model.Experience;

import java.util.List;

public interface ExperienceService {
    Experience saveExperience(Experience experience);

    List<Experience> getAllExperience();

    Experience getExperienceById(long id);

    Experience updateExperience(Experience experience, long id);

    void deleteExperience(long id);
}
