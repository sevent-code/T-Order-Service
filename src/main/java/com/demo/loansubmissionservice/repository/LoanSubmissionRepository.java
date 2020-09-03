/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.loansubmissionservice.repository;

import com.demo.loansubmissionservice.model.LoanSubmission;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Steven Raylianto K.
 */
public interface LoanSubmissionRepository extends CrudRepository<LoanSubmission, Long> {
    
}
