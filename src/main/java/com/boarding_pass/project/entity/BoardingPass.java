package com.boarding_pass.project.entity;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Date;

//this class is mapped to a table in the database
@Entity
@Table(name = "boarding_pass")
public class BoardingPass {

    //the fields below are mapped to columns in the database
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "boardingPass_id")
    private int id;

    @Column(name = "boardingPass_number")
    private long boardingPassNumber;

    @Column(name = "date_added")
    @UpdateTimestamp
    private Date date;

    //foreign key column with boardingPassDetails_id
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "boardingPassDetails_id")
    private BoardingPassDetails boardingPassDetails;

    //constructor section
    public BoardingPass() {
    }

    public BoardingPass(long boardingPassNumber) {
        this.boardingPassNumber = boardingPassNumber;
    }

    //getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getBoardingPassNumber() {
        return boardingPassNumber;
    }

    public void setBoardingPassNumber(long boardingPassNumber) {
        this.boardingPassNumber = boardingPassNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BoardingPassDetails getBoardingPassDetails() {
        return boardingPassDetails;
    }

    @Autowired
    public void setBoardingPassDetails(BoardingPassDetails boardingPassDetails) {
        this.boardingPassDetails = boardingPassDetails;
    }

    //override the toString() method
    @Override
    public String toString() {
        return "BoardingPass{" +
                "id=" + id +
                ", boardingPassNumber=" + boardingPassNumber +
                ", date=" + date +
                ", boardingPassDetails=" + boardingPassDetails +
                '}';
    }
}
