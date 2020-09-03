/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.surveyservice.dto;

import com.demo.surveyservice.model.Survey;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Steven Raylianto K.
 */
public class ResponseListSurvey {

    private List<Survey> surveys;

    public ResponseListSurvey() {
    }

    public ResponseListSurvey(List<Survey> surveys) {
        this.surveys = surveys;
    }

    public List<Survey> getSurveys() {
        return surveys;
    }

    public void setSurveys(List<Survey> surveys) {
        this.surveys = surveys;
    }

    @Override
    public String toString() {
        return "ResponseListSurvey{" + "surveys=" + surveys + '}';
    }

}
