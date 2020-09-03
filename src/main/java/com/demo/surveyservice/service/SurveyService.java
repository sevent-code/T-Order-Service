/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.surveyservice.service;

import com.demo.surveyservice.model.Survey;
import java.util.List;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Steven Raylianto K.
 */
public interface SurveyService {
    Survey createSurvey(Survey survey);
    Survey updateSurvey(Long id, Survey survey);
    void deleteSurvey(Long id);
    List<Survey> getSurveys(Long surveyorId);
}
