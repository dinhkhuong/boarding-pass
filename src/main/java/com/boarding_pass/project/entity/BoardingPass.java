package com.boarding_pass.project.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "boarding_pass")
public class BoardingPass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "boardingPass_id")
    private int id;

    @Column(name = "boardingPass_number")
    private long boardingPassNumber;

    @Column(name = "date_added")
    private Date date;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "boardingPassDetails_id")
    private BoardingPassDetails boardingPassDetails;

    public BoardingPass(int id) {
    }

    public BoardingPass(long boardingPassNumber) {
        this.boardingPassNumber = boardingPassNumber;
    }

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

    public void setBoardingPassDetails(BoardingPassDetails boardingPassDetails) {
        this.boardingPassDetails = boardingPassDetails;
    }
}
