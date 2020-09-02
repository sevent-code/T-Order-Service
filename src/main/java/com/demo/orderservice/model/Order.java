/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.orderservice.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.annotations.Type;

/**
 *
 * @author Steven Raylianto K.
 */
@Entity
@Table(name = "loan_order")
public class Order implements Serializable {

    private Long id;
    private String description;
    private Double latitude;
    private Double longitude;
    private LocalDateTime createDateTime;
    private Surveyor surveyor;

    public Order() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "order_seq")
    @SequenceGenerator(name = "order_seq", sequenceName = "order_seq", initialValue = 1, allocationSize = 1)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    @Column(name = "name")
    @Type(type = "text")
    public String getDescription() {
        return description;
    }

    @Column(name = "latitude")
    public Double getLatitude() {
        return latitude;
    }

    @Column(name = "longitude")
    public Double getLongitude() {
        return longitude;
    }

    @Column(name = "cr_date_time", columnDefinition = "TIMESTAMP")
    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    @ManyToOne
    @JoinColumn(name = "surveyor", referencedColumnName = "id")
    public Surveyor getSurveyor() {
        return surveyor;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }

    public void setSurveyor(Surveyor surveyor) {
        this.surveyor = surveyor;
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", description=" + description + ", latitude=" + latitude + ", longitude=" + longitude + ", createDateTime=" + createDateTime + ", surveyor=" + surveyor + '}';
    }

}
