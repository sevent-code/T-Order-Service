/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.surveyservice.controller;

import com.demo.surveyservice.dto.ApiResponse;
import com.demo.surveyservice.dto.RequestCreateSurvey;
import com.demo.surveyservice.dto.ResponseListSurvey;
import com.demo.surveyservice.enums.StatusSurvey;
import com.demo.surveyservice.exception.MyResourceNotFoundException;
import com.demo.surveyservice.model.Survey;
import com.demo.surveyservice.service.SurveyServiceImpl;
import com.demo.surveyservice.utility.MyUtil;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Steven Raylianto K.
 */
@RestController
@RequestMapping("/order")
public class SurveyController {

    @Autowired
    private SurveyServiceImpl surveyService;
    
    @GetMapping("/find-survey-by-surveyor-id")
    @ApiOperation(value = "Find survey by surveyor id", response = Survey.class)
    public Survey findSurveyBySurveyorId(@RequestParam("value") Long value, HttpServletRequest http) throws Exception {
        System.out.println("Request From " + http.getRemoteAddr() + " on " + http.getServletPath());
        
        return surveyService.findSurveyBySurveyId(value);
    }
    
    @GetMapping("/find-surveys-by-surveyor-id")
    @ApiOperation(value = "Find list survey by surveyor id", response = ApiResponse.class)
    public ApiResponse findSurveysBySurveyorId(@RequestParam("value") Long value, HttpServletRequest http) throws Exception {
        System.out.println("Request From " + http.getRemoteAddr() + " on " + http.getServletPath());
        
        List<Survey> surveys = surveyService.findSurveysBySurveyorId(value);
        ResponseListSurvey wrapperSurveys = new ResponseListSurvey(surveys);
        return MyUtil.buildResponseWrapper("Fetch successfull", wrapperSurveys);

    }

    @PostMapping("/create")
    @ApiOperation(value = "Create a new survey", response = ApiResponse.class)
    public ApiResponse createSurvey(@RequestBody RequestCreateSurvey requestData, HttpServletRequest http) throws Exception {
        System.out.println("Request From " + http.getRemoteAddr() + " on " + http.getServletPath());
        System.out.println("Data -> " + requestData.toString());

        Survey survey = surveyService.createSurvey(requestData);
        return MyUtil.buildResponseWrapper("Survey created successfull", survey);
    }
}
