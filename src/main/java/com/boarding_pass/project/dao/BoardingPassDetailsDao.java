package com.boarding_pass.project.dao;

import com.boarding_pass.project.entity.BoardingPassDetails;

import java.util.List;

public interface BoardingPassDetailsDao {

    public List<BoardingPassDetails> listBoardingPassDetails();

    public void addBoardingPassDetails(BoardingPassDetails boardingPassDetails);

    public BoardingPassDetails getBoardingPassDetailsById(int id);

    public void deleteBoardingPassDetailsById(int id);

    public void updateBoardingPassDetails(BoardingPassDetails boardingPassDetails, int id);
}
