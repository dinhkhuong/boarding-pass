package com.boarding_pass.project.entity;

import javax.persistence.*;
import java.util.Date;

//this class is mapped to a table in the database
@Entity
@Table(name = "boarding_pass_details")
public class BoardingPassDetails {

    //the fields below are mapped to columns in the database
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "origin")
    private String origin;

    @Column(name = "destination")
    private String destination;

    @Column(name = "eta")
    private Date estimatedTimeOfArrival;

    @Column(name = "departure_time")
    private Date departureTime;

    //constructor section
    public BoardingPassDetails() {
    }

    public BoardingPassDetails(String origin, String destination, Date estimatedTimeOfArrival, Date departureTime) {
        this.origin = origin;
        this.destination = destination;
        this.estimatedTimeOfArrival = estimatedTimeOfArrival;
        this.departureTime = departureTime;
    }

    //getters and setters
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

    public Date getEstimatedTimeOfArrival() {
        return estimatedTimeOfArrival;
    }

    public void setEstimatedTimeOfArrival(Date estimatedTimeOfArrival) {
        this.estimatedTimeOfArrival = estimatedTimeOfArrival;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    //override the toString() method
    @Override
    public String toString() {
        return "BoardingPassDetails{" +
                "id=" + id +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", estimatedTimeOfArrival=" + estimatedTimeOfArrival +
                ", departureTime=" + departureTime +
                '}';
    }
}
