package com.boarding_pass.project.service;

import com.boarding_pass.project.entity.BoardingPass;
import com.boarding_pass.project.entity.BoardingPassDetails;

import java.util.List;

public interface BoardingPassDetailsService {

    public List<BoardingPassDetails> listBoardingPassDetails();

    public void addBoardingPassDetails(BoardingPassDetails boardingPassDetails);

    public BoardingPassDetails getBoardingPassDetailsById(int id);

    public void deleteBoardingPassDetailsById(int id);

    public void updateBoardingPassDetails(BoardingPassDetails boardingPassDetails, int id);

}
