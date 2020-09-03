/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.surveyservice.repository;

import com.demo.surveyservice.model.Survey;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Steven Raylianto K.
 */
@Repository
public interface SurveyRepository extends CrudRepository<Survey, Long> {
    
}
