package com.example.demo.demo.service.serviceImple;

import com.example.demo.demo.exception.ResourceNotFoundException;
import com.example.demo.demo.model.Experience;
import com.example.demo.demo.repository.ExperienceRepository;
import com.example.demo.demo.service.ExperienceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienceServiceImpl implements ExperienceService {

    private ExperienceRepository experienceRepository;

    public ExperienceServiceImpl(ExperienceRepository experienceRepository) {
        this.experienceRepository = experienceRepository;
    }

    @Override
    public Experience saveExperience(Experience experience) {
        return experienceRepository.save(experience);
    }

    @Override
    public List<Experience> getAllExperience() {
        return experienceRepository.findAll();
    }

    @Override
    public Experience getExperienceById(long id) {
        return experienceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Experience", "Id", id));
    }

    @Override
    public Experience updateExperience(Experience experience, long id) {
        Experience currentExperience = experienceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Experience", "Id", id));

        currentExperience.setExperienceType(experience.getExperienceType());
        currentExperience.setExperienceYear(experience.getExperienceYear());
        currentExperience.setExperienceDescription(experience.getExperienceDescription());

        experienceRepository.save(currentExperience);
         return currentExperience;
    }

    @Override
    public void deleteExperience(long id) {
        experienceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Experience", "Id", id));

        experienceRepository.deleteById(id);

    }
}
