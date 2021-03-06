package com.boarding_pass.project.entity;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

//this class is mapped to a table in the database
@Entity
@Table(name = "user")
public class User {

    //the fields below are mapped to columns in the database
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int Id;

    @Column(name = "Name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private long phoneNumber;

    @Column(name = "gender")
    private char gender;

    @Column(name = "age")
    private int age;

    //foreign key column with boardingPass_id
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "boardingPass_id")
    private BoardingPass boardingPass;

    //constructor section
    public User(){
    }

    public User(String toName){
        this.name = toName;
    }

    public User(String name, String email, long phoneNumber, char gender, int age) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.age = age;
    }

    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public BoardingPass getBoardingPass() {
        return boardingPass;
    }

    @Autowired
    public void setBoardingPass(BoardingPass boardingPass) {
        this.boardingPass = boardingPass;
    }

    //override the toString() method
    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", gender=" + gender +
                ", age=" + age +
                ", boardingPass=" + boardingPass +
                "'}'\n";
    }
}
