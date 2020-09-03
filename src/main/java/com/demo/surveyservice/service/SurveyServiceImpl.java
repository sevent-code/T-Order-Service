/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.surveyservice.service;

import com.demo.surveyservice.exception.MyResourceException;
import com.demo.surveyservice.model.Survey;
import com.demo.surveyservice.model.Surveyor;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import java.util.Optional;
import com.demo.surveyservice.repository.SurveyRepository;

/**
 *
 * @author Steven Raylianto K.
 */
@Service
public class SurveyServiceImpl implements SurveyService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private SurveyRepository surveyRepository;

    @Override
    public Survey createSurvey(Survey survey) {
        return surveyRepository.save(survey);
    }

    @Override
    public Survey updateSurvey(Long id, Survey survey) {
        return surveyRepository.findById(id).map(order -> {
            order.setDescription(survey.getDescription());
            order.setLatitude(survey.getLatitude());
            order.setLongitude(survey.getLongitude());
            return surveyRepository.save(order);
        }).orElseThrow(() -> new MyResourceException("Error when update survey with id " + id));

    }

    @Override
    public void deleteSurvey(Long id) {
        Optional<Survey> optSurvey = surveyRepository.findById(id);
        Survey survey = optSurvey.get();
        surveyRepository.delete(survey);
    }

    @Override
    public List<Survey> getSurveys(Long surveyorId) {
        Surveyor surveyor = restTemplate.getForObject("http://surveyor-service/surveyor/find-by-id?value=" + surveyorId, Surveyor.class);
        
        return null;
    }

}
