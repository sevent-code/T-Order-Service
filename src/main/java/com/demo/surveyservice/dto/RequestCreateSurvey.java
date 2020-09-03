/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.surveyservice.dto;

import java.math.BigDecimal;

/**
 *
 * @author Steven Raylianto K.
 */
public class RequestCreateSurvey {

    private String description;
    private String profileAddress;
    private Long surveyorId;

    public RequestCreateSurvey() {
    }

    public Long getSurveyorId() {
        return surveyorId;
    }

    public void setSurveyorId(Long surveyorId) {
        this.surveyorId = surveyorId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProfileAddress() {
        return profileAddress;
    }

    public void setProfileAddress(String profileAddress) {
        this.profileAddress = profileAddress;
    }

    @Override
    public String toString() {
        return "RequestCreateSurvey{" + "description=" + description + ", profileAddress=" + profileAddress + ", surveyorId=" + surveyorId + '}';
    }

}
