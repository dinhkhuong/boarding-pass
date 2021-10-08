package com.boarding_pass.project.entity;

import javax.persistence.*;
import java.text.SimpleDateFormat;

@Entity
@Table(name = "boarding_pass_details")
public class BoardingPassDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "origin")
    private String origin;

    @Column(name = "destination")
    private String destination;

    @Column(name = "eta")
    private SimpleDateFormat estimatedTimeOfArrival;

    @Column(name = "departure_time")
    private SimpleDateFormat departureTime;

    public BoardingPassDetails(int id) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public SimpleDateFormat getEstimatedTimeOfArrival() {
        return estimatedTimeOfArrival;
    }

    public void setEstimatedTimeOfArrival(SimpleDateFormat estimatedTimeOfArrival) {
        this.estimatedTimeOfArrival = estimatedTimeOfArrival;
    }

    public SimpleDateFormat getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(SimpleDateFormat departureTime) {
        this.departureTime = departureTime;
    }
}
